package com.senchuk.project.service;

import com.senchuk.project.model.User;


public interface UserService {

    //FIXME add return values according to new controller requirements

    void createUser(User user);

    void deleteUser(Long id);

    User getUser(Long id);

    void updateUser(User user);
}
