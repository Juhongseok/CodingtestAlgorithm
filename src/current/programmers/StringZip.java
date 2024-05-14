package current.programmers;

public class StringZip {

    static class Solution {
        public int solution(String s) {
            int answer = 0;
            for (int i = 1; i <= (s.length() / 2) + 1; i++) {
                int result = getSplitedLength(s, i, 1).length();
                answer = i == 1 ? result : Math.min(answer, result);
            }
            return answer;
        }

        public String getSplitedLength(String s, int n, int repeat) {
            if (s.length() < n) {
                return s;
            }
            String preString = s.substring(0, n);
            String postSTring = s.substring(n);

            if (!postSTring.startsWith(preString)) {
                if (repeat == 1) {
                    return preString + getSplitedLength(postSTring, n, 1);
                }
                return repeat + preString + getSplitedLength(postSTring, n, 1);
            }

            return getSplitedLength(postSTring, n, repeat + 1);
        }
    }

    public static void main(String[] args) {
        String s = "aabbaccc";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }

}
