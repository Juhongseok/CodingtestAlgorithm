package before.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordMath {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new StringBuilder(reader.readLine()).reverse().toString();
        }

        Arrays.sort(arr, Comparator.comparing(String::length).reversed());

        Map<Character, Integer> map = new HashMap<>();
        int start = arr[0].length() - 1;

        for (int i = start; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i >= arr[j].length()) {
                    break;
                }

                char c = arr[j].charAt(i);
                map.put(c, map.getOrDefault(c, 0) + (int) Math.pow(10, i));
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Character c : map.keySet()) {
            list.add(map.get(c));
        }

        Collections.sort(list, Comparator.reverseOrder());

        int answer = 0;
        int number = 9;
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i) * number--;
        }

        System.out.println(answer);
    }
}
