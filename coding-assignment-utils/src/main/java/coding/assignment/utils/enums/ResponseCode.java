package coding.assignment.utils.enums;

public enum ResponseCode {

    FAILED("400"),
    NOT_FOUND("404"),
    SUCCESSFUL("200"),
    CREATED("201");

    private String code;

    ResponseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
