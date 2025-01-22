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
        employee.setFname(employeeDetails.getFname());
        employee.setLname(employeeDetails.getLname());
        employee.setEmailid(employeeDetails.getEmailid());

        apiRepository.save(employee);

        return ResponseEntity.ok(employee);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Employee> updateEmployeeByPatch(@PathVariable long id,@RequestBody Employee employee){
        Employee newEmployee=apiRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not Exists with id: "+id));
        if(employee.getFname()!=null) newEmployee.setFname(employee.getFname());
        if(employee.getLname()!=null) newEmployee.setLname(employee.getLname());
        if(employee.getEmailid()!=null) newEmployee.setEmailid(employee.getEmailid());

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
