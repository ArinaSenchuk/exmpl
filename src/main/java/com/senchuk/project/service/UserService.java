package com.senchuk.project.service;

import com.senchuk.project.model.User;


public interface UserService {

    void createUser(User user);

    void deleteUser(Long id);

    User getUser(Long id);

    void updateUser(User user);
}
