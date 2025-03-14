package Application.Hospital.endpoints;

import Application.Hospital.entities.Appointment;
import Application.Hospital.entities.Patient;
import Application.Hospital.repositories.AppointmentRepository;
import Application.Hospital.repositories.PatientRepository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private  PatientRepository patientRepository;

    @GetMapping
    public List<Patient> getPatients(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ){

        return patientRepository.findAll(PageRequest.of(pageNumber,pageSize)).stream().toList();

}
}
