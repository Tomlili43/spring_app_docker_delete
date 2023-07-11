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
        entityManagerFactoryRef = "entityManagerFactoryTeritary",
        transactionManagerRef = "transactionManagerTeritary",
        // repository path, scanning repository pacakge
        basePackages = {"com.aift.lukie.Repository.Teritary"})
public class TeritaryJpaConfig {
    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    private HibernateProperties hibernateProperties;

    @Autowired
    @Qualifier("teritaryDataSource")
    private DataSource teritaryDataSource;

    @Bean(name = "teritaryEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryTeritary(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryTeritary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryTeritary(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(teritaryDataSource)
                // set jpa settings
                .properties(jpaProperties.getProperties())
                .properties(getVendorProperties())
                //set entity path 
                .packages("com.aift.lukie.Model.Teritary")
                .persistenceUnit("teritaryPersistenceUnit")
                .build();
    }

    private Map getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }

    @Bean(name = "transactionManagerTeritary")
    public PlatformTransactionManager transactionManagerTeritary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryTeritary(builder).getObject());
    }
}
