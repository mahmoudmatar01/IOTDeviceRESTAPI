package com.example.IOTproject.dto;

import com.example.IOTproject.entity.IOTdevice;
import com.example.IOTproject.entity.SimCard;
import com.sun.istack.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceDTO {

    private int deviceID;
    private String deviceStatus;
    private String deviceTem;
    private SimCard simCard;
    public static DeviceDTO toDTO(IOTdevice ioTdevice){
        return DeviceDTO.builder()
                .deviceStatus(ioTdevice.getDeviceStatus())
                .deviceTem(ioTdevice.getDeviceTem())
               .simCard(ioTdevice.getSimCard())
                .build();
    }
}
