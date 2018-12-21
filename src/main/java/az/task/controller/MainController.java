package az.task.controller;

import az.task.model.City;
import az.task.model.Employee;
import az.task.model.Experience;
import az.task.service.EmployeeService;
import az.task.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private EmployeeService employeeService;

    private String getUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();

        return user;
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("main");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = {"/employeeList"}, method = RequestMethod.GET)
    public ModelAndView studentList() {
        ModelAndView model = new ModelAndView("employee/employeeList");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
            model.addObject("employeeList", employeeService.getEmployeeList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = {"/newEmployee"}, method = RequestMethod.GET)
    public ModelAndView newStudent() {
        ModelAndView model = new ModelAndView("employee/newEmployee");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
            List<City> cityList = employeeService.getCityList();
            model.addObject("cityList", cityList);
            List<Experience> experienceList = employeeService.getExperienceList();
            model.addObject("experienceList", experienceList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public @ResponseBody String addEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("age") int age,
                                           @RequestParam("job") String job, @RequestParam("city") int city, @RequestParam("experience") int experience) throws Exception {
        String result = "false";
        Employee emp = new Employee();
        City ct = new City();
        Experience exp = new Experience();

        try {
            emp.setName(name);
            emp.setSurname(surname);
            emp.setAge(age);
            emp.setJob_title(job);
            ct.setId_city(city);
            emp.setCity(ct);
            exp.setId_experience(experience);
            emp.setExperience(exp);

            boolean isAdded = employeeService.addEmployee(emp);

            if(isAdded) {
                result = "true";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public @ResponseBody String deleteEmployee(@RequestParam("empId") int empId) throws Exception {
        String result = "false";
        boolean isDeleted = employeeService.deleteEmployee(empId);
        if(isDeleted) {
            result = "true";
        }

        return result;
    }

    @RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
    public ModelAndView viewEmployee(@RequestParam("empId") int empId) throws Exception {
        ModelAndView model = new ModelAndView("employee/viewEmployee");

        model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
        Employee employee = employeeService.getEmployeeById(empId);
        List<City> cityList = employeeService.getCityList();
        model.addObject("employee", employee);
        model.addObject("cityList", cityList);
        List<Experience> experienceList = employeeService.getExperienceList();
        model.addObject("experienceList", experienceList);

        return model;
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editEmployee(@RequestParam("empId") int empId) throws Exception {
        ModelAndView model = new ModelAndView("employee/editEmployee");

        model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
        Employee employee = employeeService.getEmployeeById(empId);
        List<City> cityList = employeeService.getCityList();
        model.addObject("employee", employee);
        model.addObject("cityList", cityList);
        List<Experience> experienceList = employeeService.getExperienceList();
        model.addObject("experienceList", experienceList);

        return model;
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public @ResponseBody String updateEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("age") int age,
                                               @RequestParam("job") String job, @RequestParam("city") int city, @RequestParam("experience") int experience,
                                                @RequestParam("empId") int empId) throws Exception {

        String result = "false";
        Employee emp = new Employee();
        City ct = new City();
        Experience exp = new Experience();

        try {
            emp.setName(name);
            emp.setSurname(surname);
            emp.setAge(age);
            emp.setJob_title(job);
            ct.setId_city(city);
            emp.setCity(ct);
            exp.setId_experience(experience);
            emp.setExperience(exp);

            boolean isEdited = employeeService.updateEmployee(emp, empId);

            if(isEdited) {
                result = "true";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView model = new ModelAndView("profile");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}
