package com.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

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
import com.service.AnimalService;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com" }, entityManagerFactoryRef = Constant.ENTITY_MANAGER_FACTORY_REFERENCE_NAME, transactionManagerRef = Constant.TRANSACTION_MANAGER_NAME)
public class ApplicationConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/" + Constant.DB_NAME);
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

	@Bean(name = Constant.ENTITY_MANAGER_FACTORY_REFERENCE_NAME)
	public LocalContainerEntityManagerFactoryBean factoryBean() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaProperties(properties());
		factoryBean.setPackagesToScan(new String[] { "com.entity" });
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return factoryBean;
	}

	@Bean(name = Constant.TRANSACTION_MANAGER_NAME)
	public PlatformTransactionManager platformTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(emf);
		return jpaTransactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor processor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public AnimalService animalService() {
		return new AnimalService();
	}

}
