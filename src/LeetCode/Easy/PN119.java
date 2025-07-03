package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class PN119 {
    
    public static void main(String[] args) {
        
        List<Integer> sample = getRow(5);

        for(int j = 0; j < sample.size(); j++) {
            System.out.print(sample.get(j) + " ");
        } 

    }

    public static List<Integer> getRow(int rowIndex) {

        List<List<Integer>> values = new ArrayList<List<Integer>>();
        List<Integer> valList = new ArrayList<>();
        valList.add(1); 
        values.add(valList); 

        if(rowIndex == 0) return values.get(rowIndex); 

        for(int i = 1; i <= rowIndex; i++) {
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

        return values.get(rowIndex);  
    }

}
