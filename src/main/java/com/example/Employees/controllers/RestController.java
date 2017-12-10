package com.example.Employees.controllers;

import com.example.Employees.models.EmployeeModel;
import com.example.Employees.models.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class RestController {


    @Autowired
    EmployeeRepository employeeRepository;


    @RequestMapping(value = {"/rest"}, method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity employee (){
        return new ResponseEntity(employeeRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/rest/{name}"}, method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity showName(@PathVariable ("name") String name){
        return new ResponseEntity(employeeRepository.findByNameIgnoreCase(name), HttpStatus.OK);
    }

    @RequestMapping(value = {"/rest"}, method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity addEmployees (@RequestBody EmployeeModel model){
        employeeRepository.save(model);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = {"/rest/{id}/surname/{surname}"}, method = RequestMethod.PUT,
            produces = "application/json")
    public ResponseEntity editSurname (@PathVariable("id") int id, @PathVariable("surname") String surname) {
        List<EmployeeModel> model = employeeRepository.findById(id);

       model.get(0).setSurname(surname);
       employeeRepository.save(model.get(0));
       return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = {"/rest/{id}/name/{name}"}, method = RequestMethod.PUT,
            produces = "application/json")
    public ResponseEntity editName (@PathVariable("id") int id, @PathVariable("name") String name) {
        List<EmployeeModel> model = employeeRepository.findById(id);

        model.get(0).setName(name);
        employeeRepository.save(model.get(0));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = {"/rest/{id}/email/{email}"}, method = RequestMethod.PUT,
            produces = "application/json")
    public ResponseEntity editEmail (@PathVariable("id") int id, @PathVariable("email") String email) {
        List<EmployeeModel> model = employeeRepository.findById(id);

        model.get(0).setName(email);
        employeeRepository.save(model.get(0));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = {"/rest/{id}/position/{position}"}, method = RequestMethod.PUT,
            produces = "application/json")
    public ResponseEntity editPosition (@PathVariable("id") int id, @PathVariable("position") String position) {
        List<EmployeeModel> model = employeeRepository.findById(id);

        model.get(0).setName(position);
        employeeRepository.save(model.get(0));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = {"/rest/{id}"}, method = RequestMethod.DELETE,
            produces = "application/json")
    public ResponseEntity deleteEmployee(@PathVariable("id") int id){
        employeeRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = {"/rest"}, method = RequestMethod.PUT,
            produces = "application/json")
    public ResponseEntity editEmployees (@RequestBody EmployeeModel employeeModel){
        employeeRepository.save(employeeModel);
        return new ResponseEntity(HttpStatus.OK);
    }
}
