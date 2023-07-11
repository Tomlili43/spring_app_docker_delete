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
 * @Description: The configuration of fourth data srouce
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryFourth",
        transactionManagerRef = "transactionManagerFourth",
        // repository path, scanning repository pacakge
        basePackages = {"com.aift.lukie.Repository.Fourth"})
public class FourthJpaConfig {
    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    private HibernateProperties hibernateProperties;

    @Autowired
    @Qualifier("fourthDataSource")
    private DataSource fourthDataSource;

    @Bean(name = "fourthEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryFourth(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryFourth")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryFourth(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(fourthDataSource)
                // set jpa settings
                .properties(jpaProperties.getProperties())
                .properties(getVendorProperties())
                //set entity path 
                .packages("com.aift.lukie.Model.Fourth")
                .persistenceUnit("fourthPersistenceUnit")
                .build();
    }

    private Map getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }

    @Bean(name = "transactionManagerFourth")
    public PlatformTransactionManager transactionManagerFourth(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryFourth(builder).getObject());
    }
}
