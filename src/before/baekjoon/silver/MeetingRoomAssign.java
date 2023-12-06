package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomAssign {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[][] meetingTime = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] time = reader.readLine().split(" ");
            meetingTime[i][0] = Integer.parseInt(time[0]);
            meetingTime[i][1] = Integer.parseInt(time[1]);
        }

        Arrays.sort(meetingTime, Comparator.comparingInt((int[] time) -> time[1])
                .thenComparing(startTime -> startTime[0]));

        int count = 0;
        int prevEndTime = -1;
        for (int i = 0; i < n; i++) {
            if (meetingTime[i][0] >= prevEndTime) {
                count++;
                prevEndTime = meetingTime[i][1];
            }
        }

        System.out.println(count);
    }
}
