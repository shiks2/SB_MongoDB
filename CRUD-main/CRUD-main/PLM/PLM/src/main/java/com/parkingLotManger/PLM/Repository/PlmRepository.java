package com.parkingLotManger.PLM.Repository;

import com.parkingLotManger.PLM.Models.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlmRepository extends MongoRepository<Profile,Integer> {
    Optional<Profile> findAllById(int id);
}
