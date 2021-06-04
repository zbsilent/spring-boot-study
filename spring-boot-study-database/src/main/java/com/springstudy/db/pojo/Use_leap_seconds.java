package com.springstudy.db.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Reno
 */

@Getter
@AllArgsConstructor
public enum Use_leap_seconds {

    //是
    Y("Y"),
    //否
    N("N");
    private final String value;


}
