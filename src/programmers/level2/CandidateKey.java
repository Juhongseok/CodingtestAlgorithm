package programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey {
    static class Solution {

        private static List<Integer> answer;

        public static int solution(String[][] relation) {
            answer = new ArrayList<>();
            int n = relation.length;
            int m = relation[0].length;

            for (int i = 1; i < 1<<m; i++) {
                Set<String> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    String now = "";
                    for (int k = 0; k < m; k++) {
                        if ((i & 1 << k) > 0) {
                            now += relation[j][k];
                        }
                    }
                    set.add(now);
                }
                if (set.size() == n && isPossible(i)) {
                    answer.add(i);
                }
            }
            return answer.size();
        }

        private static boolean isPossible(int i) {
            for (Integer integer : answer) {
                if ((integer & i) == integer) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        System.out.println(Solution.solution(relation));
    }
}
