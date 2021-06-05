package com.study.cache.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zbsilent
 * @date 2021年06月05日 1:15 上午
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {
    private Integer userId;
    private String userName;
    private String userCode;
    private Date birth;



}
