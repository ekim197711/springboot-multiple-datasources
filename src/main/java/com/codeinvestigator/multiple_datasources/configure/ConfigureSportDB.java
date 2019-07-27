package com.codeinvestigator.multiple_datasources.configure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        transactionManagerRef = "sportTransactionManager",
        entityManagerFactoryRef = "sportEntityManagerFactory",
        basePackages = { "com.codeinvestigator.multiple_datasources.sport" }
)
public class ConfigureSportDB {
    @Bean(name="sportDSProps")
    @ConfigurationProperties("sport.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean(name = "sportDataSource")
    @ConfigurationProperties("sport.datasource")
    public DataSource dataSource(@Qualifier("sportDSProps") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "sportEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sportEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("sportDataSource") DataSource sportDataSource
    ) {
        return
                builder.dataSource(sportDataSource)
                        .packages("com.codeinvestigator.multiple_datasources.sport")
                        .persistenceUnit("sport")
                        .build();
    }

    @Bean(name = "sportTransactionManager")
    @ConfigurationProperties("sport.jpa")
    public PlatformTransactionManager sportTransactionManager(
            @Qualifier("sportEntityManagerFactory") EntityManagerFactory
                    sportEntityManagerFactory
    ) {
        return new JpaTransactionManager(sportEntityManagerFactory);
    }
}


