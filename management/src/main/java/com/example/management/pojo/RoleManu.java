package com.example.management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2023-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RoleManu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("roleId")
    private Integer roleId;

    @TableField("roleName")
    private String roleName;

    @TableField("manuId")
    private Integer manuId;

    @TableField("manuName")
    private String tableName;

    public RoleManu(Integer roleId, Integer manuId) {
        this.roleId = roleId;
        this.manuId = manuId;
    }

    public RoleManu(Integer roleId, String roleName, Integer manuId, String tableName) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.manuId = manuId;
        this.tableName = tableName;
    }
}
