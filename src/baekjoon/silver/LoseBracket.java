package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LoseBracket {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), "-");

        int result = getSum(st.nextToken());
        while (st.hasMoreTokens()) {
            result -= getSum(st.nextToken());
        }

        System.out.println(result);
    }

    private static int getSum(String subExpression) {
        return Arrays.stream(subExpression.split("\\+"))
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
