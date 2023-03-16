package baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GenerateBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = st.nextToken();
        }

        Arrays.sort(numbers, (x, y) -> (y + x).compareTo(x + y));
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(numbers));
        for (String number : numbers) {
            sb.append(number);
        }
        System.out.println(sb.charAt(0) == '0' ? 0 : sb);
    }
}
