package application.usergroup.entities.mappers;

import application.usergroup.entities.DTO.UserDTO;
import application.usergroup.entities.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getGroup() != null ? user.getGroup().getId() : null
        );
    }
}
