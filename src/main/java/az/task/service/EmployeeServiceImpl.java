package az.task.service;

import az.task.dao.EmployeeDao;
import az.task.model.City;
import az.task.model.Employee;
import az.task.model.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        return employeeDao.getEmployeeList();
    }

    @Override
    public boolean addEmployee(Employee emp) throws Exception {
        return employeeDao.addEmployee(emp);
    }

    @Override
    public Employee getEmployeeById(int empId) throws Exception {
        return employeeDao.getEmployeeById(empId);
    }

    @Override
    public boolean deleteEmployee(int empId) throws Exception {
        return employeeDao.deleteEmployee(empId);
    }

    @Override
    public boolean updateEmployee(Employee emp, int empId) throws Exception {
        return employeeDao.updateEmployee(emp, empId);
    }

    @Override
    public List<City> getCityList() throws Exception {
        return employeeDao.getCityList();
    }

    @Override
    public List<Experience> getExperienceList() throws Exception {
        return employeeDao.getExperienceList();
    }
}
