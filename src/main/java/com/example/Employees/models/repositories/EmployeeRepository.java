package com.example.Employees.models.repositories;

import com.example.Employees.models.EmployeeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository <EmployeeModel, Integer> {
    List<EmployeeModel> findByNameIgnoreCase(String name);
    List<EmployeeModel> findById(int id);
}
