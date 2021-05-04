package entity;

public class Team {
	int teamID;
	String teamName;
	int teamGrade;
	String captainName;
	String contact;
	String description;
	
	public Team(String teamName, int teamGrade, String captainName, String contact, String description) {
		super();
		this.teamName = teamName;
		this.teamGrade = teamGrade;
		this.captainName = captainName;
		this.contact = contact;
		this.description = description;
	}
	
	public Team(int teamID, String teamName, int teamGrade, String captainName, String contact, String description) {
		super();
		this.teamID = teamID;
		this.teamName = teamName;
		this.teamGrade = teamGrade;
		this.captainName = captainName;
		this.contact = contact;
		this.description = description;
	}
	
	public int getTeamID() {
		return teamID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getTeamGrade() {
		return teamGrade;
	}
	public void setTeamGrade(int teamGrade) {
		this.teamGrade = teamGrade;
	}
	public String getCaptainName() {
		return captainName;
	}
	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
