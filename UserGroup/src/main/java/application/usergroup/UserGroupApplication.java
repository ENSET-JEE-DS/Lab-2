package application.usergroup;

import application.usergroup.entities.Group;
import application.usergroup.entities.User;
import application.usergroup.repos.GroupRepo;
import application.usergroup.repos.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class UserGroupApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserGroupApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepo userRepo, GroupRepo groupRepo) {
        return args -> {
            System.out.println("Starting user group application");

            Stream.of("User 1", "User 2", "User 3").forEach(
                    u -> {
                        User user = new User();
                        user.setName(u);
                        userRepo.save(user);
                    }
            );

            Stream.of("Group 1", "Group 2", "Group 3").forEach(
                    u -> {
                        Group group = new Group();
                        group.setName(u);
                        groupRepo.save(group);
                    }
            );

            List<Group> groups = groupRepo.findAll();
            List<User> users = userRepo.findAll();

            groups.forEach(
                    group -> {
                        System.out.println(group.getId());
                        System.out.println(group.getName());
                    }
            );

            users.getFirst().setGroup(groups.getFirst());
            userRepo.save(users.getFirst());


//            System.out.println(groupRepo.findAll().getFirst().getUsers());

        };
    }
}
