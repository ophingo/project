package users.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import users.service.config.ServiceMarkerInterface;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackageClasses = {ServiceMarkerInterface.class}, exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class UsersServiceMain {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UsersServiceMain.class, args);
//        SpringApplication.run(UsersServiceMain.class, args);
    }

}
