package current.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HIndex {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        Solution solution = new Solution();
        int answer = solution.solution(citations);

        System.out.println("answer = " + answer);
    }

    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            Map<Integer, Integer> indicators = new HashMap<>();
            Arrays.sort(citations);

            int totalCount = citations.length;
            for (int i = 0; i < citations.length; i++) {
                int key = citations[i];
                int value = totalCount - i;
                indicators.put(key, value);
            }

            for (Map.Entry<Integer, Integer> entry : indicators.entrySet()) {
                if (entry.getKey() >= entry.getValue()) {
                    answer = entry.getValue();
                    break;
                }
            }

            return answer;
        }
    }

}
