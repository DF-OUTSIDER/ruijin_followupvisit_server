package application.controller;

import application.domain.UserDto;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public boolean checkUserValid(@RequestBody UserDto user) {
        try {
            return userService.checkUserValid(user.getUsername(), user.getPassword());
        } catch (Exception e) {
            return false;
        }
    }
}
