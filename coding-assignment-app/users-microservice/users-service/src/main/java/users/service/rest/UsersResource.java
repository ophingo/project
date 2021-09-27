package users.service.rest;


import coding.assignment.utils.messages.UsersResponse;
import coding.assignment.utils.requests.UserCreationRequest;
import coding.assignment.utils.requests.UserRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import users.service.processors.api.UsersProcessor;
import coding.assignment.utils.constants.Constants;


import java.util.Locale;

@RestController
@CrossOrigin
@RequestMapping("/api/users-service/v1/user")
public class UsersResource {
    private UsersProcessor usersProcessor;

    public UsersResource(UsersProcessor usersProcessor) {
        this.usersProcessor = usersProcessor;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Resource successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @ApiOperation(value = "Add User", response = UsersResponse.class)
    @PostMapping(value = "")
    public UsersResponse createUsers(@RequestBody final UserCreationRequest request,
                                       @RequestHeader("Authorization") String authenticationToken,
                                       @ApiParam(value = Constants.LOCALE_LANGUAGE_NARRATIVE) @RequestHeader(value = Constants.LOCALE_LANGUAGE,
                                               defaultValue = Constants.DEFAULT_LOCALE) final Locale locale){
        return usersProcessor.save(request, locale, authenticationToken);
    }

    @ApiOperation(value = "Edit Users", response = UsersResponse.class)
    @PutMapping(value = "")
    public UsersResponse editUsers(@RequestBody final UserRequest request,
                                     @RequestHeader("Authorization") String authenticationToken,
                                     @ApiParam(value = Constants.LOCALE_LANGUAGE_NARRATIVE) @RequestHeader(value = Constants.LOCALE_LANGUAGE,
                                             defaultValue = Constants.DEFAULT_LOCALE) final Locale locale){

        return usersProcessor.edit(request, locale, authenticationToken);

    }
    @ApiOperation(value = "Find Users By Id", response = UsersResponse.class)
    @GetMapping(value = "/id/{id}")
    public UsersResponse searchUsersById(@PathVariable("id") final Long id,
                                           @RequestHeader("Authorization") String authenticationToken,
                                           @ApiParam(value = Constants.LOCALE_LANGUAGE_NARRATIVE) @RequestHeader(value = Constants.LOCALE_LANGUAGE,
                                                   defaultValue = Constants.DEFAULT_LOCALE) final Locale locale) {
        return usersProcessor.findById(id, locale);
    }

    @ApiOperation(value = "Find Users By Users Firstname", response = UsersResponse.class)
    @GetMapping(value = "/first-name/{firstname}")
    public UsersResponse searchUsersByFirstname(@PathVariable("firstname") final String firstname,
                                             @RequestHeader("Authorization") String authenticationToken,
                                             @ApiParam(value = Constants.LOCALE_LANGUAGE_NARRATIVE) @RequestHeader(value = Constants.LOCALE_LANGUAGE,
                                                     defaultValue = Constants.DEFAULT_LOCALE) final Locale locale) {
        return usersProcessor.findByFirstname(firstname, locale);
    }

    @ApiOperation(value = "Find Users By Users surname", response = UsersResponse.class)
    @GetMapping(value = "/surname/{surname}")
    public UsersResponse searchUsersBySurname(@PathVariable("surname") final String surname,
                                                   @RequestHeader("Authorization") String authenticationToken,
                                                   @ApiParam(value = Constants.LOCALE_LANGUAGE_NARRATIVE) @RequestHeader(value = Constants.LOCALE_LANGUAGE,
                                                           defaultValue = Constants.DEFAULT_LOCALE) final Locale locale) {
        return usersProcessor.findBySurname(surname, locale);
    }


    @ApiOperation(value = "Delete a User", response = UsersResponse.class)
    @DeleteMapping(value = "/{id}")
    public UsersResponse deleteBank(@PathVariable("id") final Long id,
                                     @RequestHeader("Authorization") String authenticationToken,
                                     @ApiParam(value = Constants.LOCALE_LANGUAGE_NARRATIVE) @RequestHeader(value = Constants.LOCALE_LANGUAGE,
                                             defaultValue = Constants.DEFAULT_LOCALE) final Locale locale){

        return usersProcessor.delete(id, locale, authenticationToken);
    }

}
