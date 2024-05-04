package current.programmers;

public class FoodFight {

    static class Solution {
        public String solution(int[] food) {
            String answer = "";

            for (int i = 1; i < food.length; i++) {
                answer += String.valueOf(i).repeat(food[i] / 2);
            }

            StringBuilder sb = new StringBuilder(answer);
            String reverseAnswer = sb.reverse().toString();

            return answer + "0" + reverseAnswer;
        }
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        Solution solution = new Solution();
        System.out.println(solution.solution(food));
    }

}
