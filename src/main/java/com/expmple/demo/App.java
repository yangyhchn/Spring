package com.expmple.demo;

import com.expmple.demo.config.SpringConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Hello world!
 */
public class App {
    private static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource ds = context.getBean(DataSource.class);
        Connection conn = ds.getConnection();
        conn.close();
    }
}
