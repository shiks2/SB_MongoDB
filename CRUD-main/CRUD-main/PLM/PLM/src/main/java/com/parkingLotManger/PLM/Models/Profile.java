package com.parkingLotManger.PLM.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "t1")
public class Profile {
    private int id;
    private String name;
    private String registrationNumber;
    private String vehicleType;
}
