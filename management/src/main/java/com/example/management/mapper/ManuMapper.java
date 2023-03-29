package com.example.management.mapper;

import com.example.management.pojo.Manu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zerowo
 * @since 2023-03-28
 */

public interface ManuMapper extends BaseMapper<Manu> {
    @Select("select distinct m.manuName " +
            "from staff_role sr " +
            "join role_manu rm on sr.roleId = rm.roleId " +
            "join manu m on m.manuId = rm.manuId " +
            "where staffId = #{staffId}")
    List<String> selectPermsById(int staffId);
}
