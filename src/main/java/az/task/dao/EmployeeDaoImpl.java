package az.task.dao;

import az.task.model.City;
import az.task.model.Employee;
import az.task.model.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Employee> employees = null;
        String sql = "SELECT e.*, c.id_city city_id, c.city city_name, ex.id_experience experience_id, ex.experience experience_name FROM employee e \n" +
                "JOIN city c ON e.city_id = c.id_city JOIN experience ex ON e.experience_id = ex.id_experience  WHERE e.active = 1";
        try {
            employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employee.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return employees;
    }

    @Override
    public boolean addEmployee(Employee emp) throws Exception {
        boolean res = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO employee(name, surname, age, job_title, city_id, experience_id) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, new Object[] {emp.getName(), emp.getSurname(), emp.getAge(), emp.getJob_title(), emp.getCity().getId_city(), emp.getExperience().getId_experience()});
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            res = false;
        }
        return res;
    }

    @Override
    public Employee getEmployeeById(int empId) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Employee emp = null;
        String sql = "SELECT e.*, c.id_city city_id, c.city city_name, ex.id_experience experience_id, ex.experience experience_name FROM employee e \n" +
                "JOIN city c ON e.city_id = c.id_city JOIN experience ex ON e.experience_id = ex.id_experience  WHERE e.active = 1 AND e.id_employee = ?";
        try {
            emp = (Employee) jdbcTemplate.queryForObject(sql, new Object[] {empId}, new BeanPropertyRowMapper(Employee.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return emp;
    }

    @Override
    public boolean deleteEmployee(int empId) throws Exception {
        boolean res = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE employee SET active = 0 WHERE id_employee = ?";
        try {
            jdbcTemplate.update(sql, new Object[] {empId});
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            res = false;
        }
        return res;
    }

    @Override
    public boolean updateEmployee(Employee emp, int empId) throws Exception {
        boolean res = false;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE employee SET name = ?, surname = ?, age = ?, job_title = ?, city_id = ?, experience_id = ? WHERE active = 1 AND id_employee = ?";
        try {
            jdbcTemplate.update(sql, new Object[] {emp.getName(), emp.getSurname(), emp.getAge(), emp.getJob_title(), emp.getCity().getId_city(), emp.getExperience().getId_experience(), empId});
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            res = false;
        }
        return res;
    }

    @Override
    public List<City> getCityList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<City> cities = null;
        String sql = "SELECT * FROM city WHERE active = 1";
        try {
            cities = jdbcTemplate.query(sql, new BeanPropertyRowMapper(City.class));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return cities;
    }

    @Override
    public List<Experience> getExperienceList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Experience> experiences = null;
        String sql = "SELECT * FROM experience WHERE active = 1";
        try {
            experiences = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Experience.class));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return experiences;
    }
}
