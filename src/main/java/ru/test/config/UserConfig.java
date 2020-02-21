package ru.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@ComponentScan(value = "ru.test")
@EnableTransactionManagement
public class UserConfig implements TransactionManagementConfigurer {
	@Bean
	public DataSource postgresqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/users");
		dataSource.setUsername("turbak");
		dataSource.setPassword("3361406");

		return dataSource;
	}
	@Bean
	@Autowired
	@Qualifier("postgresqlDataSource")
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Override
	public TransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(postgresqlDataSource());
	}
}
