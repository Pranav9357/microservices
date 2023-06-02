package com.example.departmentservice.repository;

import com.example.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class DepartmentRepository {

    private List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(int id) {
        return departments.stream()
                .filter(department -> department.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findALl() {
        return departments;
    }
}
