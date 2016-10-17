package br.com.caelum;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class JpaConfigurator {

	@Bean(destroyMethod = "close")
	public DataSource getDataSource() throws PropertyVetoException {
//	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("org.postgresql.Driver");
//	    dataSource.setUrl("jdbc:postgresql://localhost/projeto_jpa");
//	    dataSource.setUsername("postgres");
//	    dataSource.setPassword("root");
	    
	    ComboPooledDataSource dataSource = new ComboPooledDataSource();
	    dataSource.setDriverClass("org.postgresql.Driver");
	    dataSource.setUser("postgres");
	    dataSource.setPassword("root");
	    dataSource.setJdbcUrl("jdbc:postgresql://localhost/projeto_jpa");
	    
	    dataSource.setMinPoolSize(5); //defaut 3
	    dataSource.setMaxPoolSize(10); //defaut 15
	    dataSource.setNumHelperThreads(5);
	    
	    dataSource.setIdleConnectionTestPeriod(1); //a cada um segundo testamos as conexões ociosas

	    return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setPackagesToScan("br.com.caelum");
		entityManagerFactory.setDataSource(dataSource);

		entityManagerFactory
				.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties props = new Properties();

		props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		props.setProperty("hibernate.cache.use_secund_level_cache", "true");
		props.setProperty("hibernate.cache.use_query_cache", "true");
		props.setProperty("hibernate.generate_statistics", "true");
		props.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");

		entityManagerFactory.setJpaProperties(props);
		return entityManagerFactory;
	}

	@Bean
	public JpaTransactionManager getTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public Statistics statistics(EntityManagerFactory emf){
		SessionFactory sf = emf.unwrap(SessionFactory.class);
		return sf.getStatistics();
	}
}
