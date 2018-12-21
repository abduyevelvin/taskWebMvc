package az.task.dao;

import az.task.model.City;
import az.task.model.Employee;
import az.task.model.Experience;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployeeList() throws Exception;
    boolean addEmployee(Employee emp) throws Exception;
    Employee getEmployeeById(int empId) throws Exception;
    boolean deleteEmployee(int empId) throws Exception;
    boolean updateEmployee(Employee emp, int empId) throws Exception;

    List<City> getCityList() throws Exception;
    List<Experience> getExperienceList() throws Exception;
}
