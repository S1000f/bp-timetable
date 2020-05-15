package model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;
	
	// TODO revision
	public Map<Integer, SubjectDto> readPlan(PlanDto plan) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select * from subject where user = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plan.getUser());
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
	
	public List<Integer> getWeekPlan(PlanDto plan) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select mon,tue,wed,thur,fri,sat,sun from plan where user = ? and year = ? and month = ? and week = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plan.getUser());
			pstmt.setInt(2, plan.getYear());
			pstmt.setInt(3, plan.getMonth());
			pstmt.setInt(4, plan.getWeek());
			rs = pstmt.executeQuery();
			
			List<Integer> list = new ArrayList<>();
			if(rs.next()) {
				list.add(rs.getInt("mon"));
				list.add(rs.getInt("tue"));
				list.add(rs.getInt("wed"));
				list.add(rs.getInt("thur"));
				list.add(rs.getInt("fri"));
				list.add(rs.getInt("sat"));
				list.add(rs.getInt("sun"));
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(rs, pstmt, conn);
		}
		
		return null;
	}
	
	public int checkPlan(PlanDto plan) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select user from plan where user = ? and year = ? and month = ? and week = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plan.getUser());
			pstmt.setInt(2, plan.getYear());
			pstmt.setInt(3, plan.getMonth());
			pstmt.setInt(4, plan.getWeek());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(rs, pstmt, conn);
		}
		
		return -1;
	}
	
	public int insertPlan(PlanDto plan) {
		
		int result = -1;
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "insert into plan (user, year, month, week, mon, tue, wed, thur, fri, sat, sun) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plan.getUser());
			pstmt.setInt(2, plan.getYear());
			pstmt.setInt(3, plan.getMonth());
			pstmt.setInt(4, plan.getWeek());
			for(int i = 0; i < 7; i++) {
				pstmt.setInt(i + 5, plan.getPlanList().get(i));
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(pstmt, conn);
		}
		
		return result;
	}
	
	public int updatePlan(PlanDto plan) {
		
		int result = -1;
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "insert into subject (user, sid, sub_name, color, teacher, description) VALUES(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, sub.getUser());
//			pstmt.setInt(2, sub.getSid());
//			pstmt.setString(3, sub.getSubjectName());
//			pstmt.setString(4, sub.getColorTag());
//			pstmt.setString(5, sub.getTeacher());
//			pstmt.setString(6, sub.getDesc());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(pstmt, conn);
		}
		
		return result;
	}
	
	//TODO implement later
	public int deletePlan(PlanDto plan) {
		return 0;
	}
		
}