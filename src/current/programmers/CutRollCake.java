package current.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CutRollCake {

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        Solution solution = new Solution();
        int answer = solution.solution(topping);

        System.out.println("answer = " + answer);
    }

    static class Solution {

        public int solution(int[] topping) {
            int answer = 0;

            // 각 토핑이 몇개씩 있는지 확인 - map 구조
            Map<Integer, Integer> toppingCountMap = new HashMap<>();
            for (int t : topping) {
                toppingCountMap.put(t, toppingCountMap.getOrDefault(t, 0) + 1);
            }

            // 같은 토핑에 한해서는 중복 제거해야 하니 set 구조 사용
            Set<Integer> olderBrother = new HashSet<>();
            for (int t : topping) {
                // set에 순차적으로 토핑 넣어주고
                olderBrother.add(t);
                toppingCountMap.put(t, toppingCountMap.get(t) - 1);

                // 토핑 갯수가 0이면 map에서 제거
                if (toppingCountMap.get(t) == 0) {
                    toppingCountMap.remove(t);
                }

                // set은 철수 map은 동생이라 가정 set.size == map.size이면 나누기 가능
                if (olderBrother.size() == toppingCountMap.size()) {
                    answer++;
                }
            }

            return answer;
        }

    }

}
