package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Course;
import entity.CourseInf;

public class CourseInfDao {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost:3306/soccersys?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	// 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "gn131313";

	public int attendCourse(Course course, String userName){
		Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO courseInf(courseID, userName, courseName) "
				+ "values(?, ?, ?)";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setInt(1, course.getCourseID());
	        ptmt.setString(2, userName);
	        ptmt.setString(3, course.getCourseName());
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
	
	public List<CourseInf> queryMyCourseInf(String userName) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "SELECT * from courseInf WHERE userName = ?";
		List<CourseInf> list = new ArrayList<CourseInf>();
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, userName);
	        ResultSet rs= ptmt.executeQuery();
	        while(rs.next()) {
	        	list.add(new CourseInf(rs.getInt("courseInfID"), rs.getInt("courseID"), rs.getString("userName"), rs.getString("courseName")));
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
	
	 public int courseInfSum() {
	    	Connection conn = null;
			PreparedStatement ptmt = null;
			String sql = "SELECT count(*) as courseInfSum FROM courseInf";
			int courseInfSum = 0;
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
		        ptmt = conn.prepareStatement(sql);
		        ResultSet rs= ptmt.executeQuery();
		        rs.first();
		        courseInfSum = rs.getInt("courseInfSum");
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
			return courseInfSum;
	    }
}
