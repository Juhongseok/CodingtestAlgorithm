package before.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LongestIncreased {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int number = array[i];
            int start = 0;
            int end = list.size() - 1;

            if (number > list.get(list.size() - 1)) {
                list.add(number);
            } else {
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (number <= list.get(mid)) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                list.set(end, number);
            }
        }
        System.out.println(list.size() - 1);
    }
}
