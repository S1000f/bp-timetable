package model.data;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DAOBase implements DAO {
	
	private static final DAOBase instance = new DAOBase();
	
	private DAOBase() {}
	
	public static DAOBase getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		String jdbcDriver = "org.mariadb.jdbc.Driver";
		String dbUrl = "jdbc:mariadb://localhost:3306/bptimetable";
		try {
			Class.forName(jdbcDriver);
			Connection conn = DriverManager.getConnection(dbUrl,"dohpkim","8175");
			if(conn == null)
				System.out.println("conn fail");		
			else 
				System.out.println("conn success");		
			return conn;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeDBResources(ResultSet rs, Statement stmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeDBResources(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void closeDBResources(PreparedStatement pstmt, Connection conn) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
