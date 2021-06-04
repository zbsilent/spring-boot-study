package com.springstudy.jpa.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zbsilent
 * @date 2021年06月04日 8:36 下午
 */
@Entity
@Table(name = "bd_user")
@Getter
@Setter
@ToString
@NamedQuery(name = "User.findByUserCode",query = "select u from User u where u.userCode = ?1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;
    @Column(name="user_name",length = 50)
    private String userName;
    @Column(name="user_code")
    private String userCode;
    @Column(name="birth_day")
    private Date birth;

}
