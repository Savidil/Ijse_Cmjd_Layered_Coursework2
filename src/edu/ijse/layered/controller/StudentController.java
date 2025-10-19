package edu.ijse.layered.controller;

import edu.ijse.layered.dto.StudentDTO;
import edu.ijse.layered.service.ServiceFactory;
import edu.ijse.layered.service.custom.StudentService;

import java.util.ArrayList;

public class StudentController {
    private final StudentService studentService = (StudentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUDENT);
    
    public boolean saveStudent(String studentId, String firstName, String lastName, String email, 
                             String phone, String address, String courseId, String regDate) throws Exception {
        StudentDTO studentDTO = new StudentDTO(studentId, firstName, lastName, email, phone, address, courseId, regDate);
        return studentService.save(studentDTO);
    }
    
    public boolean updateStudent(String studentId, String firstName, String lastName, String email, 
                               String phone, String address, String courseId, String regDate) throws Exception {
        StudentDTO studentDTO = new StudentDTO(studentId, firstName, lastName, email, phone, address, courseId, regDate);
        return studentService.update(studentDTO);
    }
    
    public boolean deleteStudent(String studentId) throws Exception {
        return studentService.delete(studentId);
    }
    
    public StudentDTO findStudent(String studentId) throws Exception {
        return studentService.find(studentId);
    }
    
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        return studentService.getAll();
    }
}