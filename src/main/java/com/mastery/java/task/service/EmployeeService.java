package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Override
    public void addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(long id){
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public boolean updateEmployee(Employee employee, long id){
        int numberRows = employeeDao.updateEmployee(employee, id);
        return numberRows != 0;
    }

    @Override
    public boolean deleteEmployee(long id){
        int numberRows = employeeDao.deleteEmployee(id);
        return numberRows != 0;
    }
}
