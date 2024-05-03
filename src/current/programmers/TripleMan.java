package current.programmers;

public class TripleMan {

    static class Solution {

        public int solution(int[] number) {
            int answer = 0;

            for(int i = 0; i < number.length; i++) {
                for(int j = i + 1; j < number.length; j++) {
                    for(int k = j + 1; k < number.length; k++) {
                        if(number[i] + number[j] + number[k] == 0) {
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }

    }

    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        Solution solution = new Solution();
        System.out.println(solution.solution(number));
    }

}
