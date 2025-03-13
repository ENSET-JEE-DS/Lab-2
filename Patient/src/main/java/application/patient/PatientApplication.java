package application.patient;

import application.patient.entities.Patient;
import application.patient.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
public class PatientApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
//        System.out.println(LocalDate.parse("20-10-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }


    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null, "Yahya", LocalDate.parse("2002-01-12"), true, 90));
        patientRepository.save(new Patient(null, "Amin", LocalDate.parse("2012-10-01"), false, 90));
        patientRepository.save(new Patient(null, "Guts", LocalDate.parse("1902-05-19"), true, 90));
        patientRepository.save(new Patient(null, "Griffith", LocalDate.parse("1970-09-23"), true, 90));

        System.out.println("----------------------------------------------------------------------");

        List<Patient> patients = patientRepository.findAll();
        System.out.println("Liste des Patients:");
        patients.forEach(patient -> {
            System.out.println("\t" + patient);
        });

        System.out.println("Consulter le premier patient:");
        System.out.println("\t" + patientRepository.findFirstBy());

        System.out.println("Chercher des patients");
        System.out.println("\t" + patientRepository.findById(1L));

        System.out.println("Chercher des patients par leurs noms");
        patientRepository.findPatientByNomContaining("G").forEach(patient -> {
            System.out.println("\t" + patient);
        });

        System.out.println("Metre à jour un patient:");
        Patient patient = patientRepository.findFirstBy();
        System.out.println("\tPatient original: " + patient);
        System.out.println("One change le nom.");
        patient.setNom("Abdel");
        System.out.println("\t" + patientRepository.save(patient));

        System.out.println("Supprimer un patient");
        patientRepository.deleteById(3L);
        System.out.println("\tListe des Patients avec un patient supprimé:");
        patientRepository.findAll().forEach(p -> {
            System.out.println("\t" + p);
        });
    }
}
