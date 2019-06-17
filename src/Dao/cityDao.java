package Dao;

import java.sql.SQLException;
import java.util.List;

public interface cityDao {
	List<CityBean> findCity(int cid)throws SQLException;
	String findAllJson(int cid);
}
