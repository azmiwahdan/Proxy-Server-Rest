package com.example.restServer.controllers;

import com.example.restServer.models.UserDTO;
import com.example.restServer.services.UserService;
import com.example.serverone.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<Object> getUser(@PathVariable int id) {
        UserDTO retrievedUser = userService.getUser(id);
        if (retrievedUser.getName().equals("non-existing user")) {
            return new ResponseEntity<>("non-existing user", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(retrievedUser, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody UserDTO userDTO) {
        String addingMessage = userService.addUser(userDTO);
        if (addingMessage.contains("added successfully")) {
            return new ResponseEntity<>(addingMessage, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failing adding : " + addingMessage, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Object> deleteUser(@RequestParam int id) {
        String deletingMessage = userService.deleteUser(id);
        return new ResponseEntity<>(deletingMessage, HttpStatus.OK);
    }
}
