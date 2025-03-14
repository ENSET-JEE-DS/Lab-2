package Application.Hospital.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private boolean sick;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Collection<Appointment> appointmentCollection;
}
