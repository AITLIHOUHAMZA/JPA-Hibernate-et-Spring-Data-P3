package ma.p13activit.p22activite;

import ma.p13activit.p22activite.entities.Role;
import ma.p13activit.p22activite.entities.User;
import ma.p13activit.p22activite.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class P22activiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(P22activiteApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User u= new User();
            u.setUsername("user1");
            u.setPassword("123456");
            userService.addNewUser(u);

            User u2 = new User();
            u2.setUsername("admin");
            u2.setPassword("123456");
            userService.addNewUser(u2);

            Stream.of("STUDENT", "USER", "ADMIN").forEach
                    (r -> {
                Role role1  = new Role();
                role1.setRoleName (r);
                userService.addNewRole(role1);
            });

            userService.addRoleToUser("user1", "STUDENT");
            userService.addRoleToUser("user1", "USER");
            userService.addRoleToUser("admin" , "USER");
            userService.addRoleToUser("admin" , "ADMINS");


        };
    }

}
