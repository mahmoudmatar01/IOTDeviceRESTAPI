package com.example.IOTproject.controller;

import com.example.IOTproject.Services.DeviceServices;
import com.example.IOTproject.dto.DeviceDTO;
import com.example.IOTproject.entity.IOTdevice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DeviceController {

    @Autowired
    public DeviceServices deviceServices;
    @PostMapping("/device")
    public DeviceDTO AddDevice(@RequestBody IOTdevice ioTdevice){
        return this.deviceServices.AddDevice(ioTdevice);
    }
    @GetMapping("/device")
    public DeviceDTO getDeviceById(@RequestParam int id){


        return this.deviceServices.getDeviceById(id);

    }
    @GetMapping("/devicesV1")
    public List<DeviceDTO> getAllBooksByStatus(){
     return this.deviceServices.getAllDevicesByState("waiting_for_activation");
    }
    @GetMapping("/devicesV2")
    public List<DeviceDTO> getAllDevicesV2(){
        return this.deviceServices.getAllDevicesV2("Activate","waiting_for_activation","-85","25");
    }

}
