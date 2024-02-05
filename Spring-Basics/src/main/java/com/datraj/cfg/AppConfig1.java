package com.datraj.cfg;


import com.datraj.dao.DummyProductDao;
import com.datraj.dao.JdbcProductDao;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig1 {
    @Lazy
    @Bean
    public DummyProductDao dummyDao(){
        return new DummyProductDao();
    }

    @Lazy
    @Bean
    @Scope("singleton")
    @Primary
    public JdbcProductDao jdbcDao(){
        JdbcProductDao dao = new JdbcProductDao();
        dao.setDriverClassName("java.sql.Driver");
        dao.setUrl("jdbc:postgresql://localhost:5432/spring-basics");
        dao.setUser("postgres");
        dao.setPassword("dhadas123");
        return dao;
    }
}
