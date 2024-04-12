package current.programmers;

import java.util.Stack;

public class DeliveryBox {

    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        Solution solution = new Solution();
        int answer = solution.solution(order);

        System.out.println("answer = " + answer);
    }

    static class Solution {

        public int solution(int[] order) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            for (int i = 1; i <= order.length; i++) {
                if (order[index] != i) {
                    stack.push(i);
                } else {
                    index++;
                    answer++;
                }
                while (!stack.isEmpty() && stack.peek() == order[index]) {
                    stack.pop();
                    index++;
                    answer++;
                }
            }
            return answer;
        }

    }

}
