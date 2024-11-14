package com.myFirstApp.testApp.DAO;

import com.myFirstApp.testApp.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    ResponseEntity<Employee> postNewEmployee(Employee employee);
    Employee updateDetails(Employee employee);
     void deleteEmployee(int id);

}
