package model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//TODO
public class LoginDB {
	
	private static LoginDB instance = new LoginDB();
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;
	
	private LoginDB() {}
	
	public static LoginDB getInstance() {
		return instance;
	}
	
	//TODO
	public int insertMember(LoginDto user) {
		
		int result = 0;
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "insert into member VALUES((select nvl(max(num),0)+1 from member), ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(pstmt, conn);
		}
		
		return result;
	}
	
	//TODO
	public int updateMember(LoginDto user) {
		
		int result = 0;
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "UPDATE MEMBER SET EMAIL= ? WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(pstmt, conn);
		}
		
		return result;
	}
	
	//TODO
	public int deleteMember(LoginDto user) {
		return 0;
	}
	
	//TODO
	public LoginDto readMember(LoginDto user) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select * from member where ID = ? and PW = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new LoginDto();
				user.setId(rs.getString("ID"));
				user.setId(rs.getString("PW"));
				user.setId(rs.getString("EMAIL"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(rs, pstmt, conn);
		}
		
		return user;
		
	}
	
	//TODO
	public int loginUser(LoginDto user) {
		return 1;
	}
	
}