package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PN17 {

    public static void main(String[] args) {
        PN17 pn17 = new PN17();
        System.out.println(pn17.letterCombinations("23"));
        System.out.println(pn17.solution.size());
    }

    List<String> solution = new ArrayList<>();
    HashMap<Character, char[]> keypad = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        keypad.put('2', new char[] { 'a', 'b', 'c' });
        keypad.put('3', new char[] { 'd', 'e', 'f' });
        keypad.put('4', new char[] { 'g', 'h', 'i' });
        keypad.put('5', new char[] { 'j', 'k', 'l' });
        keypad.put('6', new char[] { 'm', 'n', 'o' });
        keypad.put('7', new char[] { 'p', 'q', 'r', 's' });
        keypad.put('8', new char[] { 't', 'u', 'v' });
        keypad.put('9', new char[] { 'w', 'x', 'y', 'z' });

        char[] digit = digits.toCharArray();

        backtrack(new StringBuilder(), digit, 0);

        return solution;
    }

    public void backtrack(StringBuilder sb, char[] digits, int index) {

        if (index >= digits.length) {
            solution.add(new String(sb));
            return;
        }

        for (char ch : keypad.get(digits[index])) {
            sb.append(ch);
            backtrack(sb, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
