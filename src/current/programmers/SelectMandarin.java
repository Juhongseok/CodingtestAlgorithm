package current.programmers;

import java.util.HashMap;
import java.util.Map;

public class SelectMandarin {

    public static void main(String[] args) {
//        int k = 6;
        int k = 3;
//        int k = 6;
//        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int[] tangerine = {1,1,2,2};
//        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        Solution solution = new Solution();
        int answer = solution.solution(k, tangerine);

        System.out.println("answer = " + answer);
    }

    static class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;

            // 귤을 크기 별로 분류
            // 필요한 값은 크기별 갯수 -> List<Integer>
            // 종류를 최소화 하기 위해서는 크기별 역순 정렬해서 각 합을 구하기
            int[] tangerineNumbers = getTangerineNumbers(tangerine);

            for (int tangerineNumber : tangerineNumbers) {
                if (k <= 0) {
                    break;
                }

                k -= tangerineNumber;
                answer++;
            }

            return answer;
        }

        private int[] getTangerineNumbers(int[] tangerine) {
            Map<Integer, Integer> numbers = new HashMap<>();

            for (int t : tangerine) {
                numbers.put(t, numbers.getOrDefault(t, 0) + 1);
            }

            return numbers.values().stream()
                    .sorted((o1, o2) -> o2 - o1)
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

    }

}
