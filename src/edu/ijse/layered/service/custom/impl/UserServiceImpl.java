package edu.ijse.layered.service.custom.impl;

import edu.ijse.layered.dao.DaoFactory;
import edu.ijse.layered.dao.custom.UserDAO;
import edu.ijse.layered.dto.UserDTO;
import edu.ijse.layered.entity.User;
import edu.ijse.layered.service.custom.UserService;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO = (UserDAO) DaoFactory.getInstance().getDao(DaoFactory.DaoType.USER);

    @Override
    public boolean save(UserDTO userDTO) throws Exception {
        User user = new User(
            userDTO.getUserId(),
            userDTO.getUsername(),
            userDTO.getPassword(),
            userDTO.getRole(),
            userDTO.getEmail(),
            null
        );
        return userDAO.save(user);
    }

    @Override
    public boolean update(UserDTO userDTO) throws Exception {
        User user = new User(
            userDTO.getUserId(),
            userDTO.getUsername(),
            userDTO.getPassword(),
            userDTO.getRole(),
            userDTO.getEmail(),
            null
        );
        return userDAO.update(user);
    }

    @Override
    public boolean delete(String userId) throws Exception {
        return userDAO.delete(userId);
    }

    @Override
    public UserDTO find(String userId) throws Exception {
        User user = userDAO.find(userId);
        if (user != null) {
            return new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getEmail()
            );
        }
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAll() throws Exception {
        ArrayList<User> users = userDAO.getAll();
        ArrayList<UserDTO> userDTOs = new ArrayList<>();
        
        for (User user : users) {
            userDTOs.add(new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getEmail()
            ));
        }
        return userDTOs;
    }

    @Override
    public UserDTO findByUsername(String username) throws Exception {
        User user = userDAO.findByUsername(username);
        if (user != null) {
            return new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getEmail()
            );
        }
        return null;
    }

    @Override
    public boolean authenticate(String username, String password) throws Exception {
        return userDAO.checkPassword(username, password);
    }
}