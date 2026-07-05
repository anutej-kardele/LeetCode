package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class PN271 {

    public static void main(String[] args) {

        List<String> strs = new ArrayList<>();
        strs.add("lint");
        strs.add("code");
        strs.add("love");
        strs.add("you");

        String encodedString = encode(strs);
        System.out.println(encodedString);

        List<String> decodedList = decode(encodedString);
        System.out.println(decodedList.toString());
    }

    public static String encode(List<String> strs) {

        StringBuilder encodedString = new StringBuilder();

        for (int i = 0; i < strs.size(); i++) {

            int length = strs.get(i).length();
            encodedString.append(length).append("#").append(strs.get(i));
        }

        return encodedString.toString();
    }

    public static List<String> decode(String str) {

        int len = str.length();
        int index = 0;
        int lastUsedValue = 0;

        List<String> output = new ArrayList<>();

        while (index < len) {

            if (str.charAt(index) == '#') {
                String lengthStr = str.substring(lastUsedValue, index);

                int lenStr = Integer.parseInt(lengthStr);

                int startWordIndex = index + 1;
                int endWordIndex = startWordIndex + lenStr;

                output.add(str.substring(startWordIndex, endWordIndex));

                lastUsedValue = endWordIndex;
                index = endWordIndex;
            } else {
                index++;
            }
        }

        return output;
    }

}
