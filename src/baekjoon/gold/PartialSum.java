package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PartialSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        int answer = Integer.MAX_VALUE;
        while (true) {
            if (sum >= s) {
                answer = Math.min(answer, end - start);
                sum -= numbers[start++];
            } else if (end == n) {
                break;
            } else {
                sum += numbers[end++];
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
