package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OperationInterleave {

    private static int[] number;
    private static int[] operation;
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(reader.readLine());

        number = new int[N];
        operation = new int[4];

        String[] numberInput = reader.readLine().split(" ");
        for (int i = 0; i < numberInput.length; i++) {
            number[i] = Integer.parseInt(numberInput[i]);
        }

        String[] operationInput = reader.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(operationInput[i]);
        }

        System.out.println(Arrays.toString(number));
        System.out.println(Arrays.toString(operation));

        dfs(number[0],1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int number, int index) {
        if (index == N) {
            MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;
                switch (i) {
                    case 0:	dfs(number + OperationInterleave.number[index], index + 1);
                        break;
                    case 1:	dfs(number - OperationInterleave.number[index], index + 1);
                        break;
                    case 2:	dfs(number * OperationInterleave.number[index], index + 1);
                        break;
                    case 3:	dfs(number / OperationInterleave.number[index], index + 1);
                        break;
                }
                operation[i]++;
            }
        }
    }
}
