package com.aift.lukie.config;

import java.util.*;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @Description: The configuration of teritary data srouce
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryVisualization",
        transactionManagerRef = "transactionManagerVisualization",
        // repository path, scanning repository pacakge
        basePackages = {"com.aift.lukie.Repository.Visualization"})
public class VisualizationJpaConfig {
    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    private HibernateProperties hibernateProperties;

    @Autowired
    @Qualifier("visualizationDataSource")
    private DataSource visualizationDataSource;

    @Bean(name = "visualizationEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryVisualization(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryVisualization")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryVisualization(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(visualizationDataSource)
                // set jpa settings
                .properties(jpaProperties.getProperties())
                .properties(getVendorProperties())
                //set entity path 
                .packages("com.aift.lukie.Model.Visualization")
                .persistenceUnit("visualizationPersistenceUnit")
                .build();
    }

    private Map getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }

    @Bean(name = "transactionManagerVisualization")
    public PlatformTransactionManager transactionManagerVisualization(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryVisualization(builder).getObject());
    }
}
