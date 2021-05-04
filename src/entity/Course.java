package entity;

public class Course {
	int courseID;
	String courseName;
	String courseGrade;
	String coachName;
	String coachUserName;
	String time;
	String description;
	
	public Course(int courseID, String courseName, String courseGrade, String coachName, String coachUserName,
			String time, String description) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseGrade = courseGrade;
		this.coachName = coachName;
		this.coachUserName = coachUserName;
		this.time = time;
		this.description = description;
	}

	public Course(String courseName, String courseGrade, String coachName, String coachUserName, String time, String description) {
		super();
		this.courseName = courseName;
		this.courseGrade = courseGrade;
		this.coachName = coachName;
		this.coachUserName = coachUserName;
		this.time = time;
		this.description = description;
	}

	public String getCoachUserName() {
		return coachUserName;
	}
	public void setCoachUserName(String coachUserName) {
		this.coachUserName = coachUserName;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
