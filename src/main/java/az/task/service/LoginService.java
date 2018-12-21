package az.task.service;

import az.task.model.User;

public interface LoginService {

    User getUserDetailsByUsername(String username) throws Exception;

    boolean registerUser(User u) throws Exception;
    boolean checkUser(String username) throws Exception;
}
