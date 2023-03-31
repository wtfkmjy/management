package com.example.management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "staffId", type = IdType.AUTO)
    private Integer staffId;

    @TableField("staffName")
    private String staffName;

    @TableField("staffEmail")
    private String staffEmail;

    @TableField("staffGender")
    private String staffGender;

    @TableField("staffAddress")
    private String staffAddress;

    @TableField("staffJob")
    private String staffJob;

    @TableField("staffPhone")
    private String staffPhone;

    @TableField("staffAccount")
    private String staffAccount;

    @TableField("staffPassword")
    private String staffPassword;

    @TableField("department")
    private String department;

    @TableField("staffQQ")
    private String staffQQ;

    public String getStaffQQ() {
        return staffQQ;
    }

    public void setStaffQQ(String staffQQ) {
        this.staffQQ = staffQQ;
    }

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

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffJob() {
        return staffJob;
    }

    public void setStaffJob(String staffJob) {
        this.staffJob = staffJob;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccount(String staffAccount) {
        this.staffAccount = staffAccount;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
