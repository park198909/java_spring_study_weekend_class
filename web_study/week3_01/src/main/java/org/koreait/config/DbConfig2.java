package org.koreait.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfig2 {
	@Configuration
	@Profile("dev") // spring.profiles.active=dev 
	static class DbDevConfig{
		@Bean(destroyMethod="close")
		public DataSource dataSource() {
			System.out.println("Dev : DataSource");
			DataSource ds = new DataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost/springdb");
			ds.setUsername("root");
			ds.setPassword("aA!123456");
			ds.setInitialSize(2);
			ds.setMaxActive(10);
			ds.setTestWhileIdle(true);
			ds.setMinEvictableIdleTimeMillis(10000);
			ds.setTimeBetweenEvictionRunsMillis(3000);
			
			return ds;
		}
		
		@Bean
		public JdbcTemplate jdbcTemplate() {
			return new JdbcTemplate(dataSource());
		}
	}
	
	@Configuration
	@Profile("real")  // spring.profiles.active=real 
	static class DbRealConfig{
		@Bean(destroyMethod="close")
		public DataSource dataSource() {
			System.out.println("Real : DataSource");
			DataSource ds = new DataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost/springdb");
			ds.setUsername("root");
			ds.setPassword("aA!123456");
			ds.setInitialSize(2);
			ds.setMaxActive(10);
			ds.setTestWhileIdle(true);
			ds.setMinEvictableIdleTimeMillis(10000);
			ds.setTimeBetweenEvictionRunsMillis(3000);
			
			return ds;
		}
		
		@Bean
		public JdbcTemplate jdbcTemplate() {
			return new JdbcTemplate(dataSource());
		}
	}
}
