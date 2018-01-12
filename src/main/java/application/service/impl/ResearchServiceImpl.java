package application.service.impl;

import application.common.ConstString;
import application.domain.ResearchDto;
import application.repository.ResearchRepository;
import application.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResearchServiceImpl implements ResearchService {
    @Autowired
    private ResearchRepository researchRepository;

    @Override
    @Transactional
    public List<ResearchDto> getUserResearchList(String userId) {
        if (!StringUtils.hasText(userId))
            return null;

        if (userId.equalsIgnoreCase(ConstString.ADMIN_ID))
            return researchRepository.findAll()
                    .stream()
                    .map(ResearchDto::new)
                    .collect(Collectors.toList());

        return researchRepository.findResearchEntitiesByUserId(userId)
                .map(ResearchDto::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String getDefaultResearch(String userId) {
        if (!StringUtils.hasText(userId))
            return null;

        Optional<ResearchDto> researchDto;
        if (userId.equalsIgnoreCase(ConstString.ADMIN_ID))
            researchDto = researchRepository.findAll()
                    .stream()
                    .map(ResearchDto::new)
                    .findFirst();

        researchDto = researchRepository.findResearchEntitiesByUserId(userId)
                .map(ResearchDto::new)
                .findFirst();

        if (researchDto.isPresent())
            return researchDto.get().getResearchId();
        return "";
    }
}
