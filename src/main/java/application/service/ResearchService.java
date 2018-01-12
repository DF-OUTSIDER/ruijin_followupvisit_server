package application.service;

import application.domain.ResearchDto;

import java.util.List;

public interface ResearchService {
    /**
     * 获取用户的课题
     *
     * @param userId
     * @return
     */
    List<ResearchDto> getUserResearchList(String userId);

    String getDefaultResearch(String userId);
}
