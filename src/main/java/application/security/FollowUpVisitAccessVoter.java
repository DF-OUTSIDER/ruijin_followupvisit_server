package application.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FollowUpVisitAccessVoter implements AccessDecisionVoter<FilterInvocation> {
    private static final List<String> IGNORE_URIS = Arrays.asList("/login/", "/logout");

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

        String token = fi.getRequest().getHeader("TOKEN-HEADER");
        if (StringUtils.hasText(token)) {
            ObjectMapper objectMapper = new ObjectMapper();

        }

        //todo:当前课题拦截，没有课题则默认第一个课题
        //todo:检查当前用户在本课题中的权限
        return ACCESS_ABSTAIN;
    }
}
