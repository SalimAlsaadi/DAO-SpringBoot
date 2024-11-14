package com.myFirstApp.testApp.DAO;

import com.myFirstApp.testApp.entity.student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentDAO {

    void save(student student);
    String deleteStudentByID(int id);
    student findById(Integer id);
    List<student> findAll();
    List<student> findByLastName(String lastName);
    student updateDetails(int id,student student);
}
