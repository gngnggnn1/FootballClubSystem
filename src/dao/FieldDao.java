package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Field;

public class FieldDao {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost:3306/soccersys?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	// 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "gn131313";
    
	public List<Field> queryField() {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "select * from field;";
		List<Field> list = new ArrayList<Field>();
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ResultSet rs= ptmt.executeQuery();
	        while(rs.next()) {
	        	list.add(new Field(rs.getInt("fieldID"), rs.getString("fieldName"), rs.getString("location"), rs.getString("description"), 
	        			rs.getInt("size"), rs.getInt("price"), rs.getInt("hasLight"), rs.getInt("inDoor"), rs.getInt("realGrass"), rs.getInt("hasShop")));
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
    
    public int addField(Field field){
		Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO field(fieldID, fieldName, location, description, size, price, hasLight, inDoor, realGrass, hasShop) "
				+ "values(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, field.getFieldName());
	        ptmt.setString(2, field.getLocation());
	        ptmt.setString(3, field.getDescription());
	        ptmt.setInt(4, field.getSize());
	        ptmt.setInt(5, field.getPrice());
	        ptmt.setInt(6, field.getHasLight());
	        ptmt.setInt(7, field.getInDoor());
	        ptmt.setInt(8, field.getRealGrass());
	        ptmt.setInt(9, field.getHasShop());
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
    
    public int updateField(Field field) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "UPDATE field "
				+ "SET description = ?, size = ?, price = ?, hasLight = ?, inDoor = ?, realGrass = ?, hasShop = ? "
				+ "WHERE fieldID = ?";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, field.getDescription());
	        ptmt.setInt(2, field.getSize());
	        ptmt.setInt(3, field.getPrice());
	        ptmt.setInt(4, field.getHasLight());
	        ptmt.setInt(5, field.getInDoor());
	        ptmt.setInt(6, field.getRealGrass());
	        ptmt.setInt(7, field.getHasShop());
	        ptmt.setInt(8, field.getFieldID());
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
    
    public int removeField(int fieldID) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "DELETE FROM field WHERE fieldID = ?";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setInt(1, fieldID);
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
    
    
}
