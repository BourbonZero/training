package util;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
@Component
public class JDBCUtil {

	private static String user = "root";
	private static String password = "150607";
	private static String url = "jdbc:mysql://localhost:3306/j2ee?useSSL=false";
	private static String className = "com.mysql.jdbc.Driver";

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(className);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
}
