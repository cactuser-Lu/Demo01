package Dao;

import java.sql.SQLException;

public interface userDao {
boolean checkName(String userName)throws SQLException;
}
