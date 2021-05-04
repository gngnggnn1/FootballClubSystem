package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDao {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost:3306/soccersys?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	// 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "gn131313";
    
    public int teamRegister(User user) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO user(userName, password, teamID, identity) "
				+ "values(?, ?, ?, 3)";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, user.getUserName());
	        ptmt.setString(2, user.getPassword());
	        ptmt.setInt(3, user.getTeamID());
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
    
    public int register(User user) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO user(userName, password, identity, realName, sex, age, phone) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, user.getUserName());
	        ptmt.setString(2, user.getPassword());
	        ptmt.setInt(3, user.getIdentity());
	        ptmt.setString(4, user.getRealName());
	        ptmt.setString(5, user.getSex());
	        ptmt.setInt(6, user.getAge());
	        ptmt.setString(7, user.getPhone());
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
    
    public int removeTeamUser(int teamID) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "DELETE FROM user WHERE teamID = ? and identity = 3";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setInt(1, teamID);
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
    
    public int setUserTeamAfterRemoveTeam(int teamID) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "UPDATE user"
				+ "SET teamID = NULL"
				+ "WHERE identity = 2 and teamID = ?";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setInt(1, teamID);
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
    
    public int coachRegister(User user) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO user(userName, password, identity, realName) "
				+ "values(?, ?, 4, ?)";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, user.getUserName());
	        ptmt.setString(2, user.getPassword());
	        ptmt.setString(3, user.getRealName());
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
    
    public User queryUserByUserName(String userName) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "select * from user where userName = ?;";
		User user = new User();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, userName);
	        ResultSet rs= ptmt.executeQuery();
	        while(rs.next()) {
	        	user = new User(rs.getString("userName"), rs.getString("password"), rs.getInt("identity"), rs.getInt("teamID"), rs.getString("realName"), rs.getString("sex"), rs.getInt("age"), rs.getString("phone"));
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
		return user;
    }
    
    public List<User> queryUser() {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "select * from user;";
		List<User> list = new ArrayList<User>();
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ResultSet rs= ptmt.executeQuery();
	        while(rs.next()) {
	        	list.add(new User(rs.getString("userName"), rs.getString("password"), rs.getInt("identity"), rs.getInt("teamID"), rs.getString("realName"), rs.getString("sex"), rs.getInt("age"), rs.getString("phone")));
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
    
    public int removeUser(String userName) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "DELETE FROM user WHERE userName = ?";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, userName);
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
    
    public int login(String userName, String password) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "SELECT count(*), identity FROM user WHERE userName = ? and password = ?";
        int result = 0;
        int identity = -1;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, userName);
	        ptmt.setString(2, password);
	        ResultSet rs = ptmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
				identity = rs.getInt(2);
			}
			if(result > 0) { //1 su 2 普通用户 3 球队 4 教练
				if(identity == 1) {
					return 1;
				}
				else if(identity == 2) {
					return 2;
				}
				else if(identity == 3) {
					return 3;
				}
				else if(identity == 4) {
					return 4;
				}
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
		return 0;
    }
    
    public String getRealNameByUserName(String userName) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "SELECT realName FROM user WHERE userName = ?";
		String realName = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, userName);
	        ResultSet rs= ptmt.executeQuery();
	        rs.first();
	        realName = rs.getString("realName");
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
		return realName;
    }
    
    public int userSum() {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "SELECT count(*) as userSum FROM user";
		int userSum = 0;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ResultSet rs= ptmt.executeQuery();
	        rs.first();
	        userSum = rs.getInt("userSum");
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
		return userSum;
    }
    public int playerSum() {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "SELECT count(*) as userSum FROM user WHERE identity = 2";
		int userSum = 0;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ResultSet rs= ptmt.executeQuery();
	        rs.first();
	        userSum = rs.getInt("userSum");
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
		return userSum;
    }
    public int getTeamIDByUserName(String userName) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "SELECT teamID FROM user where userName = ?";
		int teamID = 0;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, userName);
	        ResultSet rs= ptmt.executeQuery();
	        rs.first();
	        teamID = rs.getInt("teamID");
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
		return teamID;
    }
}
