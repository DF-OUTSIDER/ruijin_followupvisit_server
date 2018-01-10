package application.domain;

import java.util.List;

public class AuthorityToken {
    private String userId;
    private String researchId;
    private List<String> roleName;

    public AuthorityToken(String userId, String researchId, List<String> roleName) {
        this.userId = userId;
        this.researchId = researchId;
        this.roleName = roleName;
    }

    public String getUserId() {
        return userId;
    }

    public String getResearchId() {
        return researchId;
    }

    public List<String> getRoleName() {
        return roleName;
    }
}
