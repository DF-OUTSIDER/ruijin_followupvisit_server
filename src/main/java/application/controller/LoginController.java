package application.controller;

import application.common.ActionResult;
import application.common.ClientError;
import application.common.ClientOk;
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
    public ActionResult checkUserValid(@RequestBody UserDto user) {
        try {
            return new ClientOk(userService.checkUserValid(user.getUsername(), user.getPassword()), null);
        } catch (Exception e) {
            return new ClientError(false, e.getMessage());
        }
    }
}
