package iuh.huynhquocbao_21107451_labweek5_2.backend.models;

public enum SkillType {
    SOFT_SKILL("Soft Skill"), UNSPECIFIC("Unspecific"), TECHNICAL_SKILL("Technical Skill");
    private String value;

    SkillType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
