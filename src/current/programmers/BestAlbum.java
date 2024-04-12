package current.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BestAlbum {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Solution solution = new Solution();
        int[] answer = solution.solution(genres, plays);

        System.out.println(Arrays.toString(answer));
    }

    static class Solution {

        public int[] solution(String[] genres, int[] plays) {
            // music을 초기화 하기
            // 개별로 하나, 장르별 하나 -> hashmap으로 가지고 있기
            Map<String, Genre> totalPlays = new HashMap<>();
            List<Music> musics = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                // 장르별 총 플레이 횟수 초기화
                Genre genre = totalPlays.getOrDefault(genres[i], new Genre(genres[i]));
                genre.addPlayCount(plays[i]);
                totalPlays.put(genres[i], genre);

                // 장르별 음악 초기화
                musics.add(new Music(i, plays[i], totalPlays.get(genres[i])));
            }

            Map<Genre, List<Music>> collect = musics.stream()
                    .collect(Collectors.groupingBy(music -> music.genre));

            return collect.entrySet().stream()
                    .sorted((o1, o2) -> o2.getKey().totalPlayCount - o1.getKey().totalPlayCount)
                    .flatMap(map -> map.getValue().stream().sorted().limit(2))
                    .mapToInt(music -> music.id)
                    .toArray();
        }

        static class Music implements Comparable<Music> {

            private int id;

            private int playCount;

            private Genre genre;

            public Music(int id, int playCount, Genre genre) {
                this.id = id;
                this.playCount = playCount;
                this.genre = genre;
            }

            @Override
            public int compareTo(Music other) {
                if (playCount == other.playCount) {
                    return id - other.id;
                }

                return other.playCount - playCount;
            }

        }

        static class Genre {

            private int totalPlayCount;

            private String name;

            public Genre(String name) {
                this.name = name;
            }

            public void addPlayCount(int playCount) {
                this.totalPlayCount += playCount;
            }

        }

    }

}
