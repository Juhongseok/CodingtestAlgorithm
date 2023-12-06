package before.programmers.level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class DoublePriorityQueue {
    static class Solution {
        public static int[] solution(String[] operations) {
            int[] answer = {0, 0};

            Queue<Integer> minQueue = new PriorityQueue<>();
            Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (String operation : operations) {
                String[] command = operation.split(" ");
                String operator = command[0];
                int number = Integer.parseInt(command[1]);

                if (operator.equals("I")) {
                    minQueue.add(number);
                    maxQueue.add(number);
                    continue;
                }

                if (!minQueue.isEmpty()) {
                    if (number == -1) {
                        maxQueue.remove(minQueue.remove());
                    } else {
                        minQueue.remove(maxQueue.remove());
                    }
                }
            }

            if (!minQueue.isEmpty()) {
                answer[0] = maxQueue.poll();
                answer[1] = minQueue.poll();
            }
            return answer;
        }
    }

    public static void main(String[] args) {
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(Solution.solution(operations)));
    }
}
