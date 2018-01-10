package application.controller;

import application.common.ActionResult;
import application.common.ClientError;
import application.common.ClientOk;
import application.domain.UserDto;
import application.security.FollowUpVisitAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private FollowUpVisitAuthenticationProvider authenticationProvider;

    @RequestMapping("/")
    public ActionResult checkUserValid(@RequestBody UserDto user, HttpServletRequest request) {
        try {
            if (user == null)
                throw new Exception("unknown user.");

            SecurityContext securityContext = SecurityContextHolder.getContext();
            Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            securityContext.setAuthentication(authentication);

            HttpSession session = request.getSession();
            session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

            return new ClientOk(true, authentication.getAuthorities());
        } catch (Exception e) {
            return new ClientError(false, e.getMessage());
        }
    }
}
