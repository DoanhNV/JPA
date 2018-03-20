package com.config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.constant.Constant;
import com.dao.RoomDAO;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com" }, entityManagerFactoryRef = Constant.ENTITY_MANAGER_REFERENCE_NAME, transactionManagerRef = "transactionEM")
public class ApplicationConfig {

	@Autowired
	public EntityManager entityManager;

	@Bean
	public DataSource configDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jparoomdb");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	private Properties properties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

	@Bean(name = Constant.ENTITY_MANAGER_REFERENCE_NAME)
	public LocalContainerEntityManagerFactoryBean factoryBean() {
		LocalContainerEntityManagerFactoryBean emFactoryContainer = new LocalContainerEntityManagerFactoryBean();
		emFactoryContainer.setDataSource(configDataSource());
		emFactoryContainer.setJpaProperties(properties());
		emFactoryContainer.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emFactoryContainer.setPackagesToScan(new String[] { "com.entity" });
		emFactoryContainer.setPersistenceUnitName("em");
		return emFactoryContainer;
	}

	@Bean(name = "transactionEM")
	public PlatformTransactionManager platformTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public RoomDAO createRoomDAO() {
		return new RoomDAO(entityManager);
	}
}
