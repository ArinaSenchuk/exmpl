package com.senchuk.project.service.impl;

import com.senchuk.project.exception.NotFoundException;
import com.senchuk.project.model.User;
import com.senchuk.project.repository.UserRepository;
import com.senchuk.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//FIXME remove extend from RuntimeException
//FIXME UserEntity should be converted everywhere

@Service
public class UserServiceImpl extends RuntimeException implements UserService  {

    //FIXME @Autowired should be only via constructors

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {

        //FIXME need to format code (add spaces, else after { etc)
        //FIXME change logic

        if(userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
        else userRepository.findById(id).orElseThrow(() ->  new NotFoundException("User not found"));
    }


    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->  new NotFoundException("User not found"));

    }

    @Override
    public void updateUser(User user) {

        //FIXME need to format code (add spaces, else after { etc)
        //FIXME change logic

        if(userRepository.findById(user.getId()).isPresent()) {
            userRepository.save(user);
        }
        else userRepository.findById(user.getId()).orElseThrow(() ->  new NotFoundException("User not found"));
         }
}
