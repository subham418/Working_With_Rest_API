package com.javaguides.Springbootbackend.controller;

import com.javaguides.Springbootbackend.exception.ResourceNotFoundException;
import com.javaguides.Springbootbackend.model.Employee;
import com.javaguides.Springbootbackend.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("testing")
public class EmployeeController {
    @Autowired
    private ApiRepository apiRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return apiRepository.findAll();
    }

    // build create api
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return apiRepository.save(employee);
    }

    //build get employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById( @PathVariable long id){
        Employee employee=apiRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Employee not exists with id:"+id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee( @PathVariable long id, @RequestBody Employee employeeDetails){
        Employee employee=apiRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Employee not exists with id:"+id));
        employee.setFirst_name(employeeDetails.getFirst_name());
        employee.setLast_name(employeeDetails.getLast_name());
        employee.setEmail_id(employeeDetails.getEmail_id());

        apiRepository.save(employee);

        return ResponseEntity.ok(employee);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Employee> updateEmployeeByPatch(@PathVariable long id,@RequestBody Employee employee){
        Employee newEmployee=apiRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not Exists with id: "+id));
        if(employee.getFirst_name()!=null) newEmployee.setFirst_name(employee.getFirst_name());
        if(employee.getLast_name()!=null) newEmployee.setLast_name(employee.getLast_name());
        if(employee.getEmail_id()!=null) newEmployee.setEmail_id(employee.getEmail_id());

        apiRepository.save(newEmployee);
        return ResponseEntity.ok(newEmployee);
    }

    // build delete rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee( @PathVariable long id){
        Employee employee=apiRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee not found with id:"+id));
        apiRepository.delete(employee);
        return ResponseEntity.ok("Employee with id "+id+" deleted Successfully");
    }
}
