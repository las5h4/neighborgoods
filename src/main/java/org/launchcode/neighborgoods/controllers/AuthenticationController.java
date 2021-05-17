package org.launchcode.neighborgoods.controllers;

import org.launchcode.neighborgoods.models.User;
import org.launchcode.neighborgoods.models.data.UserRepository;
import org.launchcode.neighborgoods.models.dto.LoginFormDTO;
import org.launchcode.neighborgoods.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;
    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
        session.setAttribute("username", user.getUsername());
    }

    @GetMapping("/login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Login");
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Login");
            return "login";
        }

        User existingUser = userRepository.findByUsername(loginFormDTO.getUsername());

        if (existingUser == null) {
            errors.rejectValue("username", "username.isEmpty()", "Please enter a valid user name");
            model.addAttribute("title", "Login");
            return "login";
        }

        String password = loginFormDTO.getPassword();
        String verifyPassword = loginFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Login");
            return "login";
        }

        User newUser = new User(loginFormDTO.getUsername(), loginFormDTO.getPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }



    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Register");
        return "register";
    }
    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "register";
        }

        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyExists", "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "register";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "register";
        }

        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getEmail(), registerFormDTO.getPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect: index";
    }
}
