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


}
