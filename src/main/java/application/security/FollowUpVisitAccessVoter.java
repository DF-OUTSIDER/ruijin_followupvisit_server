package application.security;

import application.common.ConstString;
import application.common.Encrypt;
import application.domain.ClientInfo;
import application.service.ResearchService;
import application.service.RoleOperationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class FollowUpVisitAccessVoter implements AccessDecisionVoter<FilterInvocation> {
    private static final List<String> IGNORE_URIS = Arrays.asList("/login/", "/logout");
    @Autowired
    private ResearchService researchService;

    @Autowired
    private RoleOperationService roleOperationService;

    @Autowired
    private FollowUpVisitAuthenticationProvider authenticationProvider;

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> attributes) {
        if (IGNORE_URIS.stream().anyMatch(t -> fi.getRequest().getRequestURI().contains(t)))
            return ACCESS_GRANTED;

        String token = fi.getRequest().getHeader("TOKEN-HEADER"); //check logon user
        if (StringUtils.hasText(token)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                token = Encrypt.decryptAES(objectMapper.readValue(token, String.class));
                ClientInfo clientInfo = objectMapper.readValue(token, ClientInfo.class);
                //re-auth because of no state session for every client's connection (may use redis for many users)
                authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(clientInfo.getUsername(), clientInfo.getPassword()));
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(authentication); //save auth, here authorize by url not by role_ so later you can change principals.

                fi.getRequest().getSession().setAttribute(ConstString.CONTEXT_USER_SESSION_ID, clientInfo); //save client info to session

                if (clientInfo.getUserId().contentEquals(ConstString.ADMIN_ID)) //admin user
                    return ACCESS_GRANTED;

                String researchId = clientInfo.getCurrentResearchId();
                Map<String, List<String>> researchRoles = clientInfo.getResearchRoles(); // list of {researchId:roles}

                List<String> grantedResearchRoles = researchRoles
                        .get(researchId);

                if (grantedResearchRoles != null && roleOperationService.roleCanAccessUri(grantedResearchRoles, fi.getRequest().getRequestURI())) {
                    return ACCESS_GRANTED;
                }

                return ACCESS_DENIED;

            } catch (IOException e) {
                return ACCESS_DENIED;
            }
        }

        return ACCESS_ABSTAIN;
    }
}
