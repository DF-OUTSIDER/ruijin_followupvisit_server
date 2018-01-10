package application.controller;

import application.domain.ResearchDto;
import application.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/")
public class GlobalController {
    @Autowired
    private ResearchService researchService;

    @RequestMapping("/userResearchList")
    @Secured("ROLE_AUTHENTICATED")
    public List<ResearchDto> getResearchList() {
        return researchService.getUserResearchList("1");
    }
}
