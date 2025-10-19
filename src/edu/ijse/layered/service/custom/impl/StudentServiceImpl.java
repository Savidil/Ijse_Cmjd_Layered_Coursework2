package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.StudentDAO;
import edu.ijse.layered.dto.StudentDTO;
import edu.ijse.layered.entity.Student;
import edu.ijse.layered.service.custom.StudentService;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO = (StudentDAO) DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);

    @Override
    public boolean save(StudentDTO studentDTO) throws Exception {
        Student student = new Student(
            studentDTO.getStudentId(),
            studentDTO.getFirstName(),
            studentDTO.getLastName(),
            studentDTO.getEmail(),
            studentDTO.getPhone(),
            studentDTO.getAddress(),
            studentDTO.getCourseId(),
            studentDTO.getRegistrationDate()
        );
        return studentDAO.save(student);
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        Student student = new Student(
            studentDTO.getStudentId(),
            studentDTO.getFirstName(),
            studentDTO.getLastName(),
            studentDTO.getEmail(),
            studentDTO.getPhone(),
            studentDTO.getAddress(),
            studentDTO.getCourseId(),
            studentDTO.getRegistrationDate()
        );
        return studentDAO.update(student);
    }

    @Override
    public boolean delete(String studentId) throws Exception {
        return studentDAO.delete(studentId);
    }

    @Override
    public StudentDTO find(String studentId) throws Exception {
        Student student = studentDAO.find(studentId);
        if (student != null) {
            return new StudentDTO(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhone(),
                student.getAddress(),
                student.getCourseId(),
                student.getRegistrationDate()
            );
        }
        return null;
    }

    @Override
    public ArrayList<StudentDTO> getAll() throws Exception {
        ArrayList<Student> students = studentDAO.getAll();
        ArrayList<StudentDTO> studentDTOs = new ArrayList<>();
        
        for (Student student : students) {
            studentDTOs.add(new StudentDTO(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhone(),
                student.getAddress(),
                student.getCourseId(),
                student.getRegistrationDate()
            ));
        }
        return studentDTOs;
    }
}