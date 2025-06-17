package tn.esprit.spring.booknetwork;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import tn.esprit.spring.booknetwork.role.Role;
import tn.esprit.spring.booknetwork.role.RoleRepository;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class BooknetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooknetworkApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository){
        return args -> {
            if(roleRepository.findByName("USER").isEmpty()){
                roleRepository.save(
                        Role.builder().name("USER").build()
                );
            }
        };
    }
}
