package com.globalaccelerex.tcs.controller;

import com.globalaccelerex.tcs.domain.User;
import com.globalaccelerex.tcs.domain.security.UserRole;
import com.globalaccelerex.tcs.repository.RoleRepository;
import com.globalaccelerex.tcs.service.TerminalService;
import com.globalaccelerex.tcs.service.UserService;
import com.globalaccelerex.tcs.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserService userService;
    private RoleRepository roleRepository;
    private TerminalService terminalService;

    @Autowired
    public HomeController(UserService userService, RoleRepository roleRepository, TerminalService terminalService) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.terminalService = terminalService;
    }


    //        @PostConstruct
//    public void init() {
//        User user = new User();
//        user.setEmail("admin@admin.com");
//        user.setUsername("admin");
//        user.setPassword("password");
//        Set<UserRole> userRoles = new HashSet<>();
//        userRoles.add(new UserRole(user, roleRepository.findByName("ROLE_ADMIN")));
//        userService.createUser(user, userRoles);
//    }
    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Principal principal, Model model) {

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "dashboard";
        //  ModelAndView model = new ModelAndView();
//        model.setViewName("dashboard");
//        return model;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Principal principal, Model model) {

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "admin/dashboard";
        //  ModelAndView model = new ModelAndView();
//        model.setViewName("dashboard");
//        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(@ModelAttribute("user") User user, Model model) {
        System.out.println("Usres" + user.getFirstName());
        LOG.info("Users" + user.getFirstName());
        if (userService.checkUserExists(user.getUsername(), user.getEmail())) {
            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);
            }

            if (userService.checkUsernameExists(user.getUsername())) {
                model.addAttribute("usernameExists", true);
            }
            return "register";
        } else {
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleRepository.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            return "redirect:/";
        }
    }

    @RequestMapping("/dashboard")
    public String userFront(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        //Get All terminal
        int countTerminal = terminalService.countTerminal(); /// count All terminal Configured
        long totalUsers =   userService.getTotalUsers();
        model.addAttribute("user", user);
        model.addAttribute("totalTerminal", countTerminal);
        model.addAttribute("totalUsers",totalUsers);
        return "dashboard";
    }


}
