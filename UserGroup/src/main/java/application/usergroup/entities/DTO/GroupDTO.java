package application.usergroup.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class GroupDTO {
    private String id;
    private String name;
    private List<UserDTO> users;
//    private
}
