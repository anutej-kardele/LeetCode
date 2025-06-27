package LeetCode.Easy;

public class PN121 {

    public static void main(String[] args){

        //int prices[] = {7,1,5,3,6,4};
        int prices[] = {7,6,4,3,1};

        System.out.println("Highest profit is : " + maxProfit(prices));
        //System.out.println("Highest profit is : " + maxProfitUseless(prices));
        //System.out.println("Highest profit is : " + maxProfitBad(prices));
    }

    public static int maxProfit(int[] prices){

        int maxProfit = 0;
        int buyPrice = prices[0];

        for(int i = 1; i < prices.length; i++){

            if(buyPrice > prices[i]) 
                buyPrice = prices[i];
            else if (prices[i] - buyPrice > maxProfit) maxProfit = prices[i] - buyPrice;
        }

        return maxProfit;
    }

    public static int maxProfitBad(int[] prices) {

        //int profits[] = new int[prices.length - 1];

        int maxProfit = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length - 1; i++){

            int highestProfit = Integer.MIN_VALUE;

            for(int j = i + 1; j < prices.length; j++){
                if( ( prices[j] - prices[i] ) > highestProfit) highestProfit = prices[j] - prices[i];
            }

            if(maxProfit < highestProfit) maxProfit = highestProfit;
            //profits[i] = highestProfit;
        }

        //System.out.println(Arrays.toString(profits));

        return (maxProfit < 0) ? 0 : maxProfit;
    }

    public static int maxProfitUseless(int[] prices) {

        //int profits[] = new int[prices.length - 1];

        int minValue = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] < minValue) {
                minValue = prices[i];
                minIndex = i;
            }
        }

        System.out.println("Min Value : " + minValue + " Min Index : "+ minIndex);

        int highestProfit = Integer.MIN_VALUE;

        for(int i = minIndex + 1; i < prices.length; i++){
            if( ( prices[i] - minValue ) > highestProfit) highestProfit = prices[i] - minValue;
        }

        System.out.println("Highest Profit "+ highestProfit);

        return (highestProfit < 0) ? 0 : highestProfit;
    }
    
}
