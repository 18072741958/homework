package com.example.multidatasource.config;

import com.example.multidatasource.bean.MyRoutingDataSource;
import com.example.multidatasource.enums.DBTypeEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave1")
    public DataSource slaveDataSource1(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave2")
    public DataSource slaveDataSource2(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSource routingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource
            ,@Qualifier("slaveDataSource1") DataSource slaveDatasource1
            ,@Qualifier("slaveDataSource2") DataSource slaveDatasource2){
        Map<Object,Object> datasources = new HashMap<>();
        datasources.put(DBTypeEnum.MASTAR,masterDataSource);
        datasources.put(DBTypeEnum.SLAVE1,slaveDatasource1);
        datasources.put(DBTypeEnum.SLAVE2,slaveDatasource2);
        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        myRoutingDataSource.setTargetDataSources(datasources);
        return masterDataSource;
    }




}
