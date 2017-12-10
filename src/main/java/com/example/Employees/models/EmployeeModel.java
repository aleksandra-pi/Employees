package com.example.Employees.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;

@Data
@Entity
@Table (name="employee")
@NoArgsConstructor
public class EmployeeModel {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String position;

}