package application.manytomany.service;

import application.manytomany.entites.Role;
import application.manytomany.entites.User;

import java.util.List;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);

    List<User> getUsers();
    List<Role> getRoles();

    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);

    void addRoleToUser(String roleName, String userName);

}
