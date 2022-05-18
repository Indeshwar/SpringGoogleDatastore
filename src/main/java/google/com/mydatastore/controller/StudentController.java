package google.com.mydatastore.controller;

import google.com.mydatastore.model.Student;
import google.com.mydatastore.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;



    @PostMapping("/save")
    public void saveStudent(@RequestBody Student student) throws IOException {
        studentService.createStudent(student);
    }
}
