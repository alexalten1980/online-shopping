package ag.alten.shoppingbackend.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "ag.alten.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource){
		LocalSessionFactoryBuilder local = new LocalSessionFactoryBuilder(datasource);
		local.addProperties(getHibernateProprieta());
		local.scanPackages("ag.alten.shoppingbackend.dto");
		return local.buildSessionFactory();
	}

	private Properties getHibernateProprieta() {
		Properties property = new Properties();
		property.put("hibernate.dialect", DATABASE_DIALECT);
		property.put("hibernate.show_sql", "true");
		property.put("hibernate.format_sql", "true");
		property.put("hibernate.hbm2ddl.auto", "update");
		
		return property;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager hbTxManager = new HibernateTransactionManager(sessionFactory);
		
		return hbTxManager;
		
	}
	
}
