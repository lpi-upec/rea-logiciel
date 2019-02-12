package fr.edenskull.demojpa.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {
	private static final String JPA_PACKAGES_TO_SCAN = "fr.edenskull.demojpa.model.*";
	public static final String JPA_PERSISTANCE_UNIT_NAME = "demo-jpa-unit";

	@Bean
	public DataSource dataSource(
			@Value("${spring.datasource.url}") String jdbcUrl,
			@Value("${spring.datasource.username}") String username,
			@Value("${spring.datasource.password}") String password,
			@Value("${spring.datasource.driver-class-name}") String driveClassName
	) {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(username);
		config.setPassword(password);
		config.setDriverClassName(driveClassName);
		return new HikariDataSource(config);
	}
}
