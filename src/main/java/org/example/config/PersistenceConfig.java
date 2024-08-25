package org.example.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories // it available when use SPRING DATA JPA
public class PersistenceConfig {

    @Bean
    DriverManagerDataSource dataSource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl(System.getenv("DB_SERVER"));
        datasource.setUsername(System.getenv("DB_USERNAME"));
        datasource.setPassword(System.getenv("DB_PASSWORD"));

        return datasource;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("org.example.entity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        emf.setPersistenceUnitName("postgresPU"); // use this while not using SPRING DATA JPA

        return emf;
    }

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }
}
