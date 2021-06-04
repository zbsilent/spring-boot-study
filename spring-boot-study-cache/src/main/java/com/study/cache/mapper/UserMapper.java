package com.study.cache.mapper;

import com.study.cache.pojo.UserEntity;
import org.apache.ibatis.annotations.*;

/**
 *
 * @author zbsilent
 * @date 2021/6/5 1:19 上午
 * @description
 */
@Mapper

public interface UserMapper {

    /**
     * @return com.study.cache.pojo.UserEntity
     * @param  id primary key
     * @author zbsilent
     * @date 2021/6/5 1:20 上午[int] com.study.cache.pojo.UserEntity
     * @description
     */
    @Select("select * from bd_user where user_code =#{userCode}")
    @Results(
            value = {
                    @Result(id = true, column = "user_id", property = "userId"),
                    @Result(column = "user_code", property = "userCode"),
                    @Result(column = "user_name", property = "userName"),
                    @Result(column = "birth_day", property = "birth")
            }
    )
    public UserEntity getUserByUserCode(@Param("userCode") String userCode);

    @Select("select * from bd_user where user_id =#{id}")
    @Results(
            value = {
                    @Result(id = true, column = "user_id", property = "userId"),
                    @Result(column = "user_code", property = "userCode"),
                    @Result(column = "user_name", property = "userName"),
                    @Result(column = "birth_day", property = "birth")
            }
    )
    public UserEntity getUserById(@Param("id") int id);

    @Update("UPDATE bd_user set user_code =#{userCode},user_name=#{userName},birth_day=#{birth}" +
            " WHERE user_id =#{userId}")
    public void updateUser(UserEntity userEntity);

    @Delete("DELETE from bd_user where user_id =#{userId}")
    public void deleteUserByid(Integer userId);

    @Options(useGeneratedKeys = true,keyProperty = "userId")
    @Insert("insert into bd_user(user_code,user_name,birth_day) values (#{userCode},#{userName},#{birth}) ")
    public void insertUser(UserEntity userEntity);
}
