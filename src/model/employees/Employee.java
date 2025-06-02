package model.employees;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Employee {
    private final String employeeId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDate hireDate;
    private double salary;
    private boolean active;

    public Employee(String firstName, String lastName, LocalDate dateOfBirth, String address,
                   String phoneNumber, String email, LocalDate hireDate, double salary) {
        this.employeeId = "EMP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
        this.active = true;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getYearsOfService() {
        return LocalDate.now().getYear() - hireDate.getYear();
    }

    public abstract double calculateBonus();

    public abstract String getJobTitle();

    @Override
    public String toString() {
        return getJobTitle() + " {" +
                "id='" + employeeId + '\'' +
                ", name='" + getFullName() + '\'' +
                ", hired=" + hireDate +
                ", active=" + active +
                '}';
    }
}