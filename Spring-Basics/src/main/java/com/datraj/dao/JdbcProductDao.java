package com.datraj.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

@Getter
@Setter
@NoArgsConstructor
public class JdbcProductDao implements ProductDao{

    private String driverClassName;
    private String url;
    private String user;
    private String password;

    @Autowired(required = false)
    private Connection connection;

    @Autowired(required = false)
    private DataSource dataSource;

    private Connection createConnection() throws ClassNotFoundException, SQLException {

        if(dataSource != null) return dataSource.getConnection();
        if(connection != null && !connection.isClosed()) return connection;
        Class.forName(driverClassName);
        return DriverManager.getConnection(url,user,password);
    }

    @Override
    public long count() {
        try (
                Connection connection = createConnection();
                PreparedStatement statement = connection.prepareStatement("select count(*) from \"Track\" ");
                ResultSet rs = statement.executeQuery()

        ) {
            rs.next();
            return rs.getLong(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
