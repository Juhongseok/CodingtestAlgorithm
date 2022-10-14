package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class DiscountEvent {
    static class Solution {
        public static int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            Map<String, Integer> wantMap = new HashMap<>();
            for (int i = 0; i < want.length; i++) {
                wantMap.put(want[i], number[i]);
            }

            System.out.println(wantMap);
            Map<String, Integer> discountMap = new HashMap<>();
            for (int i = 0; i <= discount.length - 10; i++) {
                boolean check = true;
                for (int j = i; j < i + 10; j++) {
                    String discountItem = discount[j];
                    discountMap.put(discountItem, discountMap.getOrDefault(discountItem, 0) + 1);
                }

                System.out.println("--> " + discountMap);
                for (String item : wantMap.keySet()) {
                    int wantItemCount = wantMap.get(item);
                    int discountItemCount = discountMap.getOrDefault(item, 0);

                    if (wantItemCount > discountItemCount) {
                        check = false;
                        break;
                    }
                }
                if (check)
                    answer++;
                discountMap.clear();
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(Solution.solution(want, number, discount));
    }
}
