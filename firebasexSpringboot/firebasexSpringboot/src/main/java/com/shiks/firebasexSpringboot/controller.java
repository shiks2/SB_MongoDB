package com.shiks.firebasexSpringboot;

import com.shiks.firebasexSpringboot.Patient;
import com.shiks.firebasexSpringboot.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.ExecutableType;
import java.util.concurrent.ExecutionException;

@RestController
public class controller {
    @Autowired
    PatientService patientService;
    @GetMapping("/getPatientDetails")
    public Patient getPatient(@RequestParam String name)
        throws InterruptedException, ExecutionException{
        return patientService.getPatientDetails(name);
    }
    @PostMapping("/createPatient")
    public String createPatient(@RequestParam Patient patient)
        throws InterruptedException, ExecutionException{
        return patientService.savePatientDetails(patient);
    }
    @PutMapping("/updatePatient")
    public String updatePatient(@RequestBody Patient patient)
        throws InterruptedException, ExecutionException
    {
        return patientService.updatePatientDetails(patient);
    }
    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam String name){
        return patientService.deletePatientDetails(name);
    }

}
