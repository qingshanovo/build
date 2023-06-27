package com.my.build.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.my.build.dao.DeviceMapper;
import com.my.build.entity.Buildind;
import com.my.build.entity.Device;
import com.my.build.entity.Page;
import com.my.build.service.DeviceService;
import com.my.build.util.RedisUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired(required = false)
    DeviceMapper deviceMapper;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public Page<Device> getPageBybid(int bid, int currPage, int pageSize) {
        Page<Device> page = new Page<>();
        page.setPageSize(pageSize);
        page.setCurrPage(currPage);
        page.setTotalCount(deviceMapper.getCount(bid));
        page.setList(deviceMapper.getList(bid, page.getStart(), pageSize));
        return page;
    }

    @Override
    public List<Buildind> getBuildingList() {
        List<Buildind> buildingList = null;
        if(!redisUtil.exists("buildingList")){
            buildingList = deviceMapper.getBuildingList();
            redisUtil.set("buildingList", JSONObject.toJSONString(buildingList));
        }else {
           buildingList =  (List<Buildind>) JSONObject.parse( redisUtil.get("buildingList").toString());
        }
        return buildingList;
    }

    @Override
    public boolean operateStatus(int id, int status) {
        return deviceMapper.operateStatus(id, status)==1;
    }

    @Override
    public int add(Device device) {
        return deviceMapper.add(device);
    }

    @Override
    public Device getDeviceById(int id) {
        return deviceMapper.getDeviceById(id);
    }

    @Override
    public int del(int id) {
        return deviceMapper.del(id);
    }
}
