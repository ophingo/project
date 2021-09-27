package coding.assignment.utils.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;
import users.repository.config.DataConfig;


@Configuration
@Import({DataConfig.class})
public class UtilsConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }




}
