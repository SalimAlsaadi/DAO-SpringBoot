package com.myFirstApp.testApp.Controller;

import com.myFirstApp.testApp.DAO.EmployeeDAOImplement;
import com.myFirstApp.testApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeDAOImplement employeeDAOImplement;

    @Autowired
    public EmployeeController(EmployeeDAOImplement employeeDAOImplement) {
        this.employeeDAOImplement = employeeDAOImplement;
    }

    @PostMapping()
    public ResponseEntity<Employee> postNewEmployee(@RequestBody Employee employee){
        ResponseEntity<Employee> emp=employeeDAOImplement.postNewEmployee(employee);
        return emp;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmp(@PathVariable int id){
       employeeDAOImplement.deleteEmployee(id);

    }

    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee){
       Employee update= employeeDAOImplement.updateDetails(employee);
        return update;
    }
}
