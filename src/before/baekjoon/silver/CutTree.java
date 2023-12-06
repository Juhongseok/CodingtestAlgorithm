package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutTree {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];

        st = new StringTokenizer(reader.readLine(), " ");
        long start = 0;
        long end = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, trees[i]);
        }

        while (start < end) {
            long mid = (start + end) / 2;
            long result = 0;
            for (int tree : trees) {
                long remaining = tree - mid;
                result += remaining < 0 ? 0 : remaining;
            }

            if (result < m) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start-1);

    }
}
