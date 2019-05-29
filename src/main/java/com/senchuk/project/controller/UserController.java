package com.senchuk.project.controller;

import com.senchuk.project.model.User;
import com.senchuk.project.model.dto.UserDto;
import com.senchuk.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = "application/json")
    public void saveUser(@RequestBody UserDto userDto) {
        User user = new User(userDto.getName());
        userService.createUser(user);
    }

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/get/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = "application/json")
    @ResponseBody
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }


}
