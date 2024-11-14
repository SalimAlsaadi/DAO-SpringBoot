package com.myFirstApp.testApp.DAO;

import com.myFirstApp.testApp.Controller.StudentNotFoundException;
import com.myFirstApp.testApp.entity.StudentErrorResponse;
import com.myFirstApp.testApp.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class StudentDAOImeplent implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImeplent(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(student student) {
        entityManager.persist(student);
    }


    @Override
    @Transactional
    public String deleteStudentByID(int id) {
        student student=entityManager.find(student.class, id);
        if(student==null){
           return "Not Found";
        }
       else {
            System.out.println(student.toString());
            entityManager.remove(student);
            return "has been deleted";
      }

    }


    @Override
    @Transactional
    public student findById(Integer id) {
     student student=entityManager.find(student.class, id);
     if(student!=null){
         return student;
     }
    else {
        return null;
     }

    }

    @Override
    @Transactional
    public List<student> findAll() {
        TypedQuery<student> student=entityManager.createQuery("select s from student s",student.class);
        return student.getResultList();
    }

    @Override
    @Transactional
    public List<student> findByLastName(String lastName) {
        TypedQuery<student> student=entityManager.createQuery("FROM student WHERE lastName=:lastName", student.class);
        student.setParameter("lastName", lastName);
        return student.getResultList();
    }

    @Override
    @Transactional
    public student updateDetails(int id, student updateStudent) {
        student getStudent=entityManager.find(student.class, id);
        getStudent.setFirstName(updateStudent.getFirstName());
        getStudent.setLastName(updateStudent.getLastName());
        entityManager.merge(getStudent);
        return getStudent;
    }


}
