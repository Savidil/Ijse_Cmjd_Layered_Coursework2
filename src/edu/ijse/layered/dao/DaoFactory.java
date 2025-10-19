package edu.ijse.layered.dao;

import edu.ijse.layered.dao.custom.impl.UserDAOImpl;
import edu.ijse.layered.dao.custom.impl.CourseDAOImpl;
import edu.ijse.layered.dao.custom.impl.StudentDAOImpl;

public class DaoFactory {
    private static DaoFactory instance;
    
    private DaoFactory() {}
    
    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }
    
    public SuperDAO getDao(DaoType type) {
        switch (type) {
            case USER:
                return new UserDAOImpl();
            case COURSE:
                return new CourseDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            default:
                return null;
        }
    }
    
    public enum DaoType {
        USER, COURSE, STUDENT, LECTURER, SUBJECT, CLASS_SESSION, ATTENDANCE
    }
}