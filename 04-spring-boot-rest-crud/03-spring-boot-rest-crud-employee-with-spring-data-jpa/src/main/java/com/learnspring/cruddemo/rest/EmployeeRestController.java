package com.learnspring.cruddemo.rest;

import com.learnspring.cruddemo.entity.Employee;
import com.learnspring.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // inject employee dao
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose "/employee" and return all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findALl();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    // add mapping for POST /employee - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead update

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found- " + employeeId);

        }
        employeeService.deleteById(employeeId);
        return"Deleted Employee id - " + employeeId;

    }
}
