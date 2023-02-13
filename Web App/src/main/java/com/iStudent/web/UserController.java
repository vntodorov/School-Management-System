package com.iStudent.web;

import com.iStudent.model.DTOs.UserDTO;
import com.iStudent.model.DTOs.UserRegisterDTO;
import com.iStudent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserRegisterDTO userRegisterDTO,
                                            UriComponentsBuilder uriComponentsBuilder) {

        UserDTO userIdentity = userService.registerUser(userRegisterDTO);

        return ResponseEntity.
                ok(userIdentity);
    }


}
