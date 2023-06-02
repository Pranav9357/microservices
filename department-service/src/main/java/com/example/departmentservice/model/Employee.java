package com.example.departmentservice.model;

import java.util.UUID;

public record Employee(int id, int departmentId, String name, int age, String position) {
}
