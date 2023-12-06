package before.programmers.level2;

public class Music {
    static class Solution {
        public static String solution(String m, String[] musicinfos) {
            String answer = "(None)";
            int maxPlayTime = -1;
            m = changeMelody(m);

            for (String musicInfo : musicinfos) {
                String[] info = musicInfo.split(",");
                String startTime = info[0];
                String endTime = info[1];
                String melody = changeMelody(info[3]);

                int start = Integer.parseInt(startTime.substring(0, 2)) * 60 + Integer.parseInt(startTime.substring(3));
                int end = Integer.parseInt(endTime.substring(0, 2)) * 60 + Integer.parseInt(endTime.substring(3));
                int play = end - start;

                int repeatCount = (int) Math.ceil((double)play / melody.length());
                String substring = melody.repeat(repeatCount).substring(0, play);

                if (substring.contains(m) && maxPlayTime < play) {
                    answer = info[2];
                    maxPlayTime = play;
                }
            }
            return answer;
        }

        private static String changeMelody(String m) {
            return m.replaceAll("C#", "H")
                    .replaceAll("D#", "I")
                    .replaceAll("F#", "J")
                    .replaceAll("G#", "K")
                    .replaceAll("A#", "L");
        }
    }

    public static void main(String[] args) {
//        String m = "ABCDEFG";
//        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(Solution.solution(m, musicinfos));
    }
}
