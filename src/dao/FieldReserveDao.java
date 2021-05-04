package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Field;
import entity.FieldReserve;

public class FieldReserveDao {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost:3306/soccersys?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	// 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "gn131313";
    
    public int reserveField(String userName, String fieldName, String date) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO fieldreserve (`userName`, `date`, `fieldName`) VALUES (?, ?, ?)";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, userName);
	        ptmt.setString(2, date);
	        ptmt.setString(3, fieldName);
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
    
    public List<FieldReserve> queryFieldReserve(String userName) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "select * from fieldReserve WHERE userName = ?";
		List<FieldReserve> list = new ArrayList<FieldReserve>();
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, userName);
	        ResultSet rs= ptmt.executeQuery();
	        while(rs.next()) {
	        	list.add(new FieldReserve(rs.getString("userName"), rs.getString("date"), rs.getString("fieldName")));
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
    public int fieldReserveSum() {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "SELECT count(*) as fieldReserveSum FROM fieldReserve";
		int fieldReserveSum = 0;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ResultSet rs= ptmt.executeQuery();
	        rs.first();
	        fieldReserveSum = rs.getInt("fieldReserveSum");
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
		return fieldReserveSum;
    }
}
