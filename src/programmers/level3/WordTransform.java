package programmers.level3;

public class WordTransform {
    static class Solution {
        static boolean[] visited;
        static int answer = 0;
        public static int solution(String begin, String target, String[] words) {
            visited = new boolean[words.length];
            find(begin, target, words, 0);
            return answer;
        }

        private static void find(String begin, String target, String[] words, int count) {
            if (begin.equals(target)) {
                answer = count;
                return;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) {
                    continue;
                }
                int sameWord = 0;
                for (int j = 0; j < begin.length(); j++) {
                    if (begin.charAt(j) == words[i].charAt(j)) {
                        sameWord++;
                    }
                }

                if (sameWord == begin.length() - 1) {
                    visited[i] = true;
                    find(words[i], target, words, count + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(Solution.solution(begin, target, words));
    }
}
