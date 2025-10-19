package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.CourseDAO;
import edu.ijse.layered.dto.CourseDTO;
import edu.ijse.layered.entity.Course;
import edu.ijse.layered.service.custom.CourseService;

import java.util.ArrayList;

public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO = (CourseDAO) DaoFactory.getInstance().getDao(DaoFactory.DaoType.COURSE);

    @Override
    public boolean save(CourseDTO courseDTO) throws Exception {
        Course course = new Course(
            courseDTO.getCourseId(),
            courseDTO.getCourseName(),
            courseDTO.getCourseDuration(),
            courseDTO.getCourseFee(),
            courseDTO.getStatus()
        );
        return courseDAO.save(course);
    }

    @Override
    public boolean update(CourseDTO courseDTO) throws Exception {
        Course course = new Course(
            courseDTO.getCourseId(),
            courseDTO.getCourseName(),
            courseDTO.getCourseDuration(),
            courseDTO.getCourseFee(),
            courseDTO.getStatus()
        );
        return courseDAO.update(course);
    }

    @Override
    public boolean delete(String courseId) throws Exception {
        return courseDAO.delete(courseId);
    }

    @Override
    public CourseDTO find(String courseId) throws Exception {
        Course course = courseDAO.find(courseId);
        if (course != null) {
            return new CourseDTO(
                course.getCourseId(),
                course.getCourseName(),
                course.getCourseDuration(),
                course.getCourseFee(),
                course.getStatus()
            );
        }
        return null;
    }

    @Override
    public ArrayList<CourseDTO> getAll() throws Exception {
        ArrayList<Course> courses = courseDAO.getAll();
        ArrayList<CourseDTO> courseDTOs = new ArrayList<>();
        
        for (Course course : courses) {
            courseDTOs.add(new CourseDTO(
                course.getCourseId(),
                course.getCourseName(),
                course.getCourseDuration(),
                course.getCourseFee(),
                course.getStatus()
            ));
        }
        return courseDTOs;
    }
}