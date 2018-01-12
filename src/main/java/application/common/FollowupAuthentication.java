package application.common;

import application.domain.ClientInfo;

import javax.servlet.http.HttpSession;

public class FollowupAuthentication {

    public static String loginUserId(HttpSession httpSession) {
        try {
            ClientInfo clientInfo = (ClientInfo) httpSession.getAttribute(ConstString.CONTEXT_USER_SESSION_ID);
            return clientInfo.getUserId();
        } catch (Exception e) {
            return "";
        }
    }

    public static String currentResearchId(HttpSession httpSession) {
        try {
            ClientInfo clientInfo = (ClientInfo) httpSession.getAttribute(ConstString.CONTEXT_USER_SESSION_ID);
            return clientInfo.getCurrentResearchId();
        } catch (Exception e) {
            return "";
        }
    }
}
