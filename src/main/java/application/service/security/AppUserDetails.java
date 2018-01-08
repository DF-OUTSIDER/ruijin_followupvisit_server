package application.service.security;

import application.entity.UserEntity;
import application.entity.UserResearchEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AppUserDetails implements UserDetails {
    private UserEntity userEntity; //当前登录用户

    AppUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //认证： user->userResearch->role
        Set<AppAuthority> authorities = new HashSet<>();
        for (UserResearchEntity userResearchEntity : userEntity.getUserResearchesByUserId()) {
            authorities.add(new AppAuthority(userResearchEntity));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userEntity.isValid();
    }
}
