package prework.xml;

public class Department {
	private int id;
	private String code;
	private String name;
	
	private static int nextId = 1;
	
	public Department() {
		setId(nextId);
		nextId++;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into department (code, name) values ('" + getCode() + "', '" + getName() + "');");
		return sb.toString();
	}
}
