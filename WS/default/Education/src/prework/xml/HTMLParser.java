package prework.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HTMLParser {

	static Document doc = null;
	
	static List<Department> departmentList = new ArrayList<Department>();
	static List<Class> classList = new ArrayList<Class>();

	static List<String> exceptions = new ArrayList<String>();
	
	static PrintWriter pw;
	
	public static void main(String[] args) throws FileNotFoundException {
		openDocument();

		
		pw = new PrintWriter("output.txt");
		
		exceptions.add("AHS");
		exceptions.add("ASL");
		exceptions.add("ANTH");
		exceptions.add("ART");
		exceptions.add("APL");
		exceptions.add("ASTR");
		exceptions.add("CADD");
		exceptions.add("DRAM");
		exceptions.add("ES");
		exceptions.add("ELEC");
		exceptions.add("ENGT");
		exceptions.add("ENV");
		exceptions.add("FIN");
		exceptions.add("FS");
		exceptions.add("FR");
		exceptions.add("GEOG");
		exceptions.add("GER");
		exceptions.add("HLTH");
		exceptions.add("HD");
		exceptions.add("IDS");
		exceptions.add("MC");
		exceptions.add("MAS");
		exceptions.add("MUS");
		exceptions.add("NURS");
		exceptions.add("OS");
		exceptions.add("ORIE");
		exceptions.add("PL");
		exceptions.add("PHOT");
		exceptions.add("SCI");
		exceptions.add("PN");
		exceptions.add("RELG");
		exceptions.add("SPAN");
		exceptions.add("SDEV");
		exceptions.add("THEA");
		exceptions.add("VPA");
		
		
		
		
		extractDepartmentHeadings();
		
		
		extractClasses();
		
		for(Class c : classList) {
			pw.println(c);
			System.out.println(c.printClass());
		}
		
		pw.flush();
		
		pw.close();
		
	}

	public static void openDocument() {
		try {
			doc = Jsoup.parse(new File("class_info.html"), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void extractDepartmentHeadings() {
		Elements depts = doc.select("div.divProgHead");
		
		for(Element dept : depts) {
			String listing = dept.childNode(1).toString();
			String[] listingInfo = listing.split(" - ");
			if(!exceptions.contains(listingInfo[0])) {
				Department department = new Department();
				department.setCode(listingInfo[0]);
				department.setName(listingInfo[1]);			
				departmentList.add(department);
				System.out.println(department);
			}
		}
	}
	
	public static void extractClasses() {
		Elements classes = doc.select("div.divCourse");
		
		for(Element _class : classes) {
			Elements classElements = _class.getElementsByClass("divDesc-Head");
			
			Element classIdP = classElements.get(0);
			Elements classIdL = classIdP.select("a");
			String classId = classIdL.first().text();
			
			String classIdParts[] = classId.split(" ");
			
			Element classNameP = classElements.get(1);
			Elements classNameL = classNameP.select("a");
			String className = classNameL.first().text();
			
			Element classCreditsP = classElements.get(2);
			String classCredits = classCreditsP.text().substring(1, 2);
			
			Elements descP = _class.getElementsByClass("divDesc-Row");
			String description = descP.get(1).text();
						
			for(Department department : departmentList) {
				if(department.getCode().equalsIgnoreCase(classIdParts[0])) {
					Class aClass = new Class();
					aClass.setCode(classIdParts[0]);
					aClass.setNumber(classIdParts[1]);
					aClass.setName(className);
					aClass.setNumCredits(Integer.parseInt(classCredits));
					aClass.setDescription(description);
					
					aClass.setDepartmentName(department.getCode());
					aClass.setDepartmentId(department.getId());
					classList.add(aClass);
					break;
				}
			}
		}
	}
}
