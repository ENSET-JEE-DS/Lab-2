package application.usergroup.controllers;

import application.usergroup.entities.DTO.GroupDTO;
import application.usergroup.entities.mappers.GroupMapper;
import application.usergroup.repos.GroupRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/group")
@AllArgsConstructor
public class GroupController {
    private GroupRepo groupRepo;

    @GetMapping
    public List<GroupDTO> getGroups() {

        return groupRepo.findAll().stream().map(GroupMapper::toDTO).toList();
    }
}
