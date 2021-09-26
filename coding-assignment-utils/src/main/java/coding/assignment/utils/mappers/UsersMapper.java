package coding.assignment.utils.mappers;

import coding.assignment.utils.dtos.UsersDto;
import coding.assignment.utils.requests.UserCreationRequest;
import org.mapstruct.Mapper;
import users.domain.Users;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UsersMapper {

    public abstract UsersDto map(Users branch);

        public abstract List<UsersDto> map(List<Users> usersList);

    public abstract Users map(UserCreationRequest userCreationRequest);
}
