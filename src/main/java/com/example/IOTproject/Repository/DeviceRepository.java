package com.example.IOTproject.Repository;

import com.example.IOTproject.dto.DeviceDTO;
import com.example.IOTproject.entity.IOTdevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<IOTdevice,Integer> {
     List<IOTdevice> findAllByDeviceStatus(String deviceStatus);
     List<IOTdevice> findAllByDeviceStatusEqualsAndSimCard_simStatusAndDeviceTemBetween(String deviceStatus,String simStatus,String value1,String value2);
}
