package model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// TODO revision
public class LoginDB {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;
	
	public LoginDB() {
		
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
				user = new LoginDto(rs.getString("USER"), rs.getString("PASSWD"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(rs, pstmt, conn);
		}
		
		return null;
	}
	
	//TODO revision
	public int insertMember(LoginDto user) {
		
		int result = 0;
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "insert into member VALUES((select nvl(max(num),0)+1 from member), ?, ?)";
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