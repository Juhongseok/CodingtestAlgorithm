package before.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LectureRoomAssignment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            lectures.add(new Lecture(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        lectures.sort((o1, o2) -> o1.startTime == o2.startTime ? o1.endTime - o2.endTime : o1.startTime - o2.startTime);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(lectures.get(0).endTime);
        for (int i = 1; i < lectures.size(); i++) {
            if (queue.peek() <= lectures.get(i).startTime) {
                queue.poll();
            }
            queue.add(lectures.get(i).endTime);
        }
        System.out.println(queue.size());
    }

    static class Lecture {
        int startTime;
        int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
