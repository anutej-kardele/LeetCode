package Code;

import java.util.Random;

public class random {

    public static void main(String[] args) {

        String str = "";
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {

            str += rand.nextInt(10);
        }

        System.out.println(str);
    }

}
