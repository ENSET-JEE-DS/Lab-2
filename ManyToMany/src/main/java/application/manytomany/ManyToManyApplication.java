package application.manytomany;

import application.manytomany.entites.Role;
import application.manytomany.entites.User;
import application.manytomany.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            System.out.println("Starting user service");
            Stream.of("Casca", "Griffith", "Guts")
                    .forEach(name -> {
                        User user = new User();
                        user.setUserName(name);
                        user.setPassword("password");
                        userService.addNewUser(user);
                    });

            Stream.of("Evil", "Warrior", "Brave").forEach(name -> {
                Role role = new Role();
                role.setRoleName(name);
                userService.addNewRole(role);
            });

            userService.addRoleToUser("Evil", "Griffith");
            userService.addRoleToUser("Warrior", "Griffith");
            userService.addRoleToUser("Warrior", "Guts");
            userService.addRoleToUser("Brave", "Casca");

            User newUser = userService.findUserByUserName("Guts");
            List<Role> roleList = newUser.getRole();
            roleList.forEach(role -> {
                System.out.println("\t"+role);
            });


        };
    }

}
