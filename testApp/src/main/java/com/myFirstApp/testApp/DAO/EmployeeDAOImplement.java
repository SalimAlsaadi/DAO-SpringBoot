package com.myFirstApp.testApp.DAO;

import com.myFirstApp.testApp.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImplement implements EmployeeDAO{

    private EntityManager entityManager;

    public EmployeeDAOImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return List.of();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<Employee> postNewEmployee(Employee employee) {
          entityManager.persist(employee);
          return ResponseEntity.ok(employee);
    }

    @Override
    @Transactional
    public Employee updateDetails(Employee employee) {
       //Employee getEmp=entityManager.find(Employee.class,employee.getId());
       entityManager.merge(employee);
        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        Employee emp=entityManager.find(Employee.class, id);
        entityManager.remove(emp);
    }
}
