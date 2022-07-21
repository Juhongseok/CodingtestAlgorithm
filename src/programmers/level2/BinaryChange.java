package programmers.level2;

public class BinaryChange {
    static class Solution {
        public static int[] solution(String s) {
            int[] answer = new int[2];
            while (s.length() > 1) {
                String newS = s.replaceAll("0", "");
                answer[0]++;
                answer[1] += s.length() - newS.length();
                s = Integer.toBinaryString(newS.length());
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        String s = "110010101001";
        int[] result = Solution.solution(s);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
