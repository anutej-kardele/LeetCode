package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;

public class PN981 {

    public static void main(String[] args) {

        List<String> Input = Arrays.asList("TimeMap", "set", "get", "get", "set", "get", "get");
        List<List<Object>> InputValues = Arrays.asList(
                Arrays.asList(),
                Arrays.asList("foo", "bar", 1),
                Arrays.asList("foo", 1),
                Arrays.asList("foo", 3),
                Arrays.asList("foo", "bar2", 4),
                Arrays.asList("foo", 4),
                Arrays.asList("foo", 5));
        List<String> ExpectedOutput = Arrays.asList(null, null, "bar", "bar", null, "bar2", "bar2");
        List<String> Output = new ArrayList<>();

        TimeMap timeMap = new TimeMap();
        Output.add(null);
        Output.add(timeMap.set("foo", "bar", 1)); // for the "set" operation
        Output.add(timeMap.get("foo", 1)); // Output: "bar"
        Output.add(timeMap.get("foo", 3)); // Output: "bar"
        Output.add(timeMap.set("foo", "bar2", 4)); // for the "set" operation
        Output.add(timeMap.get("foo", 4)); // Output: "bar2"
        Output.add(timeMap.get("foo", 5)); // Output: "bar2"

        // Check the expected output against the actual output
        if (Output.equals(ExpectedOutput)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
            System.out.println("Expected: " + ExpectedOutput);
            System.out.println("Actual: " + Output);
        }
    }
}

class TimeMap {
    Map<String, ArrayList<TimeValuePair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    // public void set(String key, String value, int timestamp) {
    public String set(String key, String value, int timestamp) {

        if (!map.containsKey(key))
            map.put(key, new ArrayList<>());

        map.get(key).add(new TimeValuePair(timestamp, value));

        return null; // Just for testing purposes - Actual function has void declaration so no return
                     // value is expected
    }

    public String get(String key, int timestamp) {

        ArrayList<TimeValuePair> find = map.get(key);

        if (find == null)
            return "";

        int l = 0, r = find.size() - 1;
        int selectedIndex = -1;

        while (l <= r) {

            int mid = (l + r) / 2;

            if (find.get(mid).timeStamp <= timestamp) {
                selectedIndex = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }

        if (selectedIndex != -1)
            return find.get(selectedIndex).value;

        return "";
    }
}

class TimeValuePair {

    int timeStamp;
    String value;

    public TimeValuePair(int time, String val) {
        this.timeStamp = time;
        this.value = val;
    }
}
