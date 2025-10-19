package edu.ijse.layered.service.custom;

import edu.ijse.layered.dto.UserDTO;
import edu.ijse.layered.service.SuperService;

public interface UserService extends SuperService<UserDTO> {
    UserDTO findByUsername(String username) throws Exception;
    boolean authenticate(String username, String password) throws Exception;
}