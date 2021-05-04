package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Course;

public class CourseDao {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost:3306/soccersys?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	// 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "gn131313";
    
    public List<Course> queryCourse() {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "select * from course;";
		List<Course> list = new ArrayList<Course>();
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ResultSet rs= ptmt.executeQuery();
	        while(rs.next()) {
	        	list.add(new Course(rs.getInt("courseID"), rs.getString("courseName"), rs.getString("courseGrade"), rs.getString("coachName"), 
	        			 rs.getString("coachUserName"), rs.getString("time"), rs.getString("description")));
	        }
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
    }
    
	public int addCourse(Course course){
		Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO course(courseName, courseGrade, coachName, time, description, coachUserName) "
				+ "values(?, ?, ?, ?, ?, ?)";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, course.getCourseName());
	        ptmt.setString(2, course.getCourseGrade());
	        ptmt.setString(3, course.getCoachName());
	        ptmt.setString(4, course.getTime());
	        ptmt.setString(5, course.getDescription());
	        ptmt.setString(6, course.getCoachUserName());
	        ptmt.execute();
			return 1;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
			
		}
		
	}
	
	public List<Course> queryCoachCourse(String coachUserName) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "select * from course where coachUserName = ?;";
		List<Course> list = new ArrayList<Course>();
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, coachUserName);
	        ResultSet rs= ptmt.executeQuery();
	        while(rs.next()) {
	        	list.add(new Course(rs.getInt("courseID"), rs.getString("courseName"), rs.getString("courseGrade"), rs.getString("coachName"), 
	        			 rs.getString("coachUserName"), rs.getString("time"), rs.getString("description")));
	        }
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
    }
}
