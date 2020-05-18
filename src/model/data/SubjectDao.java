package model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class SubjectDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;
	
	public Map<Integer, SubjectDto> readSubject(SubjectDto sub) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select * from subject where user = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub.getUser());
			rs = pstmt.executeQuery();
			
			Map<Integer, SubjectDto> subjectMap = new HashMap<>();
			for(int i = 1; rs.next(); i++) {
				subjectMap.put(i, new SubjectDto(
						rs.getString("user"), rs.getInt("sid"), rs.getString("sub_name"),
						rs.getString("color"), rs.getString("teacher"),
						rs.getString("description")));
			}
			
			return subjectMap;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(rs, pstmt, conn);
		}
		
		return null;
	}
	
	public int readNumOfSub(SubjectDto sub) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select count(user) from subject where user = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub.getUser());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("count(user)");
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(rs, pstmt, conn);
		}
		
		return -2;
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
	
	public int updateHasSub(SubjectDto sub) {
		
		int result = -1;
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "update USER set HAS_SUB = 1 where user = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sub.getUser());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(pstmt, conn);
		}
		
		return result;
	}
	
	public int deleteSubject(String user, int sid) {
		int result = -1;
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "delete from subject where user = ? and sid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setInt(2, sid);
			result = pstmt.executeUpdate();
			
			System.out.println(result);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(pstmt, conn);
		}
		
		return result;
	}
		
}