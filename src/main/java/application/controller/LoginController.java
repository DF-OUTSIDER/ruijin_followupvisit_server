package application.controller;

import application.common.ActionResult;
import application.common.ClientError;
import application.common.ClientOk;
import application.common.Encrypt;
import application.domain.ClientInfo;
import application.domain.UserDto;
import application.security.FollowUpVisitAuthenticationProvider;
import application.service.ResearchService;
import application.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private FollowUpVisitAuthenticationProvider authenticationProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private ResearchService researchService;

    @RequestMapping("/")
    public ActionResult checkUserValid(@RequestBody UserDto user) {
        try {
            if (user == null)
                throw new Exception("unknown user.");

            SecurityContext securityContext = SecurityContextHolder.getContext();
            Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            securityContext.setAuthentication(authentication); //useless

            UserDto currentUser = userService.findUserByUserName(authentication.getName());

            ClientInfo clientInfo = new ClientInfo(currentUser.getUserId(),
                    authentication.getName(),
                    (String) authentication.getCredentials(),
                    researchService.getDefaultResearch(currentUser.getUserId()),
                    authentication.getAuthorities());

            ObjectMapper objectMapper = new ObjectMapper();
            String clientData = objectMapper.writeValueAsString(clientInfo);

            return new ClientOk(true, Encrypt.encryptAES(clientData)); //save encrypt data to client
        } catch (Exception e) {
            return new ClientError(false, e.getMessage());
        }
    }
}
