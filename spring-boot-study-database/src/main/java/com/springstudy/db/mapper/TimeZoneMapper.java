package com.springstudy.db.mapper;

import com.springstudy.db.pojo.TimeZonePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author zbsilent
 * @date 2021年06月04日 5:33 下午
 */
@Mapper
public interface TimeZoneMapper {


    /**
     * 查询
     * @author zbsilent
     * @date 2021/6/4 5:48 下午[int] com.springstudy.db.pojo.TimeZonePojo
     */

    @Select("SELECT * FROM time_zone WHERE time_zone_id = #{id}")
    public TimeZonePojo findById(@Param("id") int id);



}

