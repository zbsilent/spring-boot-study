package com.springstudy.db.controller;

import com.springstudy.db.mapper.TimeZoneMapper;
import com.springstudy.db.pojo.TimeZonePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbsilent
 * @date 2021年06月04日 6:05 下午
 */
@RestController
public class TzController {

    @Autowired
    private TimeZoneMapper timeZoneMapper;

    @GetMapping("/tz/{id}")
    public TimeZonePojo getTimeZone(@PathVariable("id") int id) {
        TimeZonePojo byId = timeZoneMapper.findById(id);
        return byId;
    }
}
