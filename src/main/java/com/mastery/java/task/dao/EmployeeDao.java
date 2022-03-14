package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import com.mastery.java.task.dto.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class EmployeeDao implements IEmployeeDao{
    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(){}

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addEmployee(Employee employee) {
        String SQL = "INSERT INTO employees (first_name, last_name, department_id, job_title, gender) VALUES (?, ?, ?, ?, ?)";

        Object[] arguments = new Object[]{
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTitle(),
                employee.getGender()
        };

        int[] argumentTypes = new int[]{
                Types.VARCHAR,
                Types.VARCHAR,
                Types.BIGINT,
                Types.OTHER,
                Types.OTHER
        };

        return jdbcTemplate.update(SQL, arguments, argumentTypes);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String SQL = "SELECT * FROM employees ORDER BY id";

        RowMapper<Employee> rowMapper = ((resultSet, i) ->
                new Employee(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getLong("department_id"),
                    JobTitle.valueOf(resultSet.getString("job_title")),
                    Gender.valueOf(resultSet.getString("gender"))
                ));

        return jdbcTemplate.query(SQL, rowMapper);
    }

    @Override
    public Employee getEmployeeById(long id) {
        String SQL = "SELECT * FROM employees WHERE id = ?";
        Object[] obj = new Object[]{id};

        RowMapper<Employee> rowMapper = ((resultSet, i) ->
                new Employee(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getLong("department_id"),
                        JobTitle.valueOf(resultSet.getString("job_title")),
                        Gender.valueOf(resultSet.getString("gender"))
                ));

        return jdbcTemplate.queryForObject(SQL, obj, rowMapper);
    }

    @Override
    public int updateEmployee(Employee employee, long id) {
        String SQL = "UPDATE employees SET first_name = ?, last_name = ?, department_id = ?, job_title = ?, gender = ? WHERE id = ?";
        Object[] arguments = new Object[]{
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTitle(),
                employee.getGender(),
                id
        };

        int[] argumentTypes = new int[]{
                Types.VARCHAR,
                Types.VARCHAR,
                Types.BIGINT,
                Types.OTHER,
                Types.OTHER,
                Types.BIGINT
        };

        return jdbcTemplate.update(SQL, arguments, argumentTypes);
    }

    @Override
    public int deleteEmployee(long id) {
        String SQL = "DELETE FROM employees WHERE id=?";
        return jdbcTemplate.update(SQL, id);
    }
}
