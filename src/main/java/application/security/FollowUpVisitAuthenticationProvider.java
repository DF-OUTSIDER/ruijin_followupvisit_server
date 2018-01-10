package application.security;

import application.common.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collection;

@Component
public class FollowUpVisitAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private FollowUpUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        if (!StringUtils.hasText(username))
            throw new BadCredentialsException("Invalid Username");
        if (!StringUtils.hasText(password))
            throw new BadCredentialsException("Invalid Password");

        FollowUpUserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (!username.contentEquals(userDetails.getUsername()) || !Encrypt.getMd5String(password).contentEquals(userDetails.getPassword()))
            throw new BadCredentialsException("Invalid Username or Password");

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
