package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CuteLion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine(), " ");
        int[] doll = new int[n];

        for (int i = 0; i < n; i++) {
            doll[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int result = Integer.MAX_VALUE;
        while (left < n) {
            if (count >= k || right == n) {
                count -= doll[left++] == 1 ? 1 : 0;
            } else if (count < k) {
                count += doll[right++] == 1 ? 1 : 0;
            }

            if (count == k) {
                result = Math.min(result, right - left);
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}
