package az.task.controller;

import az.task.model.User;
import az.task.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    private String getUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();

        return user;
    }

    @RequestMapping(value = {"/", "/login"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if(error != null) {
            model.addObject("msg", "Please provide correct credentials.");
        }
        if(logout != null) {
            model.addObject("msg", "You have been logout successfully.");
        }
        model.setViewName("login");

        return model;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView model = new ModelAndView("/register");

        return model;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public ModelAndView registration(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("name") String name,
                                     @RequestParam("surname") String surname, @RequestParam("gender") String gender, @RequestParam CommonsMultipartFile[] attachFileObj) throws IllegalStateException, IOException {
        User u = new User();
        boolean isRegistered = false;

        try {
            u.setUsername(username);
            u.setPassword(password);
            u.setName(name);
            u.setSurname(surname);
            u.setGender(gender);

            // Determine If There Is An File Upload. If Yes, Attach It To The Client Email
            if ((attachFileObj != null) && (attachFileObj.length > 0) && (!attachFileObj.equals(""))) {
                for (CommonsMultipartFile aFile : attachFileObj) {
                    if(aFile.isEmpty()) {
                        continue;
                    } else {
                        if (!aFile.getOriginalFilename().equals("")) {
                            u.setPhoto_name(aFile.getOriginalFilename());
                            u.setPhoto(aFile.getBytes());
                        }
                    }
                }
            }
            isRegistered = loginService.registerUser(u);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if(isRegistered) {
            ModelAndView model = new ModelAndView("/login");
            return model;
        }
        else {
            ModelAndView model = new ModelAndView("/register");
            return model;
        }
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.GET)
    public @ResponseBody String checkUser(@RequestParam("username") String username) throws Exception {
        String result = "false";
        try {
            boolean isExist = loginService.checkUser(username);

            if(isExist) {
                result = "true";
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = {"/403"}, method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView("403");
        try {
            model.addObject("user", loginService.getUserDetailsByUsername(getUser()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
        }

        return model;
    }
}