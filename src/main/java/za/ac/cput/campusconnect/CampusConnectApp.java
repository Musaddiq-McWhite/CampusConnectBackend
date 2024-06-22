package za.ac.cput.campusconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "za.ac.cput.campusconnect.repository")
public class CampusConnectApp {
    public static void main(String[] args) {
        SpringApplication.run(CampusConnectApp.class, args);
    }
}
