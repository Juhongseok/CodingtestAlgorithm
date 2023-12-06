package before.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfSequencePrime {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        List<Integer> prime = getPrimes(n);

        int left = 0;
        int right = 0;
        int count = 0;

        int sum = 0;
        System.out.println(prime);
        while (true) {
            if (sum >= n) {
                sum -= prime.get(left++);
            } else if (right == prime.size()) {
                break;
            } else if (sum < n) {
                sum += prime.get(right++);
            }

            if (sum == n) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static List<Integer> getPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        return IntStream.rangeClosed(1, n).filter(i -> !prime[i]).boxed().collect(Collectors.toList());
    }
}
