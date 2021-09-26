package users.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import users.domain.DomainMarkerInterface;
import users.repository.UserRepositoryMarkerInterface;

@Configuration
@EnableJpaRepositories(basePackageClasses = {UserRepositoryMarkerInterface.class})
@EntityScan(basePackageClasses = {DomainMarkerInterface.class})
public class DataConfig {
}
