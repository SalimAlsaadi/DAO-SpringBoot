package com.myFirstApp.testApp.Controller;

import com.myFirstApp.testApp.DAO.StudentDAO;
import com.myFirstApp.testApp.DAO.StudentDAOImeplent;
import com.myFirstApp.testApp.entity.StudentErrorResponse;
import com.myFirstApp.testApp.entity.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/api/Student")
public class StudentController {

    private StudentDAOImeplent studentDAOImeplent;


    @Autowired
    public StudentController(StudentDAOImeplent studentDAOImeplent) {
        this.studentDAOImeplent = studentDAOImeplent;
    }

    @PostMapping
    public String addStudent(@RequestBody student student){
        studentDAOImeplent.save(student);
        return "New Student Added";
    }

    @DeleteMapping
    public String removeStudent(int id){
        String result=studentDAOImeplent.deleteStudentByID(id);
        return result;
    }

    @GetMapping(path = "/id/{id}")
    public student getByID(@PathVariable int id){
       student student= studentDAOImeplent.findById(id);
       if(student!=null){
           return student;
       }
       else {
           throw new StudentNotFoundException("student id not found - "+ id);
       }

//        if(student==null){
//            throw new StudentNotFoundException("student id not found - "+ id);
//        }
//        return student;


    }

@GetMapping
    public List<student> getAllStudent(){
        return studentDAOImeplent.findAll();

}

     @GetMapping(path = "/lastName/{lastName}")
    public List<student> getStudentByL_Name(@PathVariable String lastName){
        return studentDAOImeplent.findByLastName(lastName);
}

    @PutMapping()
    public ResponseEntity<student> updateDetails(int id ,@RequestBody student student){
        student updateDetails=studentDAOImeplent.updateDetails(id,student);
        return ResponseEntity.ok(updateDetails);


}



}
