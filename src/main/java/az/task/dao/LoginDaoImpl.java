package az.task.dao;

import az.task.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class LoginDaoImpl implements LoginDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public User getUserDetailsByUsername(String username) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        User user = null;
        String sql = "SELECT u.*, r.role_name FROM user u \n" +
                "LEFT JOIN role r ON u.role_id = r.id_role WHERE u.active = 1 and u.username = ?";
        try {
            user = (User) jdbcTemplate.queryForObject(sql, new Object[] {username}, new BeanPropertyRowMapper(User.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean registerUser(User u) throws Exception {
        boolean res = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO user(username, password, name, surname, gender, photo_name, photo) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, new Object[] {u.getUsername(), u.getPassword(), u.getName(), u.getSurname(), u.getGender(), u.getPhoto_name(), u.getPhoto()});
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            res = false;
        }
        return res;
    }

    @Override
    public boolean checkUser(String username) throws Exception {
        boolean res = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT COUNT(*) FROM user WHERE username = ?";
        try {
            int count = jdbcTemplate.queryForObject(sql, new Object[] {username}, Integer.class);
            if(count > 0) {
                res = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            res = false;
        }
        return res;
    }
}
