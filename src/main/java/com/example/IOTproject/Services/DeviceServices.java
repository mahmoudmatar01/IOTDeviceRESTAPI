package com.example.IOTproject.Services;

import com.example.IOTproject.Repository.DeviceRepository;
import com.example.IOTproject.dto.DeviceDTO;
import com.example.IOTproject.entity.IOTdevice;
import com.example.IOTproject.error.ApirequestException;
import com.example.IOTproject.error.DuplicateRecordException;
import com.example.IOTproject.error.RecordNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Builder
@Service
@RequiredArgsConstructor

public class DeviceServices {
    private final DeviceRepository deviceRepository;
   // @CacheEvict("devices")
    public DeviceDTO AddDevice( IOTdevice ioTdevice){
        DeviceDTO storedDevice=getDeviceById(ioTdevice.getDeviceID());
        if(storedDevice != null){
            throw new DuplicateRecordException("Oops! this device is already in your database");
        }
        IOTdevice ioTdevice1= this.deviceRepository.save(ioTdevice);
        return DeviceDTO.toDTO(ioTdevice1);
    }

   // @Cacheable("devices")
    public List<DeviceDTO> getAllDevicesByState( String deviceStatus){
       // simulateSlowService();
        List<DeviceDTO> allDevices= this.deviceRepository.findAllByDeviceStatus(deviceStatus).stream()
                .map(ioTdevice -> DeviceDTO.builder().deviceTem(ioTdevice.getDeviceTem())
                        .deviceStatus(ioTdevice.getDeviceStatus())
          //             .simCard(ioTdevice.getSimCard())
                        .build()).collect(Collectors.toList());
        if(allDevices.isEmpty()){
            throw new ApirequestException("Oops! No devices found in your database");
        }
        return allDevices;
    }
    public DeviceDTO getDeviceById(int deviceID){

        Optional<IOTdevice> ioTdevice=this.deviceRepository.findById(deviceID);
        if(ioTdevice.isPresent())
            return DeviceDTO.toDTO(ioTdevice.get());
        else
            throw new RecordNotFoundException("This record with id:- "+deviceID+" not found");
    }

    public List<DeviceDTO> getAllDevicesV2(String deviceStatus,String simStatus,String value1,String value2){
        List<DeviceDTO> alldevices= this.deviceRepository.findAllByDeviceStatusEqualsAndSimCard_simStatusAndDeviceTemBetween(deviceStatus,simStatus,value1,value2).stream()
                .map(ioTdevice -> DeviceDTO.builder().deviceTem(ioTdevice.getDeviceTem())
                        .deviceStatus(ioTdevice.getDeviceStatus())
//                        .simCard(ioTdevice.getSimCard())
                        .build()).collect(Collectors.toList());
        if(alldevices.isEmpty()){
            throw new ApirequestException("Oops! No devices found in your database");
        }
        return alldevices;
    }
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
