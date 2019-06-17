package Dao;

import java.sql.SQLException;
import java.util.List;

public interface wordsDao {
     List<wordBean> findWords(String word) throws SQLException;
}
