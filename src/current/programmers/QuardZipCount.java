package current.programmers;

import java.util.Arrays;

public class QuardZipCount {

    static class Solution {
        int[] answer;
        public int[] solution(int[][] arr) {
            answer = new int[2];

            divide(arr, 0, 0, arr.length);

            return answer;
        }

        private void divide(int[][] arr, int startX, int startY, int length) {
            int target = arr[startX][startY];
            if (isAllSame(arr, target, startX, startY, length)) {
                answer[target]++;
                return;
            }

            int nextLength = length / 2;
            divide(arr, startX, startY, nextLength);
            divide(arr, startX  + nextLength, startY, nextLength);
            divide(arr, startX, startY + nextLength, nextLength);
            divide(arr, startX + nextLength, startY + nextLength, nextLength);
        }

        private boolean isAllSame(int[][] arr, int target, int startX, int startY, int length) {
            for (int i = startX; i < startX + length; i++) {
                for (int j = startY; j < startY + length; j++) {
                    if (target != arr[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(arr)));
    }

}
