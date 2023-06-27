package com.my.build.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Device {
   private int id;
   private String  principal;
   private String  supplier;
   private String  brand;
   private int  bid;
   private int  status;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   @JsonFormat(pattern = "yyyy-MM-dd")
   private Date addTime;
   private String buildingName;
   private String statusName;
   private String operateName;

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        if(this.status==0){
            this.statusName = "启用";
            this.operateName="停用";
        }else {
            this.statusName = "停用";
            this.operateName="启用";
        }
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
