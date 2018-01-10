package application.security;

import application.common.Encrypt;
import application.domain.AuthorityToken;
import application.entity.RoleEntity;
import application.entity.UserResearchEntity;
import application.entity.UserResearchRoleEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FollowUpAuthority implements GrantedAuthority {
    private UserResearchEntity userResearchEntity;
    private Set<RoleEntity> roleEntities;

    public FollowUpAuthority(UserResearchEntity userResearchEntity) {
        this.userResearchEntity = userResearchEntity;
        this.roleEntities = userResearchEntity.getUserResearchRolesByUserResearchId()
                .stream()
                .map(UserResearchRoleEntity::getRoleByRoleId)
                .collect(Collectors.toSet());
    }

    @Override
    public String getAuthority() {
        try {
            List<String> roleNameList = roleEntities.stream().map(RoleEntity::getRoleName).collect(Collectors.toList());
            AuthorityToken authorityToken = new AuthorityToken(userResearchEntity.getUserId(), userResearchEntity.getResearchId(), roleNameList);
            ObjectMapper objectMapper = new ObjectMapper();
            return Encrypt.encryptAES(objectMapper.writeValueAsString(authorityToken)); //encrypt all info
        } catch (Exception e) {
            return null;
        }
    }

    public AuthorityToken getAuthorityToken(String encryptedStr) {
        ObjectMapper objectMapper = new ObjectMapper();
        String oriStr = Encrypt.decryptAES(encryptedStr);
        try {
            return objectMapper.readValue(oriStr, AuthorityToken.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
