package com.senchuk.project.controller;

import com.senchuk.project.model.User;
import com.senchuk.project.model.dto.UserDto;
import com.senchuk.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//FIXME should be Users not User
//FIXME need this annotation @RequestMapping("/api/v1") above every controller
//FIXME add statuses to all methods

@RestController
public class UserController {

    //FIXME @Autowired should be only via constructors

    @Autowired
    private UserService userService;

    //FIXME too much spaces
    //FIXME remove /create

    //FIXME create should return model of created User

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = "application/json")
    public void saveUser(@RequestBody UserDto userDto) {

        //FIXME add final to all reference variables

        User user = new User(userDto.getName());
        userService.createUser(user);
    }

    //FIXME remove /delete

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    //FIXME remove /get

    @RequestMapping(value = "/get/{id}",
            method = RequestMethod.GET,
            produces = "application/json")

    //FIXME remove @ResponseBody

    @ResponseBody

    //FIXME controller method should return ResponseEntity<>

    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    //FIXME remove /update

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = "application/json")

    //FIXME remove @ResponseBody

    @ResponseBody

    //FIXME controller method should return ResponseEntity<>
    //FIXME update should return model of updated User

    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }


}
