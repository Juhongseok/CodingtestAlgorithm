package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NAndM2 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dfs(n, m,1, new ArrayList<>());
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int start, List<Integer> list) {
        System.out.println("start = " + start + ", list = " + list);
        if (list.size() == m) {
            for (int val : list) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!list.contains(i)) {
                list.add(i);
                dfs(n, m, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
