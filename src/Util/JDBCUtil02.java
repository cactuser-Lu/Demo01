package Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil02 {
	static String driverClass=null;
	static String url=null;
	static String name=null;
	static String pw=null;
	static ComboPooledDataSource datasource=null;
	static {
		datasource=new ComboPooledDataSource();
	}

	public static DataSource getDataSource() {
		
		return datasource;
	}
	public static Connection cnn() throws SQLException {

		return datasource.getConnection();
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

}
