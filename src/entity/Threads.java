package entity;

import java.sql.Timestamp;

public class Threads {
	int threadID;
	String topic;
	String userName;
	Timestamp time;
	String detail;
	int threadGrade;
	
	public Threads(int threadID, String topic, String userName, Timestamp time, String detail, 
			int threadGrade) {
		super();
		this.threadID = threadID;
		this.topic = topic;
		this.userName = userName;
		this.time = time;
		this.detail = detail;
		this.threadGrade = threadGrade;
	}

	public Threads(String topic, String userName, Timestamp time, String detail) {
		super();
		this.topic = topic;
		this.userName = userName;
		this.time = time;
		this.detail = detail;
	}

	public Threads(int threadID, String topic, String userName, Timestamp time, String detail) {
		super();
		this.threadID = threadID;
		this.topic = topic;
		this.userName = userName;
		this.time = time;
		this.detail = detail;
	}
	
	public Threads(String topic, String userName, Timestamp time, String detail, int threadGrade) {
		super();
		this.topic = topic;
		this.userName = userName;
		this.time = time;
		this.detail = detail;
		this.threadGrade = threadGrade;
	}

	public int getThreadID() {
		return threadID;
	}

	public void setThreadID(int threadID) {
		this.threadID = threadID;
	}

	public int getThreadGrade() {
		return threadGrade;
	}

	public void setThreadGrade(int threadGrade) {
		this.threadGrade = threadGrade;
	}

	public int getTopicID() {
		return threadID;
	}
	public void setTopicID(int threadID) {
		this.threadID = threadID;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
