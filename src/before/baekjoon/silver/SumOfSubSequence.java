package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSubSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int S = Integer.parseInt(s[1]);

        String[] num = reader.readLine().split(" ");
        int[] number = new int[N];

        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(num[i]);
        }

        int result = dfs(number, 0, 0, S);

        System.out.println(S == 0 ? result-1 : result);
    }

    private static int dfs(int[] number, int index, int sum, int criteriaValue) {
        return index == number.length ?
                (sum == criteriaValue ? 1 : 0) :
                dfs(number, index + 1, sum + number[index], criteriaValue) +
                dfs(number, index + 1, sum, criteriaValue);
    }
}
