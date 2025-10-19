package edu.ijse.layered.controller;

import edu.ijse.layered.service.ServiceFactory;
import edu.ijse.layered.service.custom.UserService;
import edu.ijse.layered.dto.UserDTO;

public class LoginController {
    private final UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);
    
    public UserDTO authenticate(String username, String password) throws Exception {
        if (userService.authenticate(username, password)) {
            return userService.findByUsername(username);
        }
        return null;
    }
}