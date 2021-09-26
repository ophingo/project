package users.business.config;
import coding.assignment.utils.config.UtilsConfig;
import coding.assignment.utils.i18.api.MessageService;
import coding.assignment.utils.i18.impl.MessageServiceImpl;
import coding.assignment.utils.mappers.UsersMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import users.business.auditables.api.UsersServiceAuditable;
import users.business.auditables.impl.UsersServiceAuditableImpl;
import users.business.logic.api.UsersService;
import users.business.logic.impl.UsersServiceImpl;
import users.business.validations.api.UsersServiceValidator;
import users.business.validations.impl.UsersServiceValidatorImpl;
import users.repository.UsersRepository;
import users.repository.config.DataConfig;

@Configuration
@Import({DataConfig.class, UtilsConfig.class})
public class BusinessConfig {

    @Bean
    public UsersServiceAuditable usersServiceAuditable(UsersRepository usersRepository) {
        return new UsersServiceAuditableImpl(usersRepository);
    }

    @Bean
    public UsersServiceValidator usersServiceValidator() {
        return new UsersServiceValidatorImpl();
    }

    @Bean
    public UsersMapper usersMapper() {
        return Mappers.getMapper(UsersMapper.class);
    }

    @Bean
    public UsersService usersService(MessageService messageService, UsersServiceAuditable usersServiceAuditable, UsersServiceValidator usersServiceValidator, UsersMapper usersMapper, UsersRepository usersRepository) {
        return new UsersServiceImpl(messageService, usersServiceAuditable, usersServiceValidator, usersMapper, usersRepository);
    }
    @Bean
    public MessageService messageService() {
        return new MessageServiceImpl(customMessageSource());
    }

    @Bean(name = "customMessageSource")
    public MessageSource customMessageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
