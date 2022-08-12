package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Scale {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] number = new int[n];
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(number);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + 1 < number[i]) {
                break;
            }
            sum += number[i];
        }
        System.out.println(sum+1);
    }
}
