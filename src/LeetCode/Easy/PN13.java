package LeetCode.Easy;

import java.util.HashMap;

public class PN13 {
    public static int romanToInt(String s) {
        HashMap<String, Integer> dict = new HashMap<>();

        dict.put("I", 1);
        dict.put("V", 5);
        dict.put("X", 10);
        dict.put("L", 50);
        dict.put("C", 100);
        dict.put("D", 500);
        dict.put("M", 1000);

        int total = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(i == 0){
                int val = dict.get(Character.toString(s.charAt(i)));
                total += val;
                System.out.println(total);
            }
            else{
                int val = dict.get(Character.toString(s.charAt(i)));
                int next = dict.get(Character.toString(s.charAt(i - 1)));
                if(next < val){
                    int change = val - next;
                    total += change;
                    i--;
                    System.out.println(total);
                }
                else{
                    total += val;
                    System.out.println(total);
                }
            }
        }

        return total;
    }

    public static void main(String[] args){
        System.out.println(romanToInt("LVIII"));
    }
}
