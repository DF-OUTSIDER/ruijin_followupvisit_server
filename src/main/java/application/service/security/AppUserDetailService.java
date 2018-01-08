package application.service.security;

import application.entity.UserEntity;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserEntity user = userRepository.findByUserNameEquals(username);
            return new AppUserDetails(user);
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}