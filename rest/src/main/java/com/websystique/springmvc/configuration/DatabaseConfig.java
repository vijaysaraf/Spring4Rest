package com.websystique.springmvc.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Bean
	DataSource dataSource() {
		Properties conProps = new Properties();
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
		}
		conProps.put("driverClassName", "org.apache.derby.jdbc.ClientDriver");
		conProps.put("username", "vijay");
		conProps.put("password", "saraf");
		DataSource ds = new DriverManagerDataSource("jdbc:derby://localhost:1527/vijaydb", conProps);
		return ds;
	}

	@Bean
	LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.websystique.springmvc.domain" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
				setProperty("hibernate.show_sql", "true");
			}
		};
	}
}
