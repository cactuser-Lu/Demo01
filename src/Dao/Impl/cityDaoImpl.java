package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.CityBean;
import Dao.cityDao;
import Dao.wordBean;
import Util.JedisPoolUtil;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

public class cityDaoImpl implements cityDao {

	
	@Override
	public List<CityBean> findCity(int cid) throws SQLException {
		// TODO Auto-generated method stub
		Connection cnn = Util.JDBCutil.cnn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<CityBean> list=new ArrayList<CityBean>();

		String sql="select * from city where cid=?";
		ps=cnn.prepareStatement(sql);
		ps.setInt(1, cid);
		rs=ps.executeQuery();
		while(rs.next()) {
			CityBean cb = new CityBean();
			cb.setId(rs.getInt("id"));
			cb.setCname(rs.getString("cname"));
			cb.setCid(cid);
			list.add(cb);
		}
		return list;
	}
	
	public String findAllJson(int cid) {
		Jedis je = JedisPoolUtil.getJedis();
		String cname = je.get("cname"+cid);
		if(cname==null||cname.length()==0) {
			System.out.println("没有缓存...");
			
				List<CityBean> list;
				try {
					list = findCity(cid);
					JSONArray jsonarray = JSONArray.fromObject(list);
					cname = jsonarray.toString();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				try {
					je.set("cname"+cid, cname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("有缓存了..");
		}
		return cname;
	}

}
