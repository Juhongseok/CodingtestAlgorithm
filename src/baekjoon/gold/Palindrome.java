package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String word = reader.readLine();

            System.out.println("word : " + word);
            sb.append(check(word, 0, word.length()-1, 0) + " \n");
        }
        System.out.println(sb);
    }

    private static int check(String word, int left, int right, int count) {
        System.out.println(" --> left = " + left + ", right = " + right + ", count = " + count);
        if (count == 2){
            return 2;
        }

        while (left < right) {
            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            } else {
                count = Math.min(check(word, left + 1, right, count + 1), check(word, left, right - 1, count + 1));
                break;
            }
        }
        return count;
    }
}
