package users.domain;

public enum EntityStatus {

    ACTIVE("ACTIVE"), INACTIVE("INACTIVE"),DELETED("DELETED");

    private String status;

    EntityStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
