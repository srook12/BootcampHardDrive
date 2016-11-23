package prework.xml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class ParseClassList {
	static Map<String,Integer> classes = new TreeMap<String,Integer>();
	static Map<String,Integer> classrooms = new TreeMap<String,Integer>();
	static Map<String,Integer> instructors = new TreeMap<String,Integer>();
	
	static int classroom_id_generator = 1;
	static int instructor_id_generator = 1;
	
	static BufferedReader br;
	
	static PrintWriter pw;
	
	public static void main(String[] args) throws Exception {
		pw = new PrintWriter("class_list_output.txt");
		
		// load classes
		loadClasses();
		
		// parse class list
		parseClassList();
		
		pw.flush();
		pw.close();
	}
	
	public static void parseClassList() throws Exception {
		setReader("class_list/all_classes");
		
		String class_listing;
		while((class_listing = br.readLine()) != null) {
			ClassListing cl = new ClassListing();
			
			String class_listing_parts[] = class_listing.split(";");
			
			// Get class_id
			cl.setClass_id(classes.get(class_listing_parts[0]));
			
			// Get crn
			cl.setCrn(class_listing_parts[1]);
			
			// Get sect
			cl.setSect(class_listing_parts[2]);
			
			// Semester will always be 6 for Spring 2017
			
			// Get beginning and ending times
			String times = class_listing_parts[3];
			
			if(times.equals("null")) {
				cl.setBegin_time("null");
				cl.setEnd_time("null");
			} else {
				getBeginEndTimes(cl, class_listing_parts[3]);
			}
			
			// Get days class is held
			String days = class_listing_parts[4];
			if(days.equals("null")) {
				cl.setOnl(true);
			} else {
				getDays(cl, days);
			}
			
			// Get classroom
			String classroom = class_listing_parts[5];
			if(classroom.equals("null")) {
				cl.setClassroom_id(-1);
			} else {
				cl.setClassroom_id(getClassroom(classroom));
			}
			
			// Get instructor
			String instructor = class_listing_parts[6];
			if(instructor.equals("null")) {
				cl.setInstructor_id(-1);
			} else {
				cl.setInstructor_id(getInstructor(instructor));
			}
			
			pw.println(cl);
		}
	}
	
	public static int getInstructor(String instructor) {
		Integer instructor_id = instructors.get(instructor);
			
		if(instructor_id == null) {
			instructor_id = instructor_id_generator;
			instructor_id_generator++;
			instructors.put(instructor, instructor_id);
		}
		
		return instructor_id.intValue();
	}
	
	public static int getClassroom(String classroom) {
		Integer classroom_id = classrooms.get(classroom);
			
		if(classroom_id == null) {
			classroom_id = classroom_id_generator;
			classroom_id_generator++;
			classrooms.put(classroom, classroom_id);
		}
		
		return classroom_id.intValue();
	}
	
	public static void getDays(ClassListing cl, String days) {
		String listOfDays[] = days.split(",");
		
		for(String day : listOfDays) {
			day = day.trim();
			
			if(day.equals("M") || day.equals("Mon.")) {
				cl.setMon(true);
			} else if(day.equals("Tues.")) {
				cl.setTues(true);
			} else if(day.equals("W") || day.equals("Wed.")) {
				cl.setWed(true);
			} else if(day.equals("Thur.")) {
				cl.setThurs(true);
			} else if(day.equals("F") || day.equals("Fri.")) {
				cl.setFri(true);
			} else if(day.equals("Sat.")) {
				cl.setSat(true);
			}
		}
	}
	
	public static void getBeginEndTimes(ClassListing cl, String times) {
		String timeRanges[] = times.split("-");
		timeRanges[0] = timeRanges[0].trim();
		timeRanges[1] = timeRanges[1].trim();
		
		String beginTimeString[] = timeRanges[0].split(" ");
		String endTimeString[] = timeRanges[1].split(" ");
		
		boolean beginHasAMPM = beginTimeString.length > 1 ? true : false;
		// Case 1: only ending time has am/pm and it is am
		if(!beginHasAMPM && endTimeString[1].equals("AM")) {
			cl.setBegin_time(returnAsTwentyFourHour(beginTimeString[0], false));
			cl.setEnd_time(returnAsTwentyFourHour(endTimeString[0], false));
		}
		// Case 2: only ending time has am/pm and it is pm
		else if(!beginHasAMPM && endTimeString[1].equals("PM")) {
			cl.setBegin_time(returnAsTwentyFourHour(beginTimeString[0], true));
			cl.setEnd_time(returnAsTwentyFourHour(endTimeString[0], true));
		}
		// Case 3: both beginning and ending time have am/pm
		else {
			cl.setBegin_time(returnAsTwentyFourHour(beginTimeString[0], false));
			cl.setEnd_time(returnAsTwentyFourHour(endTimeString[0], true));
		}
	}
	
	public static String returnAsTwentyFourHour(String time, boolean isPM) {
		String timeParts[] = time.split(":");
		int hour = Integer.parseInt(timeParts[0]);
		
		if(!isPM && hour == 12) {
			time = "0:" + timeParts[1];
		} else if(isPM && hour != 12) {
			time = (hour+12) + ":" + timeParts[1];
		}	
			
		return time;
	}
	
	public static void loadClasses() throws Exception {
		setReader("class_list.txt");
		String _class;
		while((_class = br.readLine()) != null) {
			String[] class_parts = _class.split("=");
			classes.put(class_parts[0], Integer.parseInt(class_parts[1]));
		}
	}
	
	public static void setReader(String fileName) throws Exception {
		br = new BufferedReader(new FileReader(fileName));
	}

}
