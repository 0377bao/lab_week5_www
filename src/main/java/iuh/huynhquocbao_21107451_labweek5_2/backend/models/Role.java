package iuh.huynhquocbao_21107451_labweek5_2.backend.models;

public enum Role {
   COMPANY("company"), CANDIDATE("candidate");
   private String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
