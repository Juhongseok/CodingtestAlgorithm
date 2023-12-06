package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SearchNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        HashMap<String, Boolean> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        while (st.hasMoreTokens()) {
            map.put(st.nextToken(), true);
        }

        int m = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            sb.append(map.getOrDefault(st.nextToken(), false) ? 1 + "\n" : 0 + "\n");
        }
        System.out.println(sb);
    }
}
