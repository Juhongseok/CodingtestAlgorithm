package programmers.level3;

import java.util.*;

public class MultiLevelToothbrush {
    static class Solution {

        private static Map<String, Integer> index;
        private static List<Seller> list;

        public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];

            index = new HashMap<>();
            for (int i = 0; i < enroll.length; i++) {
                index.put(enroll[i], i);
            }

            list = new ArrayList<>();
            for (int i = 0; i < enroll.length; i++) {
                Seller s = new Seller(enroll[i]);
                if (!referral[i].equals("-")) {
                    s.addSuperSeller(referral[i]);
                }
                list.add(s);
            }

            for (int i = 0; i < seller.length; i++) {
                String sellerName = seller[i];
                int toothbrushPrice = amount[i] * 100;
                setPrice(sellerName, toothbrushPrice);
            }

            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i).totalPrice;
            }
            return answer;
        }

        private static void setPrice(String sellerName, int toothbrushPrice) {
            Seller seller = list.get(index.get(sellerName));
            if (seller.superSeller.equals("")) {
                seller.addPrice(toothbrushPrice - toothbrushPrice/10);
                return;
            }

            int myPrice = toothbrushPrice - toothbrushPrice / 10;
            int superPrice = toothbrushPrice / 10;

            if (superPrice < 1) {
                list.get(index.get(sellerName)).addPrice(toothbrushPrice);
                return;
            }

            list.get(index.get(sellerName)).addPrice(myPrice);
            setPrice(seller.superSeller, superPrice);
        }

        static class Seller{
            String name;
            String superSeller;
            int totalPrice;

            public Seller(String name) {
                this.name = name;
                this.superSeller = "";
            }

            public void addSuperSeller(String name){
                superSeller = name;
            }

            public void addPrice(int price) {
                this.totalPrice += price;
            }
        }
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(Solution.solution(enroll, referral, seller, amount)));
    }
}
