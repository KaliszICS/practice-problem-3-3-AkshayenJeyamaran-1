import java.util.ArrayList;
import java.util.HashSet;
public class PracticeProblem {
    public static ArrayList<String> perms(String str) {
        ArrayList<String> result = new ArrayList<>();
        permsHelper("", str, result);
        return result;
    }
    private static void permsHelper(String prefix, String remaining, ArrayList<String> result) {
        if (remaining.length() == 0) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            permsHelper(newPrefix, newRemaining, result);
        }
    }
    public static ArrayList<String> permsUnique(String str) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        permsUniqueHelper("", str, set);

        result.addAll(set);
        return result;
    }
    private static void permsUniqueHelper(String prefix, String remaining, HashSet<String> set) {
        if (remaining.length() == 0) {
            set.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            permsUniqueHelper(newPrefix, newRemaining, set);
        }
    }
}