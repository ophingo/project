package coding.assignment.utils.enums;

public enum I18Code {


    MESSAGE_USER_REQUEST_NULL("messages.user.request.null"),
    MESSAGE_USER_REQUEST_USER_ID_NULL("messages.user.request.user.id.null"),
    MESSAGE_INVALID_USER_CREATE_REQUEST("messages.invalid.user.create.request"),
    MESSAGE_USER_CREATE_REQUEST_FAILED("messages.user.create.request.failed"),
    MESSAGE_USER_CREATE_REQUEST_SUCCESSFUL("messages.user.create.request.successful"),
    MESSAGE_USER_ID_NOT_FOUND("messages.user.id.not.found"),
    MESSAGE_USER_EDIT_REQUEST_INVALID("messages.user.edit.request.invalid"),
    MESSAGE_USER_NOT_FOUND("messages.user.not.found"),
    MESSAGE_USER_RETRIEVE_SUCCESS("messages.user.retrieve.success"),
    MESSAGE_USER_ALREADY_EXISTS("messages.user.already.exists"),
    MESSAGE_USER_EDIT_SUCCESSFULLY("messages.user.edit.request.successful"),
    MESSAGE_USER_DELETE_SUCCESS("messages.user.deleted.success")




    ;

    private String code;

    I18Code(String code) {
        this.code = code;
    }



    public String getCode() {
        return code;
    }

}
