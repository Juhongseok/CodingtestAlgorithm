package before.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int counter = 0;
        for (int i = 1; i <= N; i++) {
            if (한수(i)) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    private static boolean 한수(int number) {
        if (number < 100) {
            return true;
        }
        char[] array = String.valueOf(number).toCharArray();
        int firstNumber = Integer.valueOf(String.valueOf(array[0]));
        int secondNumber = Integer.valueOf(String.valueOf(array[1]));

        int sequence = firstNumber - secondNumber;

        int beforeNumber = secondNumber;
        for (int i = 1; i < array.length-1; i++) {
            int nextNumber = Integer.valueOf(String.valueOf(array[i+1]));
            if (sequence != beforeNumber - nextNumber) {
                return false;
            }
            beforeNumber = nextNumber;
        }
        return true;
    }
}
