package examples.io;
import java.util.prefs.Preferences;
public class StorePreferences {
    public static void main(String[] args){
        Class c = StorePreferences.class;
        Preferences userPrefs =
            Preferences.userNodeForPackage(c);
        userPrefs.put("color", "blue");
        Preferences sysPrefs =
            Preferences.systemNodeForPackage(c);
        sysPrefs.putInt("portNumber", 8080);
    }
}