package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import Dao.userDao;
import Util.JDBCUtil02;

public class userDaoImpl implements userDao {

	@Override
	public boolean checkName(String userName) throws SQLException {
		// TODO Auto-generated method stub
		//QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		Connection cnn = Util.JDBCutil.cnn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		

		String sql="select * from t_user where username=?";
		ps = cnn.prepareStatement(sql);
		ps.setString(1, userName);
		rs = ps.executeQuery();
		int n=0;
		while(rs.next()) {
			n = rs.getInt("id");
		
		}
		return n>0;
		
	}

}
