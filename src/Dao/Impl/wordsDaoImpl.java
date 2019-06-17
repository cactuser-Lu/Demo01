package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.wordBean;
import Dao.wordsDao;

public class wordsDaoImpl implements wordsDao {

	@Override
	public List<wordBean> findWords(String word) throws SQLException {
		// TODO Auto-generated method stub
		Connection cnn = Util.JDBCutil.cnn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<wordBean> list=new ArrayList<wordBean>();
        System.out.println(word);
		String sql="select * from words where word like ?";
		ps = cnn.prepareStatement(sql);
		ps.setString(1, word+"%");
		rs = ps.executeQuery();
		while(rs.next()) {
			wordBean wr = new wordBean();
			wr.setId(rs.getInt("id"));
			wr.setName(rs.getString("word"));
			list.add(wr);
			System.out.println(wr.getId()+wr.getName());
		}
		return list;
	}

}
