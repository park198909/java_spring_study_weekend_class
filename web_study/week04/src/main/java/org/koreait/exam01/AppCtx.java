package org.koreait.exam01;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("org.koreait.exam01")
public class AppCtx {
	
	@Bean
	public DataSource dataSource() {		
		//데이터베이스 기본설정
		DataSource ds = new DataSource();
		String url = "jdbc:mysql://localhost:3306/springdb";
		ds.setUrl(url);
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("aA!123456");
		//스프링풀 설정
		ds.setInitialSize(2);
		ds.setTestWhileIdle(true);
		ds.setTimeBetweenEvictionRunsMillis(1000*10); // 10초 간격으로 연결체크
		ds.setMinEvictableIdleTimeMillis(1000*30); 	
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
}
