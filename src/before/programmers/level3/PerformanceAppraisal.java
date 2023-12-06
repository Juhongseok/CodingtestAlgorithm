package before.programmers.level3;

import java.util.*;

public class PerformanceAppraisal {
    /**
     * 첫번째 완호 점수
     * [근무 태도 점수, 동료 평가 점수]
     * 다른 사원보다 두 점수 모두 낮으면 인센티브 받지 못함
     * 그 외 사원 두 점수 합으로 내림차순 정렬
     *
     * 완호의 등수 리턴
     */

    static class Solution {
        public static int solution(int[][] scores) {
            int wanHoSum = scores[0][0] + scores[0][1];
            Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
            int answer = 1;
            int maxScore = 0;

            for (int[] score : scores) {
                if (score[1] < maxScore) {
                    if (score.equals(scores[0])) {
                        return -1;
                    }
                } else {
                    maxScore = Math.max(maxScore, score[1]);
                    if (score[0] + score[1] > wanHoSum) {
                        answer++;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        /*int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};
        System.out.println(Solution.solution(scores));*/

        try {
            if (1 == 1) {
                System.out.println("true");
            }
        } catch (Exception e) {

        }

        try {
            System.out.println("2");
        } catch (Exception e) {

        }
    }
}
