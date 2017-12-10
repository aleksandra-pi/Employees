package com.example.Employees.models.repositories;

import com.example.Employees.models.EmployeeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository <EmployeeModel, Integer> {
    List<EmployeeModel> findBySurname(String surname);
    List<EmployeeModel> findByEmail(String email);
    List<EmployeeModel> findByNameIgnoreCase(String name);
    List<EmployeeModel> findByPosition(String position);
    List<EmployeeModel> findById(int id);
}
