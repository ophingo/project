package users.service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;
import users.business.config.BusinessConfig;
import users.business.logic.api.UsersService;
import users.service.processors.api.UsersProcessor;
import users.service.processors.impl.UsersProcessorImpl;
import users.service.rest.UsersResource;


@Configuration
@Import(BusinessConfig.class)
public class UsersServiceConfig {
    @Bean
    public UsersProcessor usersProcessor(UsersService usersService) {
        return new UsersProcessorImpl(usersService);
    }

    @Bean
    public UsersResource usersResource(UsersProcessor usersProcessor) {
        return new UsersResource(usersProcessor);
    }

    }
