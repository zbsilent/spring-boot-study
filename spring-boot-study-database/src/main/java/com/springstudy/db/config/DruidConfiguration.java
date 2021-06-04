package com.springstudy.db.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zbsilent
 * @date 2021年06月04日 3:00 下午
 */
@Configuration
public class DruidConfiguration {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.druid")
//    public DataSource druid() {
//        return DruidDataSourceBuilder.create().build();
//    }

    //配置管理后台的Servlet
    //配置监控的filter

//    @Bean
//    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
//
//        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
//        Map<String, String> initParams = new HashMap<String, String>();
//        initParams.put("loginUsername", "admin");
//        initParams.put("loginPassword", "123456");
//        /* * 默认允许访问*/
//        initParams.put("allow", "");
//        /* *        initParams.put("deny","127.0.0.1");*/
//        Assert.notNull(initParams, "异常");
//        bean.setInitParameters(initParams);
//        return bean;
//
//    }
//
//    @Bean
//    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
//        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<WebStatFilter>();
//        bean.setFilter(new WebStatFilter());
//        Map<String, String> initParams = new HashMap<String, String>();
//        initParams.put("exclusions", "*.js,*.css,/druid/*");
//        bean.setInitParameters(initParams);
//        bean.setUrlPatterns(Collections.singletonList("/*"));
//        return bean;
//    }

}
