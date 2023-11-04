package com.parkingLotManger.PLM.Controller;

import com.parkingLotManger.PLM.Models.Profile;
import com.parkingLotManger.PLM.Repository.PlmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Profile")
public class myController {
    @Autowired
    private PlmRepository plmRepository;
    @GetMapping("/")
    public ResponseEntity<?> getPlm(){
       return ResponseEntity.ok(this.plmRepository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<?> addPlm(@RequestBody Profile profile){
        Profile save = this.plmRepository.save(profile);
        return ResponseEntity.ok(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable("id") int id, @RequestBody Profile updateProfile){
        Profile profile = this.plmRepository.findAllById(id).orElse(null);
        if (profile == null){
            return ResponseEntity.notFound().build();
        }
        profile.setName(updateProfile.getName());
        profile.setVehicleType(updateProfile.getVehicleType());
        profile.setRegistrationNumber(updateProfile.getRegistrationNumber());
        Profile updatedProfile = this.plmRepository.save(profile);
        return ResponseEntity.ok(updatedProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable("id") int id,@RequestBody Profile deleteProfile){
        plmRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
