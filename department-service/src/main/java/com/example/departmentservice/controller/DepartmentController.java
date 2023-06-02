package com.example.departmentservice.controller;

import com.example.departmentservice.client.EmployeeClient;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.netflix.discovery.converters.Auto;
import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department) {
        LOGGER.info("Department add : {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("/getAllDepartment")
    public List<Department> getAllDepartment() {
        System.out.println("department");
        LOGGER.info("Department find");
        return departmentRepository.findALl();
    }

    @GetMapping("/getDepartmentById/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        LOGGER.info("Department find : id={}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/withEmployees")
    public List<Department> withEmployees() {
        LOGGER.info("Department find");
        List<Department> departments = departmentRepository.findALl();
        departments.forEach(department ->
                department.setEmployees(
                        employeeClient.findByDepartment(department.getId())
                ));
        return departments;
    }
}
