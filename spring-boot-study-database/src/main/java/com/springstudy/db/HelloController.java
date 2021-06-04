package com.springstudy.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author zbsilent
 * @date 2021年06月04日 1:34 下午
 */
@RestController
public class HelloController {


    @Autowired
    private JdbcTemplate jdbcTemplate;



    @GetMapping("/query")
    public List<Map<String,Object>> map(){

        List<Map<String,Object>> dbresult = jdbcTemplate.queryForList("select * from time_zone");
        return dbresult;

    }
}
