package Application.Hospital.endpoints;

import Application.Hospital.entities.Doctor;
import Application.Hospital.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    };
}
