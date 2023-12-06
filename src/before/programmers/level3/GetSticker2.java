package before.programmers.level3;

import java.util.Arrays;

public class GetSticker2 {
    static class Solution {
        /**
         * 스티커 원형으로 연결
         * 스티커를 뜯어내어 최대 합 구하기
         * 뜯어낸 양쪽 사용 불가
         *
         * 한칸씩 건너면서 선택
         * 위치가 홀수번째 짝수번째 합 구하기
         *
         * sticker.length
         *      --> 짝수: 홀수번째 짝수번째 합구하기
         *      --> 홀수: 짝수번째는 합구하기, 홀수번째는 마지막 값 빼기
         */
        public static int solution(int sticker[]) {
            if (sticker.length == 1) {
                return sticker[0];
            }
            int[] dp1 = new int[sticker.length];
            int[] dp2 = new int[sticker.length];

            dp1[0] = sticker[0];
            dp1[1] = sticker[0];

            for (int i = 2; i < sticker.length-1; i++) {
                dp1[i] = Math.max(dp1[i - 1], sticker[i] + dp1[i - 2]);
            }

            dp2[0] = 0;
            dp2[1] = sticker[1];
            for (int i = 2; i < sticker.length; i++) {
                dp2[i] = Math.max(dp2[i - 1], sticker[i] + dp2[i - 2]);
            }

            System.out.println(Arrays.toString(dp1));
            System.out.println(Arrays.toString(dp2));

            return Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);
        }
    }

    public static void main(String[] args) {
//        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        int[] sticker = {1,3,2,5,4};
        System.out.println(Solution.solution(sticker));
    }
}
