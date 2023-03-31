package com.example.management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "customerId", type = IdType.AUTO)
    private Integer customerId;

    @TableField("customerName")
    private String customerName;

    @TableField("customerEmail")
    private String customerEmail;

    @TableField("customerGender")
    private String customerGender;

    @TableField("customerAddress")
    private String customerAddress;

    @TableField("customerPhone")
    private String customerPhone;

    @TableField("customerJob")
    private String customerJob;

    @TableField("customerJointime")
    private String customerJointime;

    @TableField("chargeStaff")
    private String chargeStaff;

    @TableField("customerQQ")
    private String customerQQ;

    @TableField("nickname")
    private String nickname;

    public Customer() {
    }

    public Customer(Integer customerId, String customerName, String customerEmail, String customerGender, String customerAddress, String customerPhone, String customerJob, String customerJointime, String chargeStaff, String customerQQ, String nickname) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerGender = customerGender;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerJob = customerJob;
        this.customerJointime = customerJointime;
        this.chargeStaff = chargeStaff;
        this.customerQQ = customerQQ;
        this.nickname = nickname;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerJob() {
        return customerJob;
    }

    public void setCustomerJob(String customerJob) {
        this.customerJob = customerJob;
    }

    public String getCustomerJointime() {
        return customerJointime;
    }

    public void setCustomerJointime(String customerJointime) {
        this.customerJointime = customerJointime;
    }

    public String getChargeStaff() {
        return chargeStaff;
    }

    public void setChargeStaff(String chargeStaff) {
        this.chargeStaff = chargeStaff;
    }

    public String getCustomerQQ() {
        return customerQQ;
    }

    public void setCustomerQQ(String customerQQ) {
        this.customerQQ = customerQQ;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
