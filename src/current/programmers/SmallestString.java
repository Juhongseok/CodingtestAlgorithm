package current.programmers;

public class SmallestString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String t = "10203";
        String p = "15";
        int answer = solution.solution(t, p);

        System.out.println("answer = " + answer);
    }

    static class Solution {
        public int solution(String t, String p) {
            int answer = 0;

            int targetSize = t.length();
            int sampleSize = p.length();

            for (int i = 0; i < targetSize - sampleSize + 1; i++) {
                String partTargetString = t.substring(i, i + sampleSize);

                if (partTargetString.compareTo(p) <= 0) {
                    answer++;
                }
            }
            return answer;
        }
    }

}
