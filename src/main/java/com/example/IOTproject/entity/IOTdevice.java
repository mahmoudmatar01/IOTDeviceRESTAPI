package com.example.IOTproject.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class IOTdevice {
    private int deviceID;
    private String deviceStatus;
    private String deviceTem;
   private SimCard simCard;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEVICE_ID")
    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }
    @Basic
    @Column(name = "DEVICE_STATUS")
    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }
    @Basic
    @Column(name = "DEVICE_TEMP")
    public String getDeviceTem() {
        return deviceTem;
    }

    public void setDeviceTem(String deviceTem) {
        this.deviceTem = deviceTem;
    }


    @OneToOne
    @JoinColumn(name = "SIM_DEVICE_ID",referencedColumnName = "SIM_ID",nullable = false)
    public SimCard getSimCard() {
        return simCard;
    }

    public void setSimCard(SimCard simCard) {
        this.simCard = simCard;
    }

}
