package programmers.level3;

public class SetBaseStation {
    /**
     * 기지국이 설치 되었을 때 전파가 닿는 거리 2*w+1
     * stations 기지국을 기준으로 start, end point 구하기
     * 만일 start~end 거리가 2*w+1보다 작으면 answer+1
     * start~end 거리가 2*w+1보다 크면 answer += math.ceil(거리/2*w+1)
     * 마지막 기지국이 끝까지 전파를 전달하는지 확인
     */
    static class Solution {
        public static int solution(int n, int[] stations, int w) {
            int answer = 0;

            int start = 1;
            for (int i = 0; i < stations.length; i++) {
                int end = stations[i] - (w + 1);
                if (start < stations[i] - w) {
                    answer += search(start, end, w);
                }
                start = stations[i] + w + 1;
            }

            if (stations[stations.length - 1] + w < n) {
                answer += search(stations[stations.length - 1] + w + 1, n, w);
            }
            return answer;
        }

        private static int search(int start, int end, int w) {
            int length = end - start + 1;
            if (length < 2 * w + 1) {
                return 1;
            }
            return (int) Math.ceil((double) length / (2 * w + 1));
        }
    }

    public static void main(String[] args) {
 /*       int n = 16;
        int[] stations = {9};
        int w = 2;
*/
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
        System.out.println(Solution.solution(n, stations, w));
    }
}
