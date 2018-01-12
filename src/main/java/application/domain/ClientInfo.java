package application.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public class ClientInfo {
    /**
     * current app user id
     */
    private String userId;
    /**
     * current app username
     */
    private String username;
    /**
     * current app user password(for re-auth in filter)
     */
    private String password;
    /**
     * current selected research-id
     */
    private String currentResearchId;
    /**
     * FollowupAuthority
     */
    private List<JsonGrantedAuthority> authorities;

    public ClientInfo() {
    }

    public ClientInfo(String userId, String username, String password, String currentResearchId, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.currentResearchId = currentResearchId;
        this.authorities = authorities.stream().map(t -> new JsonGrantedAuthority(t.getAuthority())).collect(Collectors.toList());
    }

    public Map<String, List<String>> getResearchRoles() {
        Map<String, List<String>> researchRoles = new HashMap<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            for (JsonGrantedAuthority grantedAuthority : authorities) {
                Map<String, List<String>> researchRole =
                        objectMapper.readValue(grantedAuthority.getAuthority(),
                                new TypeReference<Map<String, List<String>>>() {
                                });
                researchRoles.putAll(researchRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return researchRoles;

    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCurrentResearchId() {
        return currentResearchId;
    }

    public List<JsonGrantedAuthority> getAuthorities() {
        return authorities;
    }
}
