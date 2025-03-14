package Application.Hospital;

import Application.Hospital.entities.*;
import Application.Hospital.repositories.AppointmentRepository;
import Application.Hospital.repositories.ConsultationRepository;
import Application.Hospital.repositories.DoctorRepository;
import Application.Hospital.repositories.PatientRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);

    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository, DoctorRepository doctorRepository, AppointmentRepository appointmentRepository, ConsultationRepository consultationRepository) {
        return args -> {
//            List<Appointment> appointmentList = new ArrayList<>();

            Stream.of("Yahya", "Casca", "Guts").forEach(name -> {
                Patient patient = new Patient();
                patient.setName(name);
                patient.setSick(true);
                patient.setBirthDate(LocalDate.parse("1990-01-01"));
                patientRepository.save(patient);

            });
            Stream.of("1", "2", "3").forEach(name -> {
                Doctor doctor = new Doctor();
                doctor.setName("Dr." + name);
                doctor.setEmail("doctor@gmail.com");
                doctorRepository.save(doctor);

            });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Doctor doctor = doctorRepository.findById(1L).orElse(null);

               Appointment appointment = new Appointment();
            appointment.setDate(LocalDate.parse("2000-01-01"));
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
            appointment.setAppointmentStatus(AppointmentStatus.PENDING);
            appointmentRepository.save(appointment);

            Consultation consultation = new Consultation();
            consultation.setReport("Consultation Report");
            consultation.setAppointment(appointment);
            consultationRepository.save(consultation);
        };
    }
}
