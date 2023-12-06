package before.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Zip {
    static class Solution {
        public static int[] solution(String msg) {
            Map<String, Integer> map = new HashMap<>();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i <= 25; i++) {
                map.put(Character.toString('A' + i), i + 1);
            }

            int index = map.size();
            int size = msg.length();
            for (int i = 0; i < size; i++) {
                int length = 1;
                while (i + length <= size && map.containsKey(msg.substring(i, i + length))) {
                    length++;
                }
                if (i + length > size) {
                    result.add(map.get(msg.substring(i)));
                    break;
                }
                result.add(map.get(msg.substring(i, i+length-1)));
                map.put(msg.substring(i, i + length), ++index);
                i += length - 2;
            }
            int[] answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        String msg = "KAKAO";
        int[] solution = Solution.solution(msg);
        for (int i : solution) {
            System.out.println(i + " ");
        }
    }
}
