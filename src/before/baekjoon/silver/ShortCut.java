package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ShortCut {

    private static int d;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int[] loads = new int[d + 1];
        List<List<Load>> list = new ArrayList<>();
        for (int i = 0; i <= d; i++) {
            loads[i] = i;
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            if (start > d) {
                continue;
            }
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            list.get(start).add(new Load(start, end, length));
        }

        start(0, loads, list);
        System.out.println(loads[d]);
    }

    private static void start(int i, int[] loads, List<List<Load>> list) {
        if (i >= d){
            return;
        }
        if (loads[i + 1] > loads[i] + 1) {
            loads[i + 1] = loads[i] + 1;
        }

        for (Load load : list.get(i)) {
            int start = load.start;
            int end = load.end;
            int length = load.length;

            try {
                loads[end] = Math.min(loads[end], loads[start] + length);
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }
        start(i + 1, loads, list);
    }

    static class Load {
        int start;
        int end;
        int length;

        public Load(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
}
