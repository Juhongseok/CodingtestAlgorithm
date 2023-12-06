package before.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Capet {
    static class Solution {
        public static int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            int total = brown + yellow;

            List<Pair> list = new ArrayList<>();

            for (int i = 3; i < total; i++) {
                if (total % i == 0) {
                    int width = total / i;
                    if (width < i) {
                        break;
                    }
                    Pair pair = new Pair(width, i);
                    list.add(pair);
                }
            }

            for (Pair pair : list) {
                if (pair.getBorder() == brown) {
                    answer[0] = pair.width;
                    answer[1] = pair.height;
                    break;
                }
            }
            return answer;
        }

        static class Pair{
            int width;
            int height;

            public Pair(int width, int height) {
                this.width = width;
                this.height = height;
            }

            public int getBorder() {
                return (width + height - 2) * 2;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(24, 24)));
    }
}
