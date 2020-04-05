package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DAO {
	public Connection getConnection() throws SQLException;
	public void closeDBResources(ResultSet rs, Statement stmt, Connection conn);
	public void closeDBResources(ResultSet rs, PreparedStatement pstmt, Connection conn);
	public void closeDBResources(PreparedStatement pstmt, Connection conn);
}
