package application.service.security;

import application.entity.ResearchEntity;
import application.entity.RoleEntity;
import application.entity.UserResearchEntity;
import application.entity.UserResearchRoleEntity;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class AppAuthority implements GrantedAuthority {

    private ResearchEntity research;

    private List<RoleEntity> roles;

    AppAuthority(UserResearchEntity userResearchEntity) {
        this.research = userResearchEntity.getResearchByResearchId();
        this.roles = userResearchEntity.getUserResearchRolesByUserResearchId()
                .stream()
                .map(UserResearchRoleEntity::getRoleByRoleId)
                .collect(Collectors.toList());
    }

    public ResearchEntity getResearch() {
        return research;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    @Override
    public String getAuthority() {
        return research.getResearchId();
    }
}
