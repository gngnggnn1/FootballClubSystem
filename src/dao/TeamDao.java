package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Team;

public class TeamDao {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost:3306/soccersys?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	// 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "gn131313";
    
    public int addTeam(Team team) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO team(teamID, teamName, teamGrade, captainName, contact, description) "
				+ "values(NULL, ?, ?, ?, ?, ?)";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, team.getTeamName());
	        ptmt.setInt(2, team.getTeamGrade());
	        ptmt.setString(3, team.getCaptainName());
	        ptmt.setString(4, team.getContact());
	        ptmt.setString(5, team.getDescription());
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
    
    public int getTeamID(){
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "select max(teamID) teamID from team";
		int teamID = -1;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
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
    
    public List<Team> queryTeam() {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "select * from team;";
		List<Team> list = new ArrayList<Team>();
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ResultSet rs= ptmt.executeQuery();
	        while(rs.next()) {
	        	list.add(new Team(rs.getInt("teamID"), rs.getString("teamName"), rs.getInt("teamGrade"), rs.getString("captainName"), rs.getString("contact"), rs.getString("description")));
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
    
    public int removeTeam(int teamID) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "DELETE FROM team WHERE teamID = ?";
		
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
    
    public Team getTeamByID(int teamID){
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "SELECT * FROM team WHERE teamID = ?";
		Team team = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setInt(1, teamID);
	        ResultSet rs= ptmt.executeQuery();
	        rs.first();
	        team = new Team(teamID, rs.getString("teamName"), rs.getInt("teamGrade"), rs.getString("captainName"), rs.getString("contact"), rs.getString("description"));
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
		return team;
    }
    
    public int updateTeam(Team team) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "UPDATE team "
				+ "SET teamName = ?, teamGrade = ?, captainName = ?, contact = ?, description = ?"
				+ "WHERE teamID = ?";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, team.getTeamName());
	        ptmt.setInt(2, team.getTeamGrade());
	        ptmt.setString(3, team.getCaptainName());
	        ptmt.setString(4, team.getContact());
	        ptmt.setString(5, team.getDescription());
	        ptmt.setInt(6, team.getTeamID());
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
    
    public int getTeamIDByUserName(String userName) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "SELECT teamID FROM user WHERE userName = ?";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, userName);
	        ResultSet rs = ptmt.executeQuery();
	        if(rs.next()) {
	        	return rs.getInt(1);
	        }
			return 0;
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
    
    public String getTeamNameByTeamID(int teamID) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "SELECT teamName FROM team WHERE teamID = ?";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setInt(1, teamID);
	        ResultSet rs = ptmt.executeQuery();
	        if(rs.next()) {
	        	return rs.getString(1);
	        }
			return null;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
				return null;
			}
			
		}
    }
    
    public int sendJoinTeamApplication(int teamID, String userName, String userRealName) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO jointeamapplication(userName, teamIDToJoin, passed, userRealName) "
				+ "VALUES(?, ?, 0, ?)";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, userName);
	        ptmt.setInt(2, teamID);
	        ptmt.setString(3, userRealName);
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
    public int teamSum() {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "SELECT count(*) as teamSum FROM team";
		int teamSum = 0;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ResultSet rs= ptmt.executeQuery();
	        rs.first();
	        teamSum = rs.getInt("teamSum");
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
		return teamSum;
    }
}
