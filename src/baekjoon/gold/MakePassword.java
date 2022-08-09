package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakePassword {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int L = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);

        String[] p = reader.readLine().split(" ");
        String[] password = new String[C];

        for (int i = 0; i < C; i++) {
            password[i] = p[i];
        }

        Arrays.sort(password);
        dfs(password, 0, 0, new ArrayList<>(), L);
    }

    private static void dfs(String[] password, int index, int start, List<String> word, int L) {
        if (index == L) {
            if (isValid(word, L)) {
                word.stream().forEach(w -> System.out.print(w));
                System.out.println();
            }
            return;
        }

        for (int i = start; i < password.length; i++) {
            if (!word.contains(password[i])) {
                word.add(password[i]);
                dfs(password, index + 1, i + 1, word, L);
                word.remove(password[i]);
            }
        }
    }

    private static boolean isValid(List<String> word, int L) {
        int count = 0;
        for (String s : word) {
            if (s.matches("a|e|i|o|u")) {
                count++;
            }
        }
        return count >= 1 && count <= L-2;
    }
}