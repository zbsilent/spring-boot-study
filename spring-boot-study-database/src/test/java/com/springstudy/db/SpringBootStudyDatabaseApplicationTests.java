package com.springstudy.db;

import com.springstudy.db.mapper.TimeZoneMapper;
import com.springstudy.db.pojo.TimeZonePojo;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
//@MapperScan("com.springstudy.db.mapper")
class SpringBootStudyDatabaseApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    TimeZoneMapper timeZoneMapper;

    @Test
    public void doAction() throws SQLException{
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void doMyBatis() throws SQLException{
        TimeZonePojo byId = timeZoneMapper.findById(1);
        System.out.println(byId);

    }

    @Test
    void contextLoads() {
    }

}
