package com.example.employeeservice.repository;

import com.example.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.id() == id)
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> getAllEmployee() {
        return employees;
    }

    public List<Employee> findByDepartment(int departmentId) {
        return employees.stream()
                .filter(employee -> employee.departmentId() == departmentId)
                .toList();
    }
}
