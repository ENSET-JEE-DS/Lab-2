package application.patient.repositories;


import application.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findFirstBy();

    List<Patient> findPatientByNomContaining(String nom);
}
