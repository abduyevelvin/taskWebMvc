package az.task.service;

import az.task.dao.LoginDao;
import az.task.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public User getUserDetailsByUsername(String username) throws Exception {
        return loginDao.getUserDetailsByUsername(username);
    }

    @Override
    public boolean registerUser(User u) throws Exception {
        return loginDao.registerUser(u);
    }

    @Override
    public boolean checkUser(String username) throws Exception {
        return loginDao.checkUser(username);
    }
}
