package application.manytomany.service;

import application.manytomany.entites.Role;
import application.manytomany.entites.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);

    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);

    void addRoleToUser(String roleName, String userName);

}
