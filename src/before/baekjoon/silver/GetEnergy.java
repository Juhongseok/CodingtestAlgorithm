package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GetEnergy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        List<Integer> marble = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            marble.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(getMax(marble));
    }

    private static int getMax(List<Integer> marble) {
        int max = 0;

        for (int i = 1; i < marble.size()-1; i++) {
            int temp = marble.get(i - 1) * marble.get(i + 1);
            Integer current = marble.remove(i);
            temp += getMax(marble);
            max = Math.max(max, temp);
            marble.add(i, current);
        }

        return max;
    }
}
