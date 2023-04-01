package com.example.management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zerowo
 * @since 2023-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Followup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("staffId")
    private Integer staffId;

    @TableField("staffName")
    private String staffName;

    @TableField("staffQQ")
    private String staffQQ;

    @TableField("customerId")
    private Integer customerId;

    @TableField("customerName")
    private String customerName;

    @TableField("customerQQ")
    private String customerQQ;

    @TableField("entryTime")
    private String entryTime;

    @TableField("contactWay")
    private String contactWay;

    private String result;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
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

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStaffQQ() {
        return staffQQ;
    }

    public void setStaffQQ(String staffQQ) {
        this.staffQQ = staffQQ;
    }

    public String getCustomerQQ() {
        return customerQQ;
    }

    public void setCustomerQQ(String customerQQ) {
        this.customerQQ = customerQQ;
    }
}
