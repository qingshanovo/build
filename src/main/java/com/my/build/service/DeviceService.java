package com.my.build.service;

import com.my.build.entity.Buildind;
import com.my.build.entity.Device;
import com.my.build.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceService {
    Page<Device> getPageBybid(int bid ,int currPage,int pageSize);
    List<Buildind> getBuildingList();
    boolean operateStatus(int id,int status);
    int add(Device device);
    Device getDeviceById(int id);
    int del(int id );
}
