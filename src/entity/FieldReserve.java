package entity;

public class FieldReserve {
	int fieldOrderID;
	String userName;
	String date;
	String fieldName;
	
	public FieldReserve(int fieldOrderID, String userName, String date, String fieldName) {
		super();
		this.fieldOrderID = fieldOrderID;
		this.userName = userName;
		this.date = date;
		this.fieldName = fieldName;
	}
	
	public FieldReserve(String userName, String date, String fieldName) {
		super();
		this.userName = userName;
		this.date = date;
		this.fieldName = fieldName;
	}

	public int getFieldOrderID() {
		return fieldOrderID;
	}
	public void setFieldOrderID(int fieldOrderID) {
		this.fieldOrderID = fieldOrderID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
