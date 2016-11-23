package examples.collections;
import java.util.*;

public class StateCaps {
    final static String STATE_CAPS [][] = 
        {{"Alabama", "Montgomery"}, {"Alaska", "Juneau"},
         {"Arizona", "Phoenix"}, {"Virginia", "Richmond"},
         {"Washington", "Olympia"}, {"West Virginia", "Charleston"},
         {"Connecticut", "Hartford"}, {"Delaware", "Dover"},
         {"Florida", "Tallahassee"},{"Illinois", "Springfield"},
         {"Indiana", "Indianapolis"}, {"Iowa", "Des Moines"},
         {"Kansas", "Topeka"}, {"Kentucky", "Frankfort"},
         {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"},
         {"Maryland", "Annapolis"}, {"Massachusetts", "Boston"},
         {"Missouri", "Jefferson City"}, {"Montana", "Helena"},
         {"Nebraska", "Lincoln"}, {"Arkansas", "Little Rock"},
         {"California", "Sacramento"}, {"Colorado", "Denver"},
         {"Nevada", "Carson City"}, {"New Hampshire", "Concord"},
         {"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"},
         {"New York", "Albany"}, {"North Carolina", "Raleigh"},
         {"North Dakota", "Bismarck"}, {"Ohio", "Columbus"},
         {"Oklahoma", "Oklahoma City"}, {"Georgia", "Atlanta"},
         {"Oregon", "Salem"}, {"Pennsylvania", "Harrisburg"},
         {"Rhode Island", "Providence"},{"Michigan", "Lansing"},
         {"Minnesota", "St. Paul"}, {"Mississippi", "Jackson"},
         {"South Carolina", "Columbia"}, {"South Dakota", "Pierre"},
         {"Tennessee", "Nashville"}, {"Texas", "Austin"},
         {"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"},
         {"Wisconsin", "Madison"}, {"Wyoming", "Cheyenne"},
         {"Hawaii", "Honolulu"}, {"Idaho", "Boise"}};
    
    public static void main(String args[]) {
        Map m = new HashMap();
        
        // Populate HashMap from array
        for(String sc[]:STATE_CAPS){
            m.put(sc[0], sc[1]);
        }
        
        // Iterate through keys
        System.out.println("\n----Keys------------");
        Iterator iter = m.keySet().iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        
        // Loop through values
        System.out.println("\n----Values----------");
        for(Object obj:m.values()){
            System.out.println(obj);
        }
        
        // Iterate through entries
        System.out.println("\n----Entries---------");
        iter = m.entrySet().iterator();
        Map.Entry e;
        while (iter.hasNext()){
            e = (Map.Entry)iter.next();
            System.out.print(e.getKey() + ", ");
            System.out.println(e.getValue());
        }
        
        // Return capitals of states supplied as
        // command line arguments
        System.out.println("\n--------------------");
        for (String s:args){
            System.out.print("Capital of " + s);
            System.out.println(" is " + m.get(s));
        }
        
        // Convert to TreeMap where the keys will
        // then be maintained in sorted order.
        System.out.println("\n----Sorted Entries--");
        TreeMap tm = new TreeMap(m);
        iter = tm.entrySet().iterator();
        while (iter.hasNext()){
            e = (Map.Entry)iter.next();
            System.out.print(e.getKey() + ", ");
            System.out.println(e.getValue());
        }
    }
}