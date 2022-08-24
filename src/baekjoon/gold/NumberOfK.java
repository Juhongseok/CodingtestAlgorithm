package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int K = Integer.parseInt(reader.readLine());

        long start = 1;
        long end = K;

        while(start < end) {

            long mid = (start + end) / 2;
            long count = 0;

            for(int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if(K <= count) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
