package application.manytomany.entites;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(unique = true)
    private String userName;
    private String password;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
//    @JsonManagedReference
    @ToString.Exclude
    private List<Role> role = new ArrayList<>();
}
