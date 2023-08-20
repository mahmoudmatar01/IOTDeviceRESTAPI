package com.example.IOTproject.Services;

import com.example.IOTproject.Repository.SimRepository;
import com.example.IOTproject.dto.DeviceDTO;
import com.example.IOTproject.dto.SimDTO;
import com.example.IOTproject.entity.IOTdevice;
import com.example.IOTproject.entity.SimCard;
import com.example.IOTproject.error.DuplicateRecordException;
import com.example.IOTproject.error.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimService {
    @Autowired
    private SimRepository simRepository;
    public SimDTO addSim(SimCard simCard){
        SimDTO storedSim=getSimById(simCard.getSimID());
        if(storedSim != null){
            throw new DuplicateRecordException("Oops! this Sim card is already in your database");
        }
        SimCard simCard1= this.simRepository.save(simCard);
        return SimDTO.toDTO(simCard1);
    }
    public SimDTO getSimById(int simID){

        Optional<SimCard> simCard=this.simRepository.findById(simID);
        if(simCard.isPresent())
            return SimDTO.toDTO(simCard.get());
        else
            throw new RecordNotFoundException("This record with id:- "+simCard+" not found");
    }
}
