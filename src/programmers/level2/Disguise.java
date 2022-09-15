package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Disguise {
    static class Solution {
        public static int solution(String[][] clothes) {
            /*int answer = 1;

            HashMap<String, Integer> map = new HashMap<>();

            for (String[] clothe : clothes) {
                map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
            }

            for (Integer value : map.values()) {
                answer *= ++value;
            }
            return answer;*/
            return Arrays.stream(clothes)
                    .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                    .values()
                    .stream()
                    .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
        }
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(Solution.solution(clothes));
    }
}
