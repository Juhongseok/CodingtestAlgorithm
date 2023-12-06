package before.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NormalBackpack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[] cache = new int[k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= weight[i]; j--) {
                cache[j] = Math.max(cache[j], cache[j - weight[i]] + value[i]);
            }
        }
        System.out.println(cache[k]);
    }
}
