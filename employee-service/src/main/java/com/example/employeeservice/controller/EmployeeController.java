package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        LOGGER.info("Employee add : {}", employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        LOGGER.info("Employee find");
        return employeeRepository.getAllEmployee();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        LOGGER.info("Employee find : id={}", id);
        return employeeRepository.getEmployeeById(id);
    }

    @GetMapping("/findDepartment/{id}")
    public List<Employee> findByDepartment(@PathVariable int id) {
        LOGGER.info("Employee find : departmentId={}", id);
        return employeeRepository.findByDepartment(id);
    }

}
