package before.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreaseSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] subSequence = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        subSequence[0] = numbers[0];
        int length = 1;

        for (int i = 1; i < n; i++) {
            int number = numbers[i];

            if (subSequence[length - 1] < number) {
                subSequence[length++] = number;
            } else {
                int start = 0;
                int end = length;

                while (start < end) {
                    int mid = (start + end) / 2;

                    if (subSequence[mid] < number) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                subSequence[start] = number;
            }
        }
        System.out.println(length);
    }
}
