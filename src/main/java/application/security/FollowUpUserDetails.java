package application.security;

import application.entity.UserEntity;
import application.entity.UserResearchEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FollowUpUserDetails implements UserDetails {
    private UserEntity userEntity;

    public FollowUpUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends FollowUpAuthority> getAuthorities() {
        Set<FollowUpAuthority> followUpAuthorities = new HashSet<>();
        for (UserResearchEntity userResearchEntity : userEntity.getUserResearchesByUserId()) {
            followUpAuthorities.add(new FollowUpAuthority(userResearchEntity));
        }
        return followUpAuthorities;
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
        return userEntity.isValid();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userEntity.isValid();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userEntity.isValid();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
