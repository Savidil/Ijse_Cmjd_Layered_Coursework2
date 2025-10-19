package edu.ijse.layered.service;

import edu.ijse.layered.service.custom.impl.UserServiceImpl;
import edu.ijse.layered.service.custom.impl.CourseServiceImpl;
import edu.ijse.layered.service.custom.impl.StudentServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    
    private ServiceFactory() {}
    
    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }
    
    public SuperService getService(ServiceType type) {
        switch (type) {
            case USER:
                return new UserServiceImpl();
            case COURSE:
                return new CourseServiceImpl();
            case STUDENT:
                return new StudentServiceImpl();
            default:
                return null;
        }
    }
    
    public enum ServiceType {
        USER, COURSE, STUDENT, LECTURER, SUBJECT, CLASS_SESSION, ATTENDANCE
    }
}