package application.security;

import application.domain.ResearchDto;
import application.domain.RoleDto;
import application.entity.UserResearchEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public class FollowUpAuthority implements GrantedAuthority {
    @JsonIgnore
    private ResearchDto research;
    @JsonIgnore
    private Set<RoleDto> roles;

    public FollowUpAuthority(UserResearchEntity userResearchEntity) {
        this.research = new ResearchDto(userResearchEntity.getResearchByResearchId());
        roles = new HashSet<>();
        userResearchEntity.getUserResearchRolesByUserResearchId()
                .stream()
                .map(userResearchRoleEntity -> roles.add(new RoleDto(userResearchRoleEntity.getRoleId(),
                        userResearchRoleEntity.getRoleByRoleId().getRoleName())))
                .collect(Collectors.toSet());
    }

    /**
     * get a json string from research's roles of current user
     *
     * @return map:{researchId:roleList}
     */
    @Override
    public String getAuthority() {
        try {
            List<String> roleNameList = roles.stream().map(role -> role.getRoleName()).collect(Collectors.toList());
            Map<String, List<String>> researchRoles = new HashMap();
            researchRoles.put(research.getResearchId(), roleNameList);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(researchRoles);
        } catch (Exception e) {
            return null;
        }
    }
}
