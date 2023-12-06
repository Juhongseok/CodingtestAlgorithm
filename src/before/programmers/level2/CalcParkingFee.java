package before.programmers.level2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CalcParkingFee {
    static class Solution {
        public static int[] solution(int[] fees, String[] records) {
            Map<String, String> map = new HashMap<>();
            Map<String, Integer> totalTimeMap = new HashMap<>();
            Map<String, Integer> feesMap = new TreeMap<>();

            for (String record : records) {
                String[] s = record.split(" ");
                String currentTime = s[0];
                String carNumber = s[1];
                String state = s[2];

                if (state.equals("IN")) {
                    map.put(carNumber, currentTime);
                } else if (state.equals("OUT")) {
                    String inTime = map.remove(carNumber);
                    String[] time1 = inTime.split(":");
                    String[] time2 = currentTime.split(":");

                    int inTimeForMinute = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
                    int currentTimeForMinute = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);

                    int parkingTime = currentTimeForMinute - inTimeForMinute;
                    totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkingTime);
                }
            }

            if (!map.isEmpty()) {
                int lastOutTime = 23 * 60 + 59;
                for (String carNumber : map.keySet()) {
                    String inTime = map.get(carNumber);
                    String[] time1 = inTime.split(":");

                    int inTimeForMinute = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
                    totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + lastOutTime - inTimeForMinute);
                }
            }
            for (String carNumber : totalTimeMap.keySet()) {
                int totalTime = totalTimeMap.get(carNumber);
                int defaultTime = fees[0];
                int defaultFee = fees[1];
                if (totalTime <= defaultTime) {
                    feesMap.put(carNumber, defaultFee);
                } else {
                    int unitTime = fees[2];
                    int unitFee = fees[3];
                    feesMap.put(carNumber, defaultFee + (int) Math.ceil((double) (totalTime - defaultTime) / unitTime) * unitFee);
                }
            }
            List<Integer> collect = feesMap.keySet()
                    .stream()
                    .sorted()
                    .mapToInt(feesMap::get)
                    .boxed()
                    .collect(Collectors.toList());

            int[] answer = new int[collect.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = collect.get(i);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        /*int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"
        };*/
        int[] fees = {1, 461, 1, 10};
        String[] records = {
                "00:00 1234 IN"
        };
        int[] solution = Solution.solution(fees, records);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

}
