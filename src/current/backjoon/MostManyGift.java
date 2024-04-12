package current.backjoon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostManyGift {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        int answer = solution.solution(friends, gifts);

        System.out.println("answer = " + answer);
    }

    static class Solution {
        public int solution(String[] friends, String[] gifts) {
            Map<String, Integer> map = new HashMap<>();

            /*-------------------------선물 주고 받은 수 세팅-----------------------------*/
            for (int i = 0; i < friends.length; i++) {
                map.put(friends[i], i);
            }

            int[][] giftMap = new int[friends.length][friends.length];

            for (String gift : gifts) {
                String[] split = gift.split(" ");
                String sender = split[0];
                String receiver = split[1];

                int senderPoint = map.get(sender);
                int receiverPoint = map.get(receiver);

                giftMap[senderPoint][receiverPoint] += 1;
            }
            for (int[] ints : giftMap) {
                System.out.println(Arrays.toString(ints));
            }

            /*-------------------------선물 지수 세팅-----------------------------*/
            Map<String, Integer> point = new HashMap<>();
            Map<String, Integer> result = new HashMap<>();
            for (int i = 0; i < friends.length; i++) {
                result.put(friends[i], 0);
            }

            for (int i = 0; i < giftMap.length; i++) {
                for (int j = 0; j < giftMap[i].length; j++) {
                    if (i == j) {
                        continue;
                    }
                    String me = friends[i];
                    String friend = friends[j];
                    int sendCount = giftMap[i][j];
                    int receiveCount = giftMap[j][i];
                    System.out.println(me + " send to " + friend + " " + sendCount + "gift and receive " + receiveCount + "gift");
                    point.put(me, point.getOrDefault(me, 0) + sendCount - receiveCount);
                }
            }
            System.out.println(point);

            for (int i = 0; i < giftMap.length; i++) {
                for (int j = 0; j < giftMap.length; j++) {
                    int sendCount = giftMap[i][j];
                    int receiveCount = giftMap[j][i];
                    String me = friends[i];
                    String you = friends[j];

                    if (sendCount > receiveCount) {
                        result.put(me, result.get(me) + 1);
                    }
                    if (sendCount == receiveCount) {
                        if (point.get(me) > point.get(you)) {
                            result.put(me, result.get(me) + 1);
                        }
                    }
                }
            }

            int max = 0;
            for (int count : result.values()) {
                max = Math.max(max, count);
            }
            return max;
        }
    }

}
