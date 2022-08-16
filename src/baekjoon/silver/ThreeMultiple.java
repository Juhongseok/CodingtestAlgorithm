package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeMultiple {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x = reader.readLine();
        check(x);
    }

    private static void check(String x) {
        int sum = 0;
        if (x.length() == 1) {
            System.out.println(Integer.parseInt(x) % 3 == 0 ? count + "\nYES" : count + "\nNO");
            return;
        } else {
            for (int i = 0; i < x.length(); i++) {
                sum = sum + Integer.parseInt(String.valueOf(x.charAt(i)));
            }
            count++;
            check(Integer.toString(sum));
        }
    }
}
