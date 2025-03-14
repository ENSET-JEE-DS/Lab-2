package Application.Hospital.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;
    @ManyToOne
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonBackReference
    private Patient patient;
    @ManyToOne
    @JsonBackReference
    private Doctor doctor;
    @OneToOne(mappedBy = "appointment")
    @JsonManagedReference
    private Consultation consultation;

}
