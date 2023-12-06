package before.programmers.level2;

public class Cut2DArray {
    static class Solution {
        public static int[] solution(int n, long left, long right) {
            int[] answer = new int[(int) (right - left + 1)];

            int index = 0;
            while (left <= right) {
                answer[index++] = (int) (Math.max(Math.floor(left / n), left++ % n) + 1);
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        int n = 4;
        long left = 7;
        long right = 14;

        int[] solution = Solution.solution(n, left, right);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
