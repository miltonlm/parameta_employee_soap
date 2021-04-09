package com.parameta.employee.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * EmployeeRepository is the repository for the Employee entity.
 * */

@Component
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
