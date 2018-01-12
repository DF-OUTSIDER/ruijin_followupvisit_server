package application.controller;

import application.common.FollowupAuthentication;
import application.domain.ResearchDto;
import application.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/")
public class GlobalController {
    @Autowired
    private ResearchService researchService;

    @RequestMapping("/researchList")
    @PreAuthorize("ROLE_EVERYONE")
    public List<ResearchDto> getResearchList(HttpServletRequest httpServletRequest) {
        return researchService.getUserResearchList(FollowupAuthentication.loginUserId(httpServletRequest.getSession()));
    }
}
