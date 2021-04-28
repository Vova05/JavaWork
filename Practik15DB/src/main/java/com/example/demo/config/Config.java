//package com.example.demo.config;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//public class Config {
//    @Bean
//    public HikariDataSource dataSource()
//    {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("your_url");
//        config.setUsername("your_username");
//        config.setPassword("your_password");
//        return new HikariDataSource(config);
//    }
//    @Bean
//    public LocalSessionFactoryBean factoryBean(DataSource dataSource)
//    {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setPackagesToScan("your_packages_to_scan");
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", "your_dialect");
//        sessionFactoryBean.setHibernateProperties(properties);
//        return sessionFactoryBean;
//    }
//    @Bean
//    public PlatformTransactionManager platformTransactionManager(LocalSessionFactoryBean factoryBean)
//    {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(factoryBean.getObject());
//        return transactionManager;
//    }
//}
