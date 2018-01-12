package application.service;

import java.util.List;

public interface RoleOperationService {
    /**
     * check current research's roles can access uri
     *
     * @param researchRoles
     * @param uri
     * @return
     */
    boolean roleCanAccessUri(List<String> researchRoles, String uri);
}
