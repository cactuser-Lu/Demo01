package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCutil {
	static String driverClass=null;
	static String url=null;
	static String name=null;
	static String pw=null;
	static {
		try {
			Properties properties=new Properties();
			//InputStream is=new FileInputStream("jdbc.properties");
			InputStream is=JDBCutil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(is);
			driverClass=properties.getProperty("driverClass");
			name=properties.getProperty("name");
			url=properties.getProperty("url");
			pw=properties.getProperty("pw");//MySQL 驱动和数据库字符集设置不搭配可能导致出错，
			//加上这句?useUnicode=true&characterEncoding=utf8

			System.out.print(name+url+pw+driverClass);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection cnn() {
		Connection cnn=null;
		
		try {
			Class.forName(driverClass);
			cnn = DriverManager.getConnection(url,name,pw);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cnn;
	}
	public static void release(Connection cnn,Statement st,ResultSet rs) {
	closeRs(rs);	
	closeSt(st);
	closeCnn(cnn);
	}
	private static void closeRs(ResultSet rs) {
		try {
			if(rs!=null) {
			rs.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			rs=null;
		}
	}
	private static void closeSt(Statement st) {
		try {
			if(st!=null) {
			st.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			st=null;
		}
	}
	private static void closeCnn(Connection cnn) {
		try {
			if(cnn!=null) {
			cnn.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cnn=null;
		}
	}
	public static boolean isEmpty(String s) {
		return s==null||s.length()==0;
	}

}
