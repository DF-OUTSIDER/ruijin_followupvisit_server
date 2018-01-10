package application.security;

import application.entity.RoleEntity;
import application.entity.UserResearchEntity;
import application.entity.UserResearchRoleEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FollowUpAuthority implements GrantedAuthority {

    private Set<RoleEntity> roleEntities;

    public FollowUpAuthority(UserResearchEntity userResearchEntity) {
        this.roleEntities = userResearchEntity.getUserResearchRolesByUserResearchId()
                .stream()
                .map(UserResearchRoleEntity::getRoleByRoleId)
                .collect(Collectors.toSet());
    }

    @Override
    public String getAuthority() {
        try {
            List<String> roleNameList = roleEntities.stream().map(RoleEntity::getRoleName).collect(Collectors.toList());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(roleNameList);
        } catch (Exception e) {
            return null;
        }
    }
}
