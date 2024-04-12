package current.programmers;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestAlbum1 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Solution solution = new Solution();
        int[] answer = solution.solution(genres, plays);

        System.out.println(Arrays.toString(answer));
    }

    static class Solution {

        public int[] solution(String[] genres, int[] plays) {
            PlayList playList = getPlayList(genres, plays);

            return playList.getBestMusic().stream()
                    .mapToInt(music -> music.id)
                    .toArray();
        }

        private static PlayList getPlayList(String[] genres, int[] plays) {
            List<Music> musics = IntStream.range(0, genres.length)
                    .mapToObj(i -> new Music(i, plays[i], genres[i]))
                    .toList();

            return new PlayList(musics);
        }

        static class PlayList {

            private List<PlayListByGenre> musics;

            public PlayList(List<Music> musics) {
                this.musics = getPlayListByGenres(musics);
            }

            private static List<PlayListByGenre> getPlayListByGenres(List<Music> musics) {
                return musics.stream()
                        .collect(Collectors.groupingBy(music -> music.genreName))
                        .entrySet().stream()
                        .map(entry -> new PlayListByGenre(entry.getValue(), entry.getKey()))
                        .toList();
            }

            public List<Music> getBestMusic() {
                return musics.stream()
                        .sorted()
                        .map(PlayListByGenre::getBestTwoMusic)
                        .flatMap(Collection::stream)
                        .toList();
            }

            static class PlayListByGenre implements Comparable<PlayListByGenre> {

                private List<Music> musics;

                private int totalPlayCount;

                private String genre;

                public PlayListByGenre(List<Music> musics, String genre) {
                    this.musics = musics;
                    this.totalPlayCount = sumTotalPlayCount(musics);
                    this.genre = genre;
                }

                private int sumTotalPlayCount(List<Music> musics) {
                    return musics.stream()
                            .mapToInt(music -> music.playCount)
                            .sum();
                }

                public List<Music> getBestTwoMusic() {
                    return musics.stream()
                            .sorted()
                            .limit(2)
                            .toList();
                }

                @Override
                public int compareTo(PlayListByGenre o) {
                    return o.totalPlayCount - totalPlayCount;
                }

            }

        }

        static class Music implements Comparable<Music> {

            private int id;

            private int playCount;

            private String genreName;

            public Music(int id, int playCount, String genreName) {
                this.id = id;
                this.playCount = playCount;
                this.genreName = genreName;
            }

            @Override
            public int compareTo(Music other) {
                if (playCount == other.playCount) {
                    return id - other.id;
                }

                return other.playCount - playCount;
            }

        }

    }

}
