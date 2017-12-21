package pl.codeprime.ManagingHome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"pl.codeprime"})
@EntityScan("pl.codeprime")
@EnableJpaRepositories("pl.codeprime")
@ComponentScan("pl.codeprime")
public class ManagingHomeApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ManagingHomeApplication.class, args);
	}
	  
}
