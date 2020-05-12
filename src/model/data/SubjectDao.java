package model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SubjectDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;
	
	// TODO revision
	public SubjectDto readSubject(SubjectDto sub) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select * from USER where USER = ? and PASSWD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub.getUser());
			pstmt.setString(2, sub.getSubjectName());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//sub = new LoginDto(rs.getString("USER"), rs.getString("PASSWD"), rs.getInt("HAS_SUB"), rs.getInt("HAS_PLAN"));
				return sub;
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
	//TODO
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
	
	public int insertSubject(SubjectDto sub) {
		
		int result = -1;
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "insert into subject (user, sid, sub_name, color, teacher, description) VALUES(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub.getUser());
			pstmt.setInt(2, sub.getSid());
			pstmt.setString(3, sub.getSubjectName());
			pstmt.setString(4, sub.getColorTag());
			pstmt.setString(5, sub.getTeacher());
			pstmt.setString(6, sub.getDesc());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(pstmt, conn);
		}
		
		return result;
	}
	
	//TODO implement later
	public int deleteMember(LoginDto user) {
		return 0;
	}
		
}