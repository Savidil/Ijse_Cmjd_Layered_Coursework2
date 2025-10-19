package edu.ijse.layered.controller;

import edu.ijse.layered.dto.CourseDTO;
import edu.ijse.layered.service.ServiceFactory;
import edu.ijse.layered.service.custom.CourseService;

import java.util.ArrayList;

public class CourseController {
    private final CourseService courseService = (CourseService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.COURSE);
    
    public boolean saveCourse(String courseId, String courseName, String duration, double fee, String status) throws Exception {
        CourseDTO courseDTO = new CourseDTO(courseId, courseName, duration, fee, status);
        return courseService.save(courseDTO);
    }
    
    public boolean updateCourse(String courseId, String courseName, String duration, double fee, String status) throws Exception {
        CourseDTO courseDTO = new CourseDTO(courseId, courseName, duration, fee, status);
        return courseService.update(courseDTO);
    }
    
    public boolean deleteCourse(String courseId) throws Exception {
        return courseService.delete(courseId);
    }
    
    public CourseDTO findCourse(String courseId) throws Exception {
        return courseService.find(courseId);
    }
    
    public ArrayList<CourseDTO> getAllCourses() throws Exception {
        return courseService.getAll();
    }
}