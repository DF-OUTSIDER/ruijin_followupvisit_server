package application.security;

import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FollowUpUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public FollowUpUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new FollowUpUserDetails(userRepository.findByUserNameEquals(username));
    }
}
