package before.programmers.level3;


import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class NightShift {
    static class Solution {
        public static long solution(int n, int[] works) {
            Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for (int work : works) {
                queue.offer(work);
            }

            System.out.println(queue);
            while (n > 0) {
                Integer work = queue.poll();
                if (work == 0) {
                    break;
                }
                queue.offer(--work);
                n--;
            }
            long answer = 0;
            System.out.println(queue);
            for (int work : queue) {
                answer += work * work;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 99;
        int[] works = {2,15,22,55,55};
        System.out.println(Solution.solution(n, works));
    }
}
