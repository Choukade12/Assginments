package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value="api/v1/EmployeeOp")
public class EmployeeController {
    @Autowired
    EmployeeService esi;
    @PostMapping(value="/saveEmployee", consumes = "application/json")
    public ResponseEntity<Employee> addEmployee(Employee emp){
        Employee emp1 = esi.create(emp);
        return ResponseEntity.status(201).body(emp1);
    }

    @PutMapping(value="/employeeUpdate", consumes = "application/json")
    public ResponseEntity<Employee> updateEmployee(@PathVariable UUID id, @RequestBody Employee emp){
       Employee emp1 = esi.read(id);
       emp.setEmpId(emp1.getEmpId());
       emp.setFirstName(emp1.getFirstName());
       emp.setMiddleName(emp1.getMiddleName());
       emp.setLastName(emp1.getLastName());
       emp.setEmail(emp1.getEmail());
       emp.setPhoneNum(emp1.getPhoneNum());
       emp.setAdd(emp1.getAdd());
       return ResponseEntity.status(202).body(emp);
    }
}
