package before.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class SequenceSum {
    static class Solution {
        public static int solution(int[] elements) {
            Set<Integer> result = new HashSet<>();
            for (int i = 1; i <= elements.length; i++) {
                for (int j = 0; j < elements.length; j++) {
                    int sum = 0;
                    for (int k = j; k < j+i; k++) {
                        sum += elements[k % elements.length];
                    }
                    result.add(sum);
                }
            }

            return result.size();
        }
    }

    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        System.out.println(Solution.solution(elements));
    }
}
