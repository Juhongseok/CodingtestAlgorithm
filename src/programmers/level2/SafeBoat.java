package programmers.level2;

import java.util.Arrays;

public class SafeBoat {
    static class Solution {
        public static int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);

            int start = 0;

            for (int i = people.length-1; i >= start; i--) {
                if (people[i] + people[start] > limit) {
                    answer++;
                    continue;
                }
                start++;
                answer++;
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(Solution.solution(people, limit));
    }
}
