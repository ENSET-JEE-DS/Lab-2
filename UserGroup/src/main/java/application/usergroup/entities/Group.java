package application.usergroup.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups_table")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    @JsonManagedReference
    @ToString.Exclude
    private List<User> users = new ArrayList<>();
}
