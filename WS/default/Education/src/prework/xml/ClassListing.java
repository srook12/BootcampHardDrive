package prework.xml;

public class ClassListing {
	private int class_id;
	private String crn;
	private String sect;
	private int semester = 6;
	private int classroom_id;
	private boolean mon, tues, wed, thurs, fri, sat, onl;
	private int instructor_id;
	private String begin_time;
	private String end_time;
	
	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getSect() {
		return sect;
	}

	public void setSect(String sect) {
		this.sect = sect;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getClassroom_id() {
		return classroom_id;
	}

	public void setClassroom_id(int classroom_id) {
		this.classroom_id = classroom_id;
	}

	public boolean isMon() {
		return mon;
	}

	public void setMon(boolean mon) {
		this.mon = mon;
	}

	public boolean isTues() {
		return tues;
	}

	public void setTues(boolean tues) {
		this.tues = tues;
	}

	public boolean isWed() {
		return wed;
	}

	public void setWed(boolean wed) {
		this.wed = wed;
	}

	public boolean isThurs() {
		return thurs;
	}

	public void setThurs(boolean thurs) {
		this.thurs = thurs;
	}

	public boolean isFri() {
		return fri;
	}

	public void setFri(boolean fri) {
		this.fri = fri;
	}

	public boolean isSat() {
		return sat;
	}

	public void setSat(boolean sat) {
		this.sat = sat;
	}

	public boolean isOnl() {
		return onl;
	}

	public void setOnl(boolean onl) {
		this.onl = onl;
	}

	public int getInstructor_id() {
		return instructor_id;
	}

	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}

	public String getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("insert into class_list(class_id,crn,sect,semester,classroom_id,mon,tues,wed,thurs,fri,sat,onl,instructor_id,begin_time,end_time) ");
		sb.append("values(");
		
		sb.append(getClass_id() + ",");
		sb.append("\"" + getCrn() + "\",");
		sb.append("\"" + getSect() + "\",");
		sb.append(getSemester() + ",");
	
		String classroom = getClassroom_id() == -1 ? "null" : String.valueOf(getClassroom_id());
		sb.append(classroom + ",");
		
		String monday = isMon() ? "true" : "false";
		String tuesday = isTues() ? "true" : "false";
		String wednesday = isWed() ? "true" : "false";
		String thursday = isThurs() ? "true" : "false";
		String friday = isFri() ? "true" : "false";
		String saturday = isSat() ? "true" : "false";
		String online = isOnl() ? "true" : "false";
		
		sb.append(monday + "," + tuesday + "," + wednesday + "," + thursday + "," + friday + "," + saturday + "," + online + ",");

		String instructor = getInstructor_id() == -1 ? "null" : String.valueOf(getInstructor_id());
		sb.append(instructor + ",");

		sb.append("\"" + begin_time + "\",\"" + end_time + "\"");
		
		sb.append(");");
		return sb.toString();
	}
}
