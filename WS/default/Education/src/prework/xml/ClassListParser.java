package prework.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClassListParser {

	static Document doc = null;
	
	public static void main(String[] args) {
		openDocument();

		getClasses();
	}

	public static void openDocument() {
		try {
			doc = Jsoup.parse(new File("class_list/soc.html"), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getClasses() {		
		Elements classListings = doc.getElementsByAttributeValue("class", "crsedtls");
		
		for(int idx = 0; idx < classListings.size(); idx++) {
			String classTitle = doc.select("td[class=CourseName]").get(idx).html().split(":")[0];			
			getSections(classListings.get(idx), classTitle);
		}
	}
	
	public static void getSections(Element classes, String classTitle) {	
			List<Element> hybridRowTwos = new ArrayList<Element>();
		
			for(Element row : classes.select("tr[class=dtls1]")) {
				System.out.print(classTitle + ";");
				parseOpen(row);
			}
			
			for(Element row : classes.select("tr[class=dtlsFull]")) {
				System.out.print(classTitle + ";");
				parseClosed(row);
			}
			
			for(Element row : classes.select("tr[class=dtls12]")) {
				System.out.print(classTitle + ";");
				parseSpecial(row);
			}
			
			for(Element row : classes.select("tr[class=dtls123")) {
				hybridRowTwos.add(row);
			}
			
			for(Element row : classes.select("tr[class=dtls122]")) {
				System.out.print(classTitle + ";");			
				parseHybrid(row, hybridRowTwos.remove(0));
			}
	}
	
	public static void parseHybrid(Element row1, Element row2) {
		Elements tds_row1 = row1.select("td");
		Elements tds_row2 = row2.select("td");
		
		String crn = null;
		String sec = null;
		String time = null;
		String days = null;
		String loc = null;
		String instr = null;
		
		for(int idx = 0; idx < tds_row1.size(); idx++) {
			if(idx == 1) {
				crn = tds_row1.get(1).children().get(0).html();
			} else if(idx == 2) {
				sec = tds_row1.get(2).html();
			} else if(idx == 8) {				
				instr = tds_row1.get(8).html().split("<br>")[0];
				
				if(instr.equals("")) { instr = "null"; }
			} 
		}
		
		for(int idx = 0; idx < tds_row2.size(); idx++) {
			if(idx == 1) {
				time = tds_row2.get(1).html();
			} else if(idx == 2) {
				days = tds_row2.get(2).html();
			} else if(idx == 3) {
				String[] room = tds_row2.get(3).html().split("&nbsp;");
				loc = room[0] + " " + room[room.length - 1];
				
				System.out.println(crn + ";" + sec + ";" + time + ";" + days + ";" + loc + ";" + instr);
			}
		}
	}
	
	public static void parseOnline(Element row) {
		Elements tds = row.select("td");
		
		String crn = null;
		String sec = null;
		String instr = null;
		
		for(int idx = 0; idx < tds.size(); idx++) {
			if(idx == 1) {
				crn = tds.get(1).children().get(0).html();
			} else if(idx == 2) {
				sec = tds.get(2).html();
			} else if(idx == 6) {
				instr = tds.get(6).html().split("<br>")[0];
				
				if(instr.equals("")) { instr = "null"; }
				
				System.out.println(crn + ";" + sec + ";" + "null" + ";" + "null" + ";" + "null" + ";" + instr);
			}
			
		}
	}
	
	public static void parseSpecial(Element row) {
		Elements tds = row.select("td");
		
		if(tds.size() == 7) {
			parseOnline(row);
		} else if(tds.size() == 9) {
			parseLabs(row);
		}
	}
	
	public static void parseLabs(Element row) {
		Elements tds = row.select("td");
		
		String crn = null;
		String sec = null;
		String time = null;
		String days = null;
		String loc = null;
		String instr = null;
		
		for(int idx = 0; idx < tds.size(); idx++) {
			if(idx == 1) {
				crn = tds.get(1).children().get(0).html();
			} else if(idx == 2) {
				sec = tds.get(2).html();
			} else if(idx == 5) {
				time = tds.get(5).html();
			} else if(idx == 6) {
				days = tds.get(6).html();
			} else if(idx == 7) {
				String[] room = tds.get(7).html().split("&nbsp;");
				loc = room[0] + " " + room[room.length - 1];
			} else if(idx == 8) {
				instr = tds.get(8).html().split("<br>")[0];
				
				if(instr.equals("")) { instr = "null"; }
				
				System.out.println(crn + ";" + sec + ";" + time + ";" + days + ";" + loc + ";" + instr);
			}
		}
	}
	
	public static void parseOpen(Element row) {
		Elements tds = row.select("td");
		
		String crn = null;
		String sec = null;
		String time = null;
		String days = null;
		String loc = null;
		String instr = null;
		
		for(int idx = 0; idx < tds.size(); idx++) {
			if(idx == 1) {
				crn = tds.get(1).children().get(0).html();
			} else if(idx == 2) {
				sec = tds.get(2).html();
			} else if(idx == 5) {
				time = tds.get(5).html();
			} else if(idx == 6) {
				days = tds.get(6).html();
			} else if(idx == 7) {
				String[] room = tds.get(7).html().split("&nbsp;");
				loc = room[0] + " " + room[room.length - 1];
			} else if(idx == 8) {
				instr = tds.get(8).html().split("<br>")[0];
				
				if(instr.equals("")) { instr = "null"; }
				
				System.out.println(crn + ";" + sec + ";" + time + ";" + days + ";" + loc + ";" + instr);
			}
		}
	}
	
	public static void parseClosed(Element row) {
		Elements tds = row.select("td");
		
		String crn = null;
		String sec = null;
		String time = null;
		String days = null;
		String loc = null;
		String instr = null;
		
		for(int idx = 0; idx < tds.size(); idx++) {
			if(idx == 1) {
				crn = tds.get(idx).select("font").get(0).html();
			} else if(idx == 2) {
				sec = tds.get(idx).html();
			} else if(idx == 5) {
				time = tds.get(idx).html();
			} else if(idx == 6) {
				days = tds.get(6).html();
			} else if(idx == 7) {
				String[] room = tds.get(7).html().split("&nbsp;");
				loc = room[0] + " " + room[room.length - 1];
			} else if(idx == 8) {
				instr = tds.get(8).html().split("<br>")[0];
				
				if(instr.equals("")) { instr = "null"; }
				
				System.out.println(crn + ";" + sec + ";" + time + ";" + days + ";" + loc + ";" + instr);
			}
		}
	}
}
