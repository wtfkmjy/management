package com.example.management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.bytebuddy.asm.Advice;

/**
 * <p>
 * 
 * </p>
 *
 * @author zerowo
 * @since 2023-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StaffRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("staffId")
    private Integer staffId;

    @TableField("staffName")
    private String staffName;

    @TableField("roleId")
    private Integer roleId;

    @TableField("roleName")
    private String roleName;

    public StaffRole(Integer staffId, Integer roleId) {
        this.staffId = staffId;
        this.roleId = roleId;
    }

    public StaffRole(Integer staffId, String staffName, Integer roleId, String roleName) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.roleId = roleId;
        this.roleName = roleName;
    }
}
