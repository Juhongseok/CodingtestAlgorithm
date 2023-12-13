package current.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGBDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int houseCount = Integer.parseInt(reader.readLine());

        int[][] rgb = new int[houseCount + 1][3];

        for (int i = 1; i <= houseCount; i++) {
            String rgbExpense = reader.readLine();
            String[] expense = rgbExpense.split(" ");
            rgb[i][0] = Math.min(rgb[i - 1][1], rgb[i - 1][2]) + Integer.parseInt(expense[0]);
            rgb[i][1] = Math.min(rgb[i - 1][0], rgb[i - 1][2]) + Integer.parseInt(expense[1]);
            rgb[i][2] = Math.min(rgb[i - 1][0], rgb[i - 1][1]) + Integer.parseInt(expense[2]);
        }

        System.out.println(Math.min(rgb[houseCount][0], Math.min(rgb[houseCount][1], rgb[houseCount][2])));
    }

}
