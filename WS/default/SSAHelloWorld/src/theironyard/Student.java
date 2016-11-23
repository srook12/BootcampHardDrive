package theironyard;

public class Student {
	private String name;
	private boolean isPassing;
	private MajorType collegeMajor;
	private int daysMissed;
	private int studentId;
	
	public enum MajorType{COSC ("Computer Science"),
		                  MATH ("Mathematics"),
		                  CHEM ("Chemistry"),
		                  ENG ("English"),
		                  UND ("Undefined"); 
		
		String majorType;
		
		MajorType(String major) {majorType = major;}
		
		public String getMajorType() {return majorType;}
	};
	
	public Student(int studentId) {
		this.studentId = studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public boolean isPassing() {
		return isPassing;
	}

	public void setPassing(boolean isPassing) {
		this.isPassing = isPassing;
	}

	public String getCollegeMajor() {
		return collegeMajor.getMajorType();
	}

	public void setCollegeMajor(String collegeMajor) {	
		MajorType mType;
		
		switch(collegeMajor) {
			case "Computer Science":
				mType = MajorType.COSC;
				break;
			case "Mathematics":
				mType = MajorType.MATH;
				break;
			case "Chemistry":
				mType = MajorType.CHEM;
				break;
			case "English":
				mType = MajorType.ENG;
				break;
			default:
				mType = MajorType.UND;
		}
		
		this.collegeMajor = mType;
	}

	public int getDaysMissed() {
		return daysMissed;
	}

	public void setDaysMissed(int daysMissed) {
		if(daysMissed >= 0) {
			this.daysMissed = daysMissed;
		}
		else {
			System.out.println("Trying to set daysMissed to a negative value!");
		}
	}
	
	
}
