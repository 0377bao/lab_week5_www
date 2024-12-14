package iuh.huynhquocbao_21107451_labweek5_2.backend.models;

public enum SkillLevel {
    MASTER("Master"), BEGINNER("Beginner"), INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced"), PROFESSIONAL("Professional");
    private String value;

    public String getValue() {
        return value;
    }

    SkillLevel(String value) {
        this.value = value;
    }
}
