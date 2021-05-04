package entity;

public class JoinTeamApplication {
	int applyID;
	String userName;
	int teamIDToJoin;
	int passed;
	String userRealName;
	
	public JoinTeamApplication(int applyID, String userName, int teamIDToJoin, int passed, String userRealName) {
		super();
		this.applyID = applyID;
		this.userName = userName;
		this.teamIDToJoin = teamIDToJoin;
		this.passed = passed;
		this.userRealName = userRealName;
	}
	public int getApplyID() {
		return applyID;
	}
	public void setApplyID(int applyID) {
		this.applyID = applyID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTeamIDToJoin() {
		return teamIDToJoin;
	}
	public void setTeamIDToJoin(int teamIDToJoin) {
		this.teamIDToJoin = teamIDToJoin;
	}
	public int getPassed() {
		return passed;
	}
	public void setPassed(int passed) {
		this.passed = passed;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

}
