package application.domain;

import application.entity.ResearchEntity;

public class ResearchDto {
    private String researchId;
    private String researchName;
    private String researchDescription;

    public ResearchDto(ResearchEntity researchEntity) {
        this.researchId = researchEntity.getResearchId();
        this.researchName = researchEntity.getResearchName();
        this.researchDescription = researchEntity.getDescription();
    }

    public String getResearchId() {
        return researchId;
    }

    public String getResearchName() {
        return researchName;
    }

    public String getResearchDescription() {
        return researchDescription;
    }
}
