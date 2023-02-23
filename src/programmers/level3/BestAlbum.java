package programmers.level3;

import java.util.*;

import static java.util.stream.Collectors.*;

public class BestAlbum {
    static class Solution {
        public static int[] solution(String[] genres, int[] plays) {
            Map<String, Map<Integer, Integer>> musicMap = new HashMap<>();
            Map<String, Integer> totalCount = new HashMap<>();

            for (int i = 0; i < plays.length; i++) {
                String musicGenre = genres[i];
                int playCount = plays[i];

                int genrePlayCount = totalCount.getOrDefault(musicGenre, 0);
                totalCount.put(musicGenre, genrePlayCount + playCount);

                Map<Integer, Integer> music = musicMap.getOrDefault(musicGenre, new HashMap<>());
                music.put(i, playCount);
                musicMap.put(musicGenre, music);
            }

            List<String> totalCountKeys = totalCount.keySet()
                    .stream()
                    .sorted((o1, o2) -> totalCount.get(o2) - totalCount.get(o1))
                    .collect(toList());

            List<Integer> answerTemp = new ArrayList<>();
            for (String totalCountKey : totalCountKeys) {
                Map<Integer, Integer> map = musicMap.get(totalCountKey);

                List<Integer> keys = map.keySet()
                        .stream()
                        .sorted((o1, o2) -> map.get(o2) - map.get(o1))
                        .limit(2)
                        .collect(toList());

                answerTemp.addAll(keys);
            }

            int[] answer = new int[answerTemp.size()];
            for (int i = 0; i < answerTemp.size(); i++) {
                answer[i] = answerTemp.get(i);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic"};
        int[] plays = {500, 600, 150, 800};

        System.out.println(Arrays.toString(Solution.solution(genres, plays)));
    }
}
