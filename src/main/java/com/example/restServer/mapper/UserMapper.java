package com.example.restServer.mapper;

import com.example.restServer.models.UserDTO;
import com.example.serverone.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO userModelToDtoUser(User user);
    User dtoUserToUserModel(UserDTO dtoUser);
}
