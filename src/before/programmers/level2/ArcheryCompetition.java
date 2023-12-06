package before.programmers.level2;

import java.util.Arrays;

public class ArcheryCompetition {
    static class Solution {
        public static int[] solution(int n, int[] info) {
            int[] answer = new int[11];
            int[] temp = new int[11];
            int maxDiff = 0;

            for (int subset = 1; subset < 1 << 10; subset++) {
                int ryan = 0;
                int apeach = 0;
                int count = 0;

                for (int i = 0; i < 10; i++) {
                    if ((subset & (1 << i)) != 0) {
                        ryan += 10 - i;
                        temp[i] = info[i] + 1;
                        count += temp[i];
                    } else {
                        temp[i] = 0;
                        if (info[i] > 0) {
                            apeach += 10 - i;
                        }
                    }
                }
                if (count > n) {
                    continue;
                }

                temp[10] = n - count;

                if (ryan - apeach == maxDiff) {
                    for (int i = 10; i >= 0; i--) {
                        if (temp[i] > answer[i]) {
                            maxDiff = ryan - apeach;
                            answer = Arrays.copyOf(temp, temp.length);
                            break;
                        } else if (temp[i] < answer[i]) {
                            break;
                        }
                    }
                }else if (ryan - apeach > maxDiff) {
                    maxDiff = ryan - apeach;
                    answer = Arrays.copyOf(temp, temp.length);
                }
            }

            if (maxDiff == 0) {
                return new int[]{-1};
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] solution = Solution.solution(n, info);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
