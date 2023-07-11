package com.aift.lukie.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;


/**
 * @Description: data source configuration 
 * @return
*/

@Configuration
public class DataSourceConfig {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DataSourceConfig.class);

    /**
     * @Description: datasource 1
     * @return
     */
    @Primary
    @Bean(value = "primaryDataSource")
    @ConfigurationProperties("spring.datasource.druid.primary")
    public DataSource dataSourceOne(){
        log.info("<------ Init DataSourceOne ------>");
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * @Description: datasoruce 2 
     * @return 
     */
    @Bean(value = "secondDataSource")
    @ConfigurationProperties("spring.datasource.druid.secondary")
    public DataSource dataSourceTwo(){
        log.info(" <------ Init DataSourceTwo ------> ");
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * @Description: datasource 3
     * @return 
     */
    @Bean(value = "teritaryDataSource")
    @ConfigurationProperties("spring.datasource.druid.tertiary")
    public DataSource dataSourceThree(){
        log.info("<------ Init DataSourceThree ------>");
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * @Description: datasource 4
     * @return 
     */
    @Bean(value = "fourthDataSource")
    @ConfigurationProperties("spring.datasource.druid.fourth")
    public DataSource dataSourceFour(){
        log.info("<------ Init DataSourceFour ------>");
        return DruidDataSourceBuilder.create().build();
    }
    
    /**
     * @Description: datasource 5
     * @return 
     */
    @Bean(value = "visualizationDataSource")
    @ConfigurationProperties("spring.datasource.druid.visualization")
    public DataSource dataSourceVisualization(){
        log.info("<------ Init DataSourceVisualization ------>");
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * @Description: datasource 6
     * @return 
     */
    @Bean(value = "fifthDataSource")
    @ConfigurationProperties("spring.datasource.druid.fifth")
    public DataSource dataSourceFive(){
        log.info("<------ Init DataSourceFive ------>");
        return DruidDataSourceBuilder.create().build();
    }
}
