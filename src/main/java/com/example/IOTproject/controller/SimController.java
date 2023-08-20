package com.example.IOTproject.controller;

import com.example.IOTproject.Services.SimService;
import com.example.IOTproject.dto.DeviceDTO;
import com.example.IOTproject.dto.SimDTO;
import com.example.IOTproject.entity.IOTdevice;
import com.example.IOTproject.entity.SimCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimController {
    @Autowired
    private SimService simService;
    @PostMapping("/sim")
    public SimDTO AddSim(@RequestBody SimCard simCard){
        return this.simService.addSim(simCard);
    }
    @GetMapping("/find_Sim")
    public SimDTO getSimById(@RequestParam int simID){
     return this.simService.getSimById(simID);
    }
}
