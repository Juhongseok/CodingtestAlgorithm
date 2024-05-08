package current.programmers;

import java.util.Arrays;

public class EmoticonSale {

    static class Solution {
        int min = Integer.MAX_VALUE;
        int[] emoticonSalesRates = {10, 20, 30, 40};
        int total_join = 0, total_price = 0;

        public int[] solution(int[][] users, int[] emoticons) {
            int[] answer = new int[2];

            for (int[] user : users) {
                min = Math.min(min, user[0]); // 최소 할인 비율
            }
            for (int i = 0; i < 5; i++) {
                if (min <= emoticonSalesRates[i]) {
                    min = i; // index
                    break;
                }
            }

            int[] discounts = new int[emoticons.length];
            comb(discounts, 0, users, emoticons);

            return answer;
        }

        private void comb(int[] discounts, int start, int[][] users, int[] emoticons) {
            if (start == emoticons.length) {
                calculate(users, emoticons, discounts);
                return;
            }

            for (int i = start; i < emoticons.length; i++) {
                for (int j = min; j < 5; j++) {
                    discounts[i] = emoticonSalesRates[j];
                    comb(discounts, i + 1, users, emoticons);
                }
            }
        }

        private void calculate(int[][] users, int[] emoticons, int[] discounts) {
            int join = 0;
            int price = 0;

            for (int[] user : users) {
                int userMinDiscount = user[0];
                int userMaxPay = user[1];
                int sum = 0;

                for (int i = 0; i < discounts.length; i++) {
                    if (discounts[i] >= userMinDiscount) {
                        sum += sale(emoticons[i], discounts[i]);
                    }
                }

                if (userMaxPay <= sum) {
                    join++;
                } else {
                    price += sum;
                }
            }

            if (join > total_join) {
                total_join = join;
                total_price = price;
            } else if (join == total_join && price > total_price) {
                total_price = price;
            }
        }

        private int sale(int price, int percent) {
            return (price / 100) * (100 - percent);
        }

    }

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(users, emoticons)));
    }
}
