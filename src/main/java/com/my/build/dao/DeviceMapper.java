package com.my.build.dao;

import com.my.build.entity.Buildind;
import com.my.build.entity.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DeviceMapper {
    List<Device> getList(@Param("bid") int bid, @Param("startIndex")int startIndex,@Param("pageSize") int pageSize);
    int getCount(@Param("bid") int bid);
    List<Buildind> getBuildingList();
    int operateStatus(@Param("id") int id,@Param("status") int status);
    int add(@Param("device")Device device);
    Device getDeviceById(@Param("id") int id );
    int del(@Param("id") int id );
}
