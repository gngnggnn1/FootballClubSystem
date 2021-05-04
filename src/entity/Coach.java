package entity;

public class Coach {
	String userName;
	String grade;
	int isFullTime;
	int coachID;
	String coachName;
	
	public Coach(String userName, String grade, int isFullTime, String coachName) {
		super();
		this.userName = userName;
		this.grade = grade;
		this.isFullTime = isFullTime;
		this.coachName = coachName;
	}
	public Coach(String userName, String grade, int isFullTime, int coachID, String coachName) {
		super();
		this.userName = userName;
		this.grade = grade;
		this.isFullTime = isFullTime;
		this.coachID = coachID;
		this.coachName = coachName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getIsFullTime() {
		return isFullTime;
	}
	public void setIsFullTime(int isFullTime) {
		this.isFullTime = isFullTime;
	}
	public int getCoachID() {
		return coachID;
	}
	public void setCoachID(int coachID) {
		this.coachID = coachID;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}	
}
