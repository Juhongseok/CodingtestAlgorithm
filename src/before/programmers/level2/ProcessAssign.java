package before.programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class ProcessAssign {
    static class Solution {
        static Stack<Homework> remain = new Stack<>();
        static int answerIndex = 0;
        private static String[] answer;

        public static String[] solution(String[][] plans) {
            answer = new String[plans.length];
            PriorityQueue<Homework> homeworks = new PriorityQueue<>();

            for (String[] plan : plans) {
                String[] timeMinute = plan[1].split(":");
                int time = Integer.parseInt(timeMinute[0]) * 60 + Integer.parseInt(timeMinute[1]);
                homeworks.add(new Homework(plan[0], time, Integer.parseInt(plan[2])));
            }

            while (!homeworks.isEmpty()) {
                run(homeworks.poll(), homeworks.isEmpty() ? Integer.MAX_VALUE : homeworks.peek().startTime);
            }

            return answer;
        }

        static void run(Homework current, int nextStartTime) {
            int finishTime = current.startTime + current.playTime;

            if (finishTime > nextStartTime) {
                current.playTime = finishTime - nextStartTime;
                remain.add(current);
            } else {
                answer[answerIndex++] = current.name;
                if (!remain.isEmpty()) {
                    current = remain.pop();
                    current.startTime = finishTime;
                    run(current, nextStartTime);
                }
            }
        }

        static class Homework implements Comparable<Homework> {
            String name;
            int startTime;
            int playTime;

            public Homework(String name, int startTime, int playTime) {
                this.name = name;
                this.startTime = startTime;
                this.playTime = playTime;
            }

            @Override
            public int compareTo(Homework next) {
                return this.startTime - next.startTime;
            }
        }
    }

    public static void main(String[] args) {
//        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
//        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        System.out.println(Arrays.toString(Solution.solution(plans)));
    }
}
