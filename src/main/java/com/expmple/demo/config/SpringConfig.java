package com.expmple.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${c3p0.initialPoolSize}")
    private int initialPoolSize;
    @Value("${c3p0.minPoolSize}")
    private int minPoolSize;
    @Value("${c3p0.maxPoolSize}")
    private int maxPoolSize;
    @Value("${c3p0.acquireIncrement}")
    private int acquireIncrement;
    @Value("${c3p0.maxIdleTime}")
    private int maxIdleTime;

    @Bean("c3p0")
    @Scope("singleton")
    public DataSource dataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            ds.setInitialPoolSize(initialPoolSize);
            ds.setMinPoolSize(minPoolSize);
            ds.setMaxPoolSize(maxPoolSize);
            ds.setAcquireIncrement(acquireIncrement);
            ds.setMaxIdleTime(maxIdleTime);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }
}
