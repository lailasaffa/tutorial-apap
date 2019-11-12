package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);

    String encrypt(String password);

    UserModel getUserByUsername(String username);

    boolean validatePassword(String password);
}
