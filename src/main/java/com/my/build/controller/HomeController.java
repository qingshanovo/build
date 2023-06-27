package com.my.build.controller;

import com.my.build.entity.Buildind;
import com.my.build.entity.Device;
import com.my.build.entity.Page;
import com.my.build.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    DeviceService deviceService;
    //首页请求
    @GetMapping("/index")
    public Page<Device> gotoIndex(@RequestParam(value = "bid",required = false,defaultValue = "-1") int bid,
                                  @RequestParam(required = false,value = "currPage",defaultValue = "1") int currPage,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "3") int pageSize){
        return deviceService.getPageBybid(bid, currPage, pageSize);
    }
    //楼宇列表请求
    @GetMapping("/getBuildList")
    public List<Buildind> getbuildList(){
        return deviceService.getBuildingList();
    }
    //修改状态请求
    @GetMapping("/operateStatus")
    public boolean operateStatus(int id,int status){
        return deviceService.operateStatus(id, status);
    }
    //新增请求
    @PostMapping("/add")
    public boolean operateStatus(Device device){
        return deviceService.add(device)==1;
    }

    @GetMapping("/getDevice")
    public Device getDevice(@RequestParam(value = "id",required = true) int id){
        return deviceService.getDeviceById(id);
    }

    @GetMapping("/del")
    public boolean del(@RequestParam(value = "id",required = true) int id){
       return deviceService.del(id)==1;
    }
}
