package current.programmers;

import java.util.HashMap;
import java.util.Map;

public class NoRunPlayer {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Solution solution = new Solution();
        String answer = solution.solution(participant, completion);

        System.out.println("answer = " + answer);
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> players = new HashMap<>();

            for (String player : participant) {
                players.put(player, players.getOrDefault(player, 0) + 1);
            }

            for (String player : completion) {
                int count = players.get(player);
                if (count == 1) {
                    players.remove(player);
                } else {
                    players.put(player, players.get(player) - 1);
                }
            }

            String[] array = players.keySet().toArray(new String[]{});

            return array[0];
        }
    }
}
