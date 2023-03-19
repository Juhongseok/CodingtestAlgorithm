package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temperature = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int tempAnswer = 0;
            for (int j = i; j < i + k; j++) {
                tempAnswer += temperature[j];
            }

            answer = Math.max(answer, tempAnswer);
        }
        System.out.println(answer);
    }
}
