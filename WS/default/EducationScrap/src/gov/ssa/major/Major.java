package gov.ssa.major;

public class Major {
	private int id;
	private String description;
	private int reqSat;
	
	public Major() { }
	
	public Major(String description, int reqSat) {
		this(-1, description, reqSat);
	}
	
	public Major(int id, String description, int reqSat) {
		setId(id);
		setDescription(description);
		setReqSat(reqSat);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getReqSat() {
		return reqSat;
	}
	public void setReqSat(int reqSat) {
		this.reqSat = reqSat;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(String.format("%-3d   %-20s   %4d", getId(), getDescription(), getReqSat()));
		
		return sb.toString();
	}
}
