package entity;

public class Match {
	int matchID;
	String matchDate;
	String teamName1;
	String teamName2;
	int hasPlayed;
	String score;
	String matchDescription;
	
	public Match(int matchID, String matchDate, String teamName1, String teamName2, int hasPlayed, String score,
			String matchDescription) {
		super();
		this.matchID = matchID;
		this.matchDate = matchDate;
		this.teamName1 = teamName1;
		this.teamName2 = teamName2;
		this.hasPlayed = hasPlayed;
		this.score = score;
		this.matchDescription = matchDescription;
	}

	public Match(String matchDate, String teamName1, String teamName2) {
		super();
		this.matchDate = matchDate;
		this.teamName1 = teamName1;
		this.teamName2 = teamName2;
	}

	public Match(int matchID, String matchDate, String teamName1, String teamName2) {
		super();
		this.matchID = matchID;
		this.matchDate = matchDate;
		this.teamName1 = teamName1;
		this.teamName2 = teamName2;
	}
	
	public Match(int matchID, String matchDate, String teamName1, String teamName2, String score,
			String matchDescription) {
		super();
		this.matchID = matchID;
		this.matchDate = matchDate;
		this.teamName1 = teamName1;
		this.teamName2 = teamName2;
		this.score = score;
		this.matchDescription = matchDescription;
	}

	public Match(int matchID, String score, String matchDescription) {
		super();
		this.matchID = matchID;
		this.score = score;
		this.matchDescription = matchDescription;
	}

	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getTeamName1() {
		return teamName1;
	}

	public void setTeamName1(String teamName1) {
		this.teamName1 = teamName1;
	}

	public String getTeamName2() {
		return teamName2;
	}

	public void setTeamName2(String teamName2) {
		this.teamName2 = teamName2;
	}

	public int getHasPlayed() {
		return hasPlayed;
	}

	public void setHasPlayed(int hasPlayed) {
		this.hasPlayed = hasPlayed;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getMatchDescription() {
		return matchDescription;
	}

	public void setMatchDescription(String matchDescription) {
		this.matchDescription = matchDescription;
	}
	
	
	
}
