package LeetCode.Easy;

import java.lang.reflect.Array;
import java.util.*;

public class PN242 {

    public static void main(String[] args) {

        // String s = "anagram";
        // String t = "nagaram";

        String s = "rat";
        String t = "car";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] freq = new int[26];

        for (char ch : s.toCharArray())
            freq[ch - 'a']++;
        for (char ch : t.toCharArray())
            freq[ch - 'a']--;

        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }

    // public static boolean isAnagram(String s, String t) {

    // char[] chars_S = s.toCharArray();
    // char[] chars_T = t.toCharArray();

    // Arrays.sort(chars_S);
    // Arrays.sort(chars_T);

    // String str_S = new String(chars_S);
    // String str_T = new String(chars_T);

    // System.out.println(str_S);
    // System.out.println(str_T);

    // return str_S.equals(str_T);
    // }

    // // Will fail at "aa" & "bb"
    // public static boolean isAnagram(String s, String t) {

    // if (s.length() != t.length())
    // return false;

    // HashMap<Character, Integer> dict_s = new HashMap<>();
    // HashMap<Character, Integer> dict_t = new HashMap<>();

    // for (int i = 0; i < s.length(); i++) {

    // if (dict_s.containsKey(s.charAt(i))) {
    // int currentValue = dict_s.get(s.charAt(i)) + 1;
    // dict_s.replace(s.charAt(i), currentValue);
    // } else
    // dict_s.put(s.charAt(i), 1);

    // if (dict_t.containsKey(t.charAt(i))) {
    // int currentValue = dict_t.get(t.charAt(i)) + 1;
    // dict_t.replace(t.charAt(i), currentValue);
    // } else
    // dict_t.put(t.charAt(i), 1);
    // }

    // if (dict_s.size() != dict_t.size())
    // return false;

    // for (Map.Entry<Character, Integer> entry : dict_s.entrySet()) {
    // Character key = entry.getKey();
    // Integer value = entry.getValue();

    // Integer value2 = dict_t.get(key);

    // if (value != value2)
    // return false;
    // }
    // return true;
    // }
}
