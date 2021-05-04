package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Match;

public class MatchDao {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost:3306/soccersys?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	// 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "gn131313";
    
	public int addMatch(Match match) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO `soccersys`.`match`(`matchDate`, `teamName1`, `teamName2`, `hasPlayed`) VALUES (?, ?, ?, '0')";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, match.getMatchDate());
	        ptmt.setString(2, match.getTeamName1());
	        ptmt.setString(3, match.getTeamName2());
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
	
	public List<Match> queryMatch() {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "select * from soccersys.match WHERE hasPlayed = 0;";
		List<Match> list = new ArrayList<Match>();
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ResultSet rs= ptmt.executeQuery();
	        while(rs.next()) {
	        	list.add(new Match(rs.getInt("matchID"), rs.getString("matchDate"), rs.getString("teamName1"), rs.getString("teamName2")));
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
	
	public List<Match> queryFinishedMatch() {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "select * from soccersys.match WHERE hasPlayed = 1;";
		List<Match> list = new ArrayList<Match>();
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ResultSet rs= ptmt.executeQuery();
	        while(rs.next()) {
	        	list.add(new Match(rs.getInt("matchID"), rs.getString("matchDate"), rs.getString("teamName1"), rs.getString("teamName2"), rs.getString("score"), rs.getString("matchDescription")));                       
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
	
	public int removeMatch(int matchID) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "DELETE FROM soccersys.match WHERE matchID = ?";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setInt(1, matchID);
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
	
	public int updateMatch(Match match) {
    	Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "UPDATE soccersys.match "
				+ "SET hasPlayed = 1, score = ?, matchDescription = ? "
				+ "WHERE matchID = ?";
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, match.getScore());
	        ptmt.setString(2, match.getMatchDescription());
	        ptmt.setInt(3, match.getMatchID());
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
