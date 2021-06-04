package com.springstudy.jpa.repository;

import com.springstudy.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * 继承JpaRepository来完成对数据库对操作
 * @author zbsilent
 * @date 2021/6/4 10:19 下午
 * @description 继承JpaRepository来完成对数据库对操作
 */
public interface UserRepository extends JpaRepository<User,Integer> {


    /**
     * 查询高段位查询
     * @param userId 用户ID
     * @return User
     */
    @Query("select u from User u where u.userId =:userId")
    User findByUserId(@Param("userId") Integer userId);

    /**
     * 按用户编码查询
     * @param userCode 用户编码
     * @return User
     */
    User findByUserCode(String userCode);

}
