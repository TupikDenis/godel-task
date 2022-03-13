package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface IEmployeeDao{
    int addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    int updateEmployee(Employee employee, long id);
    int deleteEmployee(long id);
}
