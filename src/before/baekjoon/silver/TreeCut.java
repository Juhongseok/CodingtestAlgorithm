package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeCut {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        long start = 0;
        long end = trees[n - 1];
        while (start + 1 < end) {
            long mid = (start + end) / 2;
            if (remainSize(mid, trees) < m) {
                end = mid;
            } else {
                start = mid;
            }
        }
        System.out.println(start);
    }

    private static long remainSize(long mid, int[] trees) {
        long total = 0;
        for (int tree : trees) {
            long cut = tree - mid;
            if (cut > 0) {
                total += cut;
            }
        }
        return total;
    }
}
