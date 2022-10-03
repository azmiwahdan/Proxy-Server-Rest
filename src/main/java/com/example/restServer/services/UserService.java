package com.example.restServer.services;

import com.example.restServer.mapper.UserMapperImpl;
import com.example.restServer.models.UserDTO;
import com.example.restServer.soapClient.UserClient;
import com.example.serverone.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserClient userClient;
    private UserMapperImpl userMapper;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
        this.userMapper = new UserMapperImpl();
    }

    public UserDTO getUser(int id) {
        User user = userClient.getUserResponse(id).getUser();
        UserDTO userDTO = userMapper.userModelToDtoUser(user);
        return userDTO;
    }

    public String addUser(UserDTO userDTO) {
        User userToAdd = userMapper.dtoUserToUserModel(userDTO);
        return userClient.addUserResponse(userToAdd.getId(), userToAdd.getName(), userToAdd.getDevice()).getMessage();
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User userToUpdate = userMapper.dtoUserToUserModel(userDTO);
        User updatedUser = userClient.updateUserResponse(userToUpdate.getId(), userToUpdate.getName(), userToUpdate.getDevice()).getUser();
        return userMapper.userModelToDtoUser(updatedUser);
    }

    public String deleteUser(int id) {
        return userClient.deleteUserResponse(id).getMessage();
    }


}
