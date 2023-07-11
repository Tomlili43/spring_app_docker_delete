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
 * @Description: The configuration of fifth data srouce
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryFifth",
        transactionManagerRef = "transactionManagerFifth",
        // repository path, scanning repository pacakge
        basePackages = {"com.aift.lukie.Repository.Fifth"})
public class FifthJpaConfig {
    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    private HibernateProperties hibernateProperties;

    @Autowired
    @Qualifier("fifthDataSource")
    private DataSource fifthDataSource;

    @Bean(name = "fifthEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryFifth(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryFifth")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryFifth(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(fifthDataSource)
                // set jpa settings
                .properties(jpaProperties.getProperties())
                .properties(getVendorProperties())
                //set entity path 
                .packages("com.aift.lukie.Model.Fifth")
                .persistenceUnit("fifthPersistenceUnit")
                .build();
    }

    private Map getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }

    @Bean(name = "transactionManagerFifth")
    public PlatformTransactionManager transactionManagerFifth(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryFifth(builder).getObject());
    }
}
