package entity;

public class CourseInf {
	int courseInfID;
	int courseID;
	String userName;
	String courseName;
	public CourseInf(int courseInfID, int courseID, String userName, String courseName) {
		super();
		this.courseInfID = courseInfID;
		this.courseID = courseID;
		this.userName = userName;
		this.courseName = courseName;
	}
	public int getCourseInfID() {
		return courseInfID;
	}
	public void setCourseInfID(int courseInfID) {
		this.courseInfID = courseInfID;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
