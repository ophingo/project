package coding.assignment.utils.messages;

import coding.assignment.utils.dtos.UsersDto;

import java.util.List;

public class UsersResponse {
    private boolean success;
    private String message;
    private String statusCode;
    private UsersDto usersDto;
    private List<UsersDto> usersDtoList;

    public UsersResponse() {
    }

    public UsersResponse(boolean success, String message, String statusCode, UsersDto usersDto, List<UsersDto> usersDtoList) {
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
        this.usersDto = usersDto;
        this.usersDtoList = usersDtoList;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public UsersDto getUsersDto() {
        return usersDto;
    }

    public void setUsersDto(UsersDto usersDto) {
        this.usersDto = usersDto;
    }

    public List<UsersDto> getUsersDtoList() {
        return usersDtoList;
    }

    public void setUsersDtoList(List<UsersDto> usersDtoList) {
        this.usersDtoList = usersDtoList;
    }

    @Override
    public String toString() {
        return "UsersResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", statusCode=" + statusCode +
                ", usersDto=" + usersDto +
                ", usersDtoList=" + usersDtoList +
                '}';
    }
}
