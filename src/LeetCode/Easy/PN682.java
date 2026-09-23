package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class PN682 {

    public static void main(String[] args) {

        String[] ops = { "5", "2", "C", "D", "+" };
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] operations) {

        int total = 0;
        int[] scores = new int[operations.length];
        int index = 0;

        for (String str : operations) {

            if (str.equals("+")) {
                int val = scores[index - 1] + scores[index - 2];
                scores[index++] = val;
                total += val;
            } else if (str.equals("D")) {
                int val = scores[index - 1];
                val *= 2;
                scores[index++] = val;
                total += val;
            } else if (str.equals("C")) {
                int val = scores[index - 1];
                index--;
                total -= val;
            } else {
                int val = Integer.parseInt(str);
                scores[index++] = val;
                total += val;
            }
        }

        return total;
    }

    public static int calPointsOld(String[] operations) {

        int total = 0;
        List<Integer> list = new ArrayList<Integer>();

        for (String str : operations) {

            try {
                int val = Integer.parseInt(str);
                list.add(val);
                total += val;
            } catch (NumberFormatException e) {

                if (str.equals("+")) {
                    int val = list.get(list.size() - 1) + list.get(list.size() - 2);
                    list.add(val);
                    total += val;
                } else {
                    int val = list.get(list.size() - 1);

                    if (str.equals("D")) {
                        val *= 2;
                        list.add(val);
                        total += val;
                    } else if (str.equals("C")) {
                        list.remove(list.size() - 1);
                        total -= val;
                    }
                }
            }

        }

        return total;
    }
}
