package com.example.Employees.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeForm {


    private String name;
    private String surname;
    private String email;
    private String position;
}
