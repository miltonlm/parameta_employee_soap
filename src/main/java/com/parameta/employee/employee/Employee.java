package com.parameta.employee.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Employee entity model
 * */

@Entity
public class Employee {

    /**
     * Field declaration for the Spring Data framework.
     * */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name is required")
    @Size(min = 2, message = "name length must be greater than 1")
    private String name;
    @NotBlank(message = "lastName is required")
    @Size(min = 2, message = "lastName length must be greater than 1")
    private String lastName;
    @NotBlank(message = "identificationType is required")
    private String identificationType;
    @NotBlank(message = "identification is required")
    private String identification;
    @NotNull(message = "birthDate can not be null and valid format must be sent [yyyy-mm-dd]")
    private Date birthDate;
    @NotNull(message = "employmentDate can not be null and valid format must be sent [yyyy-mm-dd]")
    private Date employmentDate;
    @NotBlank(message = "position is required")
    private String position;
    @NotNull(message = "salary is required")
    @Min(value = 1, message = "salary must be greater than 0")
    private Double salary;

    /**
     * Default constructor, does nothing.
     * */
    public Employee() {
    }

    /**
     * Constructor to initialize all variables.
     *
     * @param id ID of the employee.
     * @param name Name of the employee.
     * @param lastName Last name of the employee.
     * @param identificationType Identification type of the employee.
     * @param identification Identification of the employee.
     * @param birthDate Birth date of the employee.
     * @param employmentDate Employment date of the employee.
     * @param position Position on the company of the employee.
     * @param salary Current salary of the employee.
     */
    public Employee(Long id, String name, String lastName, String identificationType, String identification, Date birthDate, Date employmentDate, String position, Double salary) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identificationType = identificationType;
        this.identification = identification;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.position = position;
        this.salary = salary;
    }

    /**
     * Getter for the id.
     * @return Long the id.
     * */
    public Long getId() {
        return id;
    }

    /**
     * Setter for the id.
     * @param id Long the id to set.
     * */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for the name.
     * @return String the name.
     * */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name.
     * @param name String the name to set.
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the lastName.
     * @return String the lastName to set.
     * */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the lastName.
     * @param lastName the lastName of the employee.
     * */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the identificationType.
     * @return String the identificationType.
     * */
    public String getIdentificationType() {
        return identificationType;
    }

    /**
     * Setter for the identificationType.
     * @param identificationType The identificationType to set.
     * */
    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    /**
     * Getter for the identification.
     * @return String the identification.
     * */
    public String getIdentification() {
        return identification;
    }

    /**
     * Setter for the identification.
     * @param identification String the identification to set.
     * */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * Getter for the birthDate.
     * @return Date the birthDate.
     * */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Setter for the birthDate.
     * @param birthDate Date the Birthdate.
     * */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Getter for the employmentDate.
     * @return Date the employmentDate.
     * */
    public Date getEmploymentDate() {
        return employmentDate;
    }

    /**
     * Setter for the employmentDate.
     * @param employmentDate Date the employmentDate to set.
     * */
    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    /**
     * Getter for the position.
     * @return String the position.
     * */
    public String getPosition() {
        return position;
    }

    /**
     * Setter for the position.
     * @param position String position to set.
     * */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Getter for the salary.
     * @return Double the salary.
     * */
    public Double getSalary() {
        return salary;
    }

    /**
     * Setter for the salary.
     * @param salary Double the salary.
     * */
    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
