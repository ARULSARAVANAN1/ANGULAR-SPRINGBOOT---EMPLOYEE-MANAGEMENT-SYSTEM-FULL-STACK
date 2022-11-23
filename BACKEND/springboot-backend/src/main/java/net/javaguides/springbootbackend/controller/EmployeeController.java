package net.javaguides.springbootbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import net.javaguides.springbootbackend.exception.ResourceNotFoundException;
import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
  
  @Autowired
  private EmployeeRepository employeeRepository;

  //get all employees

  @GetMapping("/employees")
  public List<Employee> getAll()
  {
    return employeeRepository.findAll();
  }

  //create
  @PostMapping("/employees")
  public Employee creatEmployee(@RequestBody Employee employee){
    return employeeRepository.save(employee);
  }

  //retriving the infos
  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
    Employee employee = employeeRepository.findById(id).
                        orElseThrow(() -> new ResourceNotFoundException("Employee not existedd for id:"+id));
    return ResponseEntity.ok(employee);
  }

  //update the infos
  @PutMapping("/employees/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeedetails) {
    Employee employee = employeeRepository.findById(id).
                        orElseThrow(() -> new ResourceNotFoundException("Employee not existedd for id:"+id));
    
    employee.setFirstname(employeedetails.getFirstname());
    employee.setLastname(employeedetails.getLastname());
    employee.setEmailId(employeedetails.getEmailId());

    Employee updatedEmployee = employeeRepository.save(employee);
    return ResponseEntity.ok(updatedEmployee);
  }

  //delete  the employee infos
  @DeleteMapping("/employees/{id}")
  public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
  
    Employee employee = employeeRepository.findById(id).
    orElseThrow(() -> new ResourceNotFoundException("Employee not existedd for id:"+id));

    employeeRepository.delete(employee);
    Map<String,Boolean> response = new HashMap<>();
    response.put("deleted",Boolean.TRUE);
    return ResponseEntity.ok(response);
  }
}
