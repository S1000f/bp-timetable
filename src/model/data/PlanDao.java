package model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PlanDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;
	
	public Map<Integer, List<Integer>> readMonthPlan(String user, int year, int month) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select week, mon,tue,wed,thur,fri,sat,sun from plan where user = ? and year = ? and month = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setInt(2, year);
			pstmt.setInt(3, month);
			rs = pstmt.executeQuery();
			
			Map<Integer, List<Integer>> planMap = new TreeMap<>();
			while(rs.next()) {
				List<Integer> list = new ArrayList<>();
				list.add(rs.getInt("mon"));
				list.add(rs.getInt("tue"));
				list.add(rs.getInt("wed"));
				list.add(rs.getInt("thur"));
				list.add(rs.getInt("fri"));
				list.add(rs.getInt("sat"));
				list.add(rs.getInt("sun"));
				planMap.put(rs.getInt("week"), list);
			}
			
			return planMap;
			
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
	
	public Map<Integer, String> getSubNamesMap(String user) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select sid, sub_name from subject where user = ? order by sid asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			rs = pstmt.executeQuery();
			
			Map<Integer, String> temp = new TreeMap<>(); 
			while(rs.next()) {
				temp.put(rs.getInt("sid"), rs.getString("sub_name"));
			}
			
			return temp;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAOBase.getInstance().closeDBResources(rs, pstmt, conn);
		}
		
		return null;
	}
	
	public Map<Integer, String> getSubTagsMap(String user) {
		
		try {
			conn = DAOBase.getInstance().getConnection();
			sql = "select sid, color from subject where user = ? order by sid asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			rs = pstmt.executeQuery();
			
			Map<Integer, String> temp = new TreeMap<>(); 
			while(rs.next()) {
				temp.put(rs.getInt("sid"), rs.getString("color"));
			}
			
			return temp;
			
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
			sql = "update plan set mon=?, tue=?, wed=?, thur=?, fri=?, sat=?, sun=? where user = ? and year = ? and month = ?"
					+ " and week = ?";
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < 7; i++) {
				pstmt.setInt(i + 1, plan.getPlanList().get(i));
			}
			pstmt.setString(8, plan.getUser());
			pstmt.setInt(9, plan.getYear());
			pstmt.setInt(10, plan.getMonth());
			pstmt.setInt(11, plan.getWeek());
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