package application.manytomany.service;

import application.manytomany.entites.Role;
import application.manytomany.entites.User;
import application.manytomany.repositories.RoleRepository;
import application.manytomany.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
        }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);

    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String roleName, String userName) {
        User user = findUserByUserName(userName);
        Role role = findRoleByRoleName(roleName);
//        if (user)
        user.getRole().add(role);
        role.getUsers().add(user);
//        userRepository.save(user);
    }
}
