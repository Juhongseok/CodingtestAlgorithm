package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class CardSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(reader.readLine()));
        }

        int result = 0;
        for (int i = 1; i < n; i++) {
            Integer a = queue.poll();
            Integer b = queue.poll();
            result += a + b;
            queue.add(a + b);
        }
        System.out.println(result);
    }
}
