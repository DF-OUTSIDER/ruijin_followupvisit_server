package application.service.security;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

public class AppAccessDecisionVoter implements AccessDecisionVoter<FilterInvocation> {
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> attributes) {
        try {
            HttpServletRequest httpServletRequest = fi.getHttpRequest();
            String researchId = (String) httpServletRequest.getSession().getAttribute("RESEARCH_ID");
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if (authority.getAuthority().equalsIgnoreCase("ROLE_ANONYMOUS"))
                    return ACCESS_GRANTED;
                AppAuthority appAuthority = (AppAuthority) authority;
                if (appAuthority.getResearch().getResearchId().equalsIgnoreCase(researchId) && appAuthority.getAuthority().contains(""))
                    return ACCESS_GRANTED;
            }
            return ACCESS_ABSTAIN;
        } catch (Exception e) {
            return ACCESS_DENIED;
        }
    }
}
