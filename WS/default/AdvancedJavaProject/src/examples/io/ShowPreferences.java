package examples.io;
import java.util.prefs.Preferences;
public class ShowPreferences {
    public static void main(String[] args){
        String nodeName = "/examples/io";
        Preferences userPrefs =
            Preferences.userRoot().node(nodeName);
        String color = userPrefs.get("color", "red");
        System.out.println(color);

        Preferences sysPrefs =
            Preferences.systemRoot().node(nodeName);
        int port = sysPrefs.getInt("portNumber", 80);
        System.out.println(port);
    }
}