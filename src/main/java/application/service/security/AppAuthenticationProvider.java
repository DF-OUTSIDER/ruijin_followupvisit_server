package application.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class AppAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private AppUserDetailService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {//校验登陆
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        if (!StringUtils.hasText(username))
            throw new BadCredentialsException("No username");
        if (!StringUtils.hasText(password))
            throw new BadCredentialsException("No password");

        UserDetails userDetails = userDetailService.loadUserByUsername(username);

        if (userDetails == null || !userDetails.getUsername().equals(username))
            throw new BadCredentialsException("Invalid username or password");

        if (!password.equals(userDetails.getPassword()))
            throw new BadCredentialsException("Invalid username or password");

        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
