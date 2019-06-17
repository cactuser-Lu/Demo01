package lab3;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;


import Util.JDBCUtil02;

public class DBUtilDemo{
	
	public void test() {
		try {
			//ComboPooledDataSource ds = new ComboPooledDataSource();
//			ds.setDriverClass("com.mysql.jdbc.Driver");
//    		ds.setJdbcUrl("jdbc:mysql://localhost/stus?useUnicode=true&characterEncoding=utf8");
//    		ds.setUser("root");
//    		ds.setPassword("831015");
    		
//			cnn = ds.getConnection();
			//QueryRunner qr = new QueryRunner(JDBCUtil02.getDataSource());
			//qr.update("insert into bank values(null,?,?)","dbutil02",100);
			ComboPooledDataSource ds = new ComboPooledDataSource();
			QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
			
			String sql="insert into bank values(null,?,?)";
			runner.update(sql,"aaa02",666);
//			List<Student> list=runner.query(sql, new BeanListHandler<Student>(Student.class));
//			for(Student str:list) {
//				System.out.println(str.getSid());
//				System.out.println(str.getSname());
//			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
