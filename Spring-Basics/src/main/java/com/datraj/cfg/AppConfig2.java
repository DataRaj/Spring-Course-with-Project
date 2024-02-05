package com.datraj.cfg;

import com.datraj.dao.JdbcProductDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class AppConfig2 {

    @Value("${jdbc.driver}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName(driverClass);
        return DriverManager.getConnection(url,user,password);
    }

    @Lazy
    @Bean
    @Scope("singleton")
    @Primary
    public JdbcProductDao jdbcDao(Connection connection) {
//        JdbcProductDao dao = new JdbcProductDao();
//        dao.setConnection(connection);
//        return dao;
        return new JdbcProductDao();
    }
}
