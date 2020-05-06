package model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// TODO revision
public class LoginDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;
	
	public LoginDao() {
		
	}
	
	public LoginDto loginUser(LoginDto user) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select * from USER where USER = ? and PASSWD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new LoginDto(rs.getString("USER"), rs.getString("PASSWD"), rs.getInt("HAS_SUB"), rs.getInt("HAS_PLAN"));
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(rs, pstmt, conn);
		}
		
		return null;
	}
	
	public int checkUser(LoginDto user) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select * from USER where USER = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 2;
			} else {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(rs, pstmt, conn);
		}
		
		return 3;
	}
	
	public int insertUser(LoginDto user) {
		
		int result = -1;
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "insert into USER VALUES(?, ?, 0, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser());
			pstmt.setString(2, user.getPassword());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(pstmt, conn);
		}
		
		return result;
	}
	
	//TODO revision
	public int updateMember(LoginDto user) {
		
		int result = 0;
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "UPDATE MEMBER SET EMAIL= ? WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(pstmt, conn);
		}
		
		return result;
	}
	
	//TODO revision
	public int deleteMember(LoginDto user) {
		return 0;
	}
	
		
}