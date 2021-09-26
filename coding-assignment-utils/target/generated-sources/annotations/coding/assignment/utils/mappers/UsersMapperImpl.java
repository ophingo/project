package coding.assignment.utils.mappers;

import coding.assignment.utils.dtos.UsersDto;
import coding.assignment.utils.requests.UserCreationRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import users.domain.Users;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-27T00:59:25+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class UsersMapperImpl extends UsersMapper {

    @Override
    public UsersDto map(Users branch) {
        if ( branch == null ) {
            return null;
        }

        UsersDto usersDto = new UsersDto();

        usersDto.setId( branch.getId() );
        usersDto.setTitle( branch.getTitle() );
        usersDto.setFirstname( branch.getFirstname() );
        usersDto.setSurname( branch.getSurname() );
        usersDto.setDateOfBirth( branch.getDateOfBirth() );
        usersDto.setJobTitle( branch.getJobTitle() );
        usersDto.setDateCreated( branch.getDateCreated() );
        usersDto.setDateLastModified( branch.getDateLastModified() );

        return usersDto;
    }

    @Override
    public List<UsersDto> map(List<Users> usersList) {
        if ( usersList == null ) {
            return null;
        }

        List<UsersDto> list = new ArrayList<UsersDto>( usersList.size() );
        for ( Users users : usersList ) {
            list.add( map( users ) );
        }

        return list;
    }

    @Override
    public Users map(UserCreationRequest userCreationRequest) {
        if ( userCreationRequest == null ) {
            return null;
        }

        Users users = new Users();

        users.setTitle( userCreationRequest.getTitle() );
        users.setFirstname( userCreationRequest.getFirstname() );
        users.setSurname( userCreationRequest.getSurname() );
        users.setDateOfBirth( userCreationRequest.getDateOfBirth() );
        users.setJobTitle( userCreationRequest.getJobTitle() );

        return users;
    }
}
