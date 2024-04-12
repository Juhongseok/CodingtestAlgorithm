package current.programmers;

import java.util.Arrays;

public class PhoneNumbers {

    public static void main(String[] args) {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        Solution solution = new Solution();
        boolean answer = solution.solution(phoneBook);

        System.out.println("answer = " + answer);
    }

    static class Solution {

        public boolean solution(String[] phoneBook) {
            boolean answer = true;

            Arrays.sort(phoneBook);

            for (int i = 0; i < phoneBook.length - 1; ++i) {
                if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                    return false;
                }
            }

            return answer;
        }

    }

}
