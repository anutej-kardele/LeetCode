package LeetCode.Easy;

import java.util.Stack;

public class PN20 {

    public static void main(String[] args) {
        // String str = "()";
        // String str = "()[]{}";
        // String str = "(]";
        String str = "([])";
        // String str = "([)]";

        System.out.println("Is " + str + " valid parentheses: " + isValid1(str));
        // System.out.println("Is " + str + " valid parentheses: " + isValid(str));
    }

    public static boolean isValid1(String s) {

        Stack<Character> data = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                data.push(ch);
            else {
                if (data.isEmpty())
                    return false;
                Character elem = data.peek();

                if ((ch == ')' && elem != '(') ||
                        (ch == '}' && elem != '{') ||
                        (ch == ']' && elem != '[')) {
                    return false;
                }

                data.pop();
            }
        }

        return data.isEmpty();
    }

    public static boolean isValid(String s) {

        if (s.length() == 1)
            return false;

        Stack<Character> data = new Stack<Character>();
        data.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (!data.isEmpty() && isPair(data.peek(), s.charAt(i))) {
                data.pop();
            } else
                data.push(s.charAt(i));
        }

        System.out.println(data);
        return data.isEmpty();
    }

    public static boolean isPair(Character A, Character B) {
        if (A == '(' && B == ')')
            return true;
        else if (A == '{' && B == '}')
            return true;
        else if (A == '[' && B == ']')
            return true;
        return false;
    }

}
