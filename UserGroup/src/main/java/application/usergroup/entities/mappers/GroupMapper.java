package application.usergroup.entities.mappers;

import application.usergroup.entities.DTO.GroupDTO;
import application.usergroup.entities.Group;
import application.usergroup.entities.User;

import java.util.stream.Collectors;

public class GroupMapper {
    public static GroupDTO toDTO(Group group) {
        return new GroupDTO(
                group.getId(),
                group.getName(),
                group.getUsers().stream().map(UserMapper::toDTO).collect(Collectors.toList())
        );
    }
}
