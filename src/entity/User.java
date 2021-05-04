package entity;

public class User {
	String userName;
	String password;
	int identity;
	int teamID;
	String realName;
	String sex;
	int age;
	String phone;
	
	public User() {
		super();
	}

	public User(String userName, String password, String realName) {
		super();
		this.userName = userName;
		this.password = password;
		this.realName = realName;
	}

	public User(String userName, String password, int identity, int teamID, String realName, String sex, int age,
			String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.identity = identity;
		this.teamID = teamID;
		this.realName = realName;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
	}
	
	public User(String userName, String password, int teamID) {
		super();
		this.teamID = teamID;
		this.userName = userName;
		this.password = password;
	}

	public User(String userName, String password, int identity, String realName, String sex, int age, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.identity = identity;
		this.realName = realName;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
