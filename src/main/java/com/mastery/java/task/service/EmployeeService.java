package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService{
    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    boolean updateEmployee(Employee employee, long id);
    boolean deleteEmployee(long id);
}
