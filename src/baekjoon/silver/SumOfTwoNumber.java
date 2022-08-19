package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfTwoNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(reader.readLine());

        Arrays.sort(numbers);
        int left = 0;
        int right = n - 1;
        int result = 0;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < x) {
                left++;
            } else if (sum >= x) {
                right--;
            }

            if (sum == x) {
                result++;
            }
        }
        System.out.println(result);
    }
}
