package com.parameta.employee.employee;

import com.parameta.employee.util.Utilities;
import com.parameta.soap.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Endpoint process class for the SOAP service.
 * */
@Endpoint
public class EmployeeEndpoint {
    private static final String NAMESPACE_URI = "http://parameta.com/soap";
    final EmployeeRepository employeeRepository;
    final Utilities utilities;

    /**
     * Class constructor to inject the autowired objects.
     *
     * @param employeeRepository EmployeeRepository repository for the crud operations of the Employee entity.
     * @param utilities Utilities utilities of the employee.
     * */
    @Autowired
    public EmployeeEndpoint(EmployeeRepository employeeRepository, Utilities utilities) {
        this.employeeRepository = employeeRepository;
        this.utilities = utilities;
    }

    /**
     * Endpoint method for the createEmployee.
     *
     * @param request CreateEmployeeRequest mapped with values.
     * @return CreateEmployeeResponse response for the soap service.
     * */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createEmployeeRequest")
    @ResponsePayload
    public CreateEmployeeResponse createEmployee(@RequestPayload CreateEmployeeRequest request) {
        try {
            CreateEmployeeResponse response = new CreateEmployeeResponse();
            StatusType status = new StatusType();
            ModelMapper modelMapper = new ModelMapper();
            Employee employeeEntity = modelMapper.map(request.getEmployee(), Employee.class);

            employeeEntity.setBirthDate(request.getEmployee().getBirthDate().toGregorianCalendar().getTime());
            employeeEntity.setEmploymentDate(request.getEmployee().getEmploymentDate().toGregorianCalendar().getTime());

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            List<String> errors = validator.validate(employeeEntity).stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());

            if (errors.size() == 0) {
                Employee newEmployeeEntity = employeeRepository.save(employeeEntity);
                EmployeeResponseType newEmployee = modelMapper.map(request.getEmployee(), EmployeeResponseType.class);

                LocalDate birthDate = newEmployeeEntity.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate employmentDate = newEmployeeEntity.getEmploymentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                newEmployee.setEmploymentTime(utilities.getPeriodDescription(birthDate, LocalDate.now()));
                newEmployee.setCurrentAge(utilities.getPeriodDescription(employmentDate, LocalDate.now()));

                newEmployee.setId(newEmployeeEntity.getId());
                status.setStatus("success");
                response.setEmployee(newEmployee);
            } else {
                status.setStatus("error");
                status.getErrors().addAll(errors);
            }

            response.setStatus(status);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
