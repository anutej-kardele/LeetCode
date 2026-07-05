package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PN49 {

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagramsNew(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> output = new ArrayList<>();

        List<String> temp = new ArrayList<>();
        temp.add(strs[0]);
        output.add(temp);

        if (strs.length == 1)
            return output;

        for (int i = 1; i < strs.length; i++) {

            String tofind = sortString(strs[i]);

            boolean found = false;

            for (int j = 0; j < output.size(); j++) {

                System.err.println("Comparing " + sortString(output.get(j).get(0)) + " with " + tofind);

                if (sortString(output.get(j).get(0)).equals(tofind)) {
                    output.get(j).add(strs[i]);
                    found = true;
                    break;
                }
            }

            if (!found) {

                System.err.println("Not found " + tofind + " in output, adding new list");
                temp = new ArrayList<>();
                temp.add(strs[i]);
                output.add(temp);
            }
        }

        return output;
    }

    public static String sortString(String str) {

        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public static List<List<String>> groupAnagramsNew(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        List<String> temp = new ArrayList<>();
        temp.add(strs[0]);
        map.put(sortString(strs[0]), temp);

        for (int i = 1; i < strs.length; i++) {

            String tofind = sortString(strs[i]);

            if (map.containsKey(tofind)) {
                map.get(tofind).add(strs[i]);
            } else {
                temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(tofind, temp);
            }
        }

        // List<List<String>> output = new ArrayList<>();
        // for (String key : map.keySet()) {
        // output.add(map.get(key));
        // }

        // return output;
        return new ArrayList<>(map.values());
    }

}
