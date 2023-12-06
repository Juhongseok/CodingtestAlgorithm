package before.programmers.level2;

import java.util.*;

public class PlayAlone {
    static class Solution {
        public static int solution(int[] cards) {
            int answer = 0;

            NumberCard[] numberCards = new NumberCard[cards.length];
            for (int i = 0; i < cards.length; i++) {
                numberCards[i] = new NumberCard(cards[i]);
            }

            List<List<Integer>> result = new ArrayList<>();
            int groupNumber = 0;
            for (int i = 0; i < cards.length; i++) {
                result.add(new ArrayList<>());

                NumberCard current = numberCards[i];
                if (current.open) {
                    continue;
                }
                List<Integer> currentGroup = result.get(groupNumber++);

                while (!current.open) {
                    current.open = true;
                    currentGroup.add(current.number);
                    current = numberCards[current.number - 1];
                }
            }

            Collections.sort(result, (o1, o2) -> Integer.compare(o2.size(), o1.size()));
            if (result.size() > 1) {
                answer = result.get(0).size() * result.get(1).size();
            }

            return answer;
        }

        static class NumberCard{
            private int number;
            private boolean open;

            public NumberCard(int number) {
                this.number = number;
                this.open = false;
            }

            @Override
            public String toString() {
                return "NumberCard{" +
                        "number=" + number +
                        '}';
            }
        }
    }

    public static void main(String[] args) {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        System.out.println(Solution.solution(cards));
    }
}
