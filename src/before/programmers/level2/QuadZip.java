package before.programmers.level2;

public class QuadZip {
    static class Solution {
        static int[] answer;

        public static int[] solution(int[][] arr) {
            answer = new int[2];
            int length = arr.length;

            divide(arr, 0, 0, length);
            return answer;
        }

        private static void divide(int[][] arr, int startX, int startY, int length) {
            int flag = arr[startX][startY];
            if (isAllSame(arr, startX, startY, length)) {
                answer[flag]++;
                return;
            }
            int nextLength = length / 2;
            divide(arr, startX, startY, nextLength);
            divide(arr, startX  + nextLength, startY, nextLength);
            divide(arr, startX, startY + nextLength, nextLength);
            divide(arr, startX + nextLength, startY + nextLength, nextLength);
        }

        private static boolean isAllSame(int[][] arr, int startX, int startY, int length) {
            int flag = arr[startX][startY];
            for (int i = startX; i < startX + length; i++) {
                for (int j = startY; j < startY + length; j++) {
                    if (flag != arr[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };

        int[] result = Solution.solution(arr);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}
