package test;



import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Teststudent {
	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		BasicDataSource ds=(BasicDataSource) c.getBean("dataSource");
		System.out.println(ds.getDriverClassName());
		System.out.println(ds.getUrl());
	}


	
}
