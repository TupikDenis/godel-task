package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface IEmployeeService {
    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    boolean updateEmployee(Employee employee, long id);
    boolean deleteEmployee(long id);
}
