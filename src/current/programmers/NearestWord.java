package current.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NearestWord {

    static class Solution {

        public int[] solution(String s) {
            String[] words = s.split("");
            int[] answer = new int[words.length];

            Map<String, Integer> position = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                answer[i] = i - position.getOrDefault(words[i], i + 1);
                position.put(words[i], i);
            }

            return answer;
        }

    }

    public static void main(String[] args) {
        String s = "banana";
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(s)));
    }

}
