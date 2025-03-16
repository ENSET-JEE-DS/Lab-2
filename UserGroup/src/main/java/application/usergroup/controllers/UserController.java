package application.usergroup.controllers;

import application.usergroup.entities.DTO.UserDTO;
import application.usergroup.entities.User;
import application.usergroup.entities.mappers.UserMapper;
import application.usergroup.repos.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@Data @AllArgsConstructor
public class UserController {

//    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userRepo.findAll().stream().map(UserMapper::toDTO).toList();
    }
}
