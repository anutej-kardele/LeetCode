package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class PN118 {

    
    public static void main(String[] args) {
        
        List<List<Integer>> output = generate(5);

        for(int i = 0; i < output.size(); i++) {

            List<Integer> sample = output.get(i);

            for(int j = 0; j < sample.size(); j++) {
                System.out.print(sample.get(j) + " ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> values = new ArrayList<List<Integer>>();
        List<Integer> valList = new ArrayList<>();
        valList.add(1); 
        values.add(valList); 

        if(numRows == 1) return values; 

        for(int i = 1; i < numRows; i++) {
            valList = new ArrayList<>();
            valList.add(1);
            if(i == 1) {
                valList.add(1); 
                values.add(valList); 
                continue; 
            }

            for(int j = 1; j <= i; j++) {

                if(i == j) {
                    valList.add(1); 
                    continue; 
                }
                valList.add(values.get(i - 1).get(j) + values.get(i - 1).get(j - 1)); 
            }
            values.add(valList); 
        }

        return values; 
    }

}
