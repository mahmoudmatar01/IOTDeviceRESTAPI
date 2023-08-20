package com.example.IOTproject.dto;

import com.example.IOTproject.entity.IOTdevice;
import com.example.IOTproject.entity.SimCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimDTO {
    private int simID;
    private String operatorCode;
    private String simCountry;
    private String simStatus;


    public static SimDTO toDTO(SimCard simCard){
        return SimDTO.builder()
                .simID(simCard.getSimID())
                .operatorCode(simCard.getOperatorCode())
                .simCountry(simCard.getSimCountry())
                .simStatus(simCard.getSimStatus())
                .build();
    }
}
