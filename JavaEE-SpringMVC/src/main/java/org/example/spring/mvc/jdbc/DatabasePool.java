package org.example.spring.mvc.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class DatabasePool {
    private static HikariDataSource hikariDataSource;

    public static HikariDataSource getHikariDataSource(){

        if(null != hikariDataSource){
            return hikariDataSource;
        }

        synchronized (DatabasePool.class) {
            if(null ==hikariDataSource){
                ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
                Resource res = resolver.getResource("classpath:app-context.xml");
                String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/test2?userUnicode=true&characterEncoding=utf8&useSSL=false";
                String driverName = "com.mysql.jdbc.Driver";
                HikariConfig hikariConfig = new HikariConfig();
                hikariConfig.setUsername("root");
                hikariConfig.setPassword("991015");
                hikariConfig.setDriverClassName("driverName");
                hikariConfig.setJdbcUrl(jdbcUrl);
                hikariDataSource = new HikariDataSource(hikariConfig);
                return hikariDataSource;
            }
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        getHikariDataSource();
        Thread.sleep( 3000);
    }
}
