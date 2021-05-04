package entity;


public class Field {
	int fieldID;
	String fieldName;
	String location;
	String description;
	int size;
	int price;
	int hasLight;
	int inDoor;
	int realGrass;
	int hasShop;
	
	
	public Field() {
		super();
	}
	
	public Field(String fieldName, String location, String description, int size, int price, int hasLight, int inDoor,
			int realGrass, int hasShop) {
		super();
		this.fieldName = fieldName;
		this.location = location;
		this.description = description;
		this.size = size;
		this.price = price;
		this.hasLight = hasLight;
		this.inDoor = inDoor;
		this.realGrass = realGrass;
		this.hasShop = hasShop;
	}
	
	public Field(int fieldID, String fieldName, String location, String description, int size, int price, int hasLight,
			int inDoor, int realGrass, int hasShop) {
		super();
		this.fieldID = fieldID;
		this.fieldName = fieldName;
		this.location = location;
		this.description = description;
		this.size = size;
		this.price = price;
		this.hasLight = hasLight;
		this.inDoor = inDoor;
		this.realGrass = realGrass;
		this.hasShop = hasShop;
	}
	
	
	
	public Field(int fieldID, String description, int size, int price, int hasLight, int inDoor, int realGrass,
			int hasShop) {
		super();
		this.fieldID = fieldID;
		this.description = description;
		this.size = size;
		this.price = price;
		this.hasLight = hasLight;
		this.inDoor = inDoor;
		this.realGrass = realGrass;
		this.hasShop = hasShop;
	}

	public int getFieldID() {
		return fieldID;
	}

	public String getFieldName() {
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getHasLight() {
		return hasLight;
	}
	
	public void setHasLight(int hasLight) {
		this.hasLight = hasLight;
	}
	
	public int getInDoor() {
		return inDoor;
	}
	
	public void setInDoor(int inDoor) {
		this.inDoor = inDoor;
	}
	
	public int getRealGrass() {
		return realGrass;
	}
	
	public void setRealGrass(int realGrass) {
		this.realGrass = realGrass;
	}
	
	public int getHasShop() {
		return hasShop;
	}
	
	public void setHasShop(int hasShop) {
		this.hasShop = hasShop;
	}
	
}
