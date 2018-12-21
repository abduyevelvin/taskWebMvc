package az.task.dao;

import az.task.model.User;

public interface LoginDao {

    User getUserDetailsByUsername(String username) throws Exception;

    boolean registerUser(User u) throws Exception;
    boolean checkUser(String username) throws Exception;
}
