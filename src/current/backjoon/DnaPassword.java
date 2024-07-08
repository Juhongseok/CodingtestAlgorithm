package current.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DnaPassword {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lengths = br.readLine().split(" ");

        int length = Integer.parseInt(lengths[0]);
        int passwordLength = Integer.parseInt(lengths[1]);

        String[] dna = br.readLine().split("");
        Map<String, Integer> check = new HashMap<>();
        String[] counts = br.readLine().split(" ");
        check.put("A", Integer.parseInt(counts[0]));
        check.put("C", Integer.parseInt(counts[1]));
        check.put("G", Integer.parseInt(counts[2]));
        check.put("T", Integer.parseInt(counts[3]));

        Map<String, Integer> newPassword = new HashMap<>();
        newPassword.put("A", 0);
        newPassword.put("C", 0);
        newPassword.put("G", 0);
        newPassword.put("T", 0);
        for(int i=0; i<passwordLength; i++) {
            newPassword.put(dna[i], newPassword.get(dna[i]) + 1);
        }

        int answer = 0;

        if(checkCount(check, newPassword)) {
            answer++;
        }

        int point;
        for(int i=passwordLength; i<length; i++) {
            point = i-passwordLength;
            newPassword.put(dna[i], newPassword.get(dna[i]) + 1);
            newPassword.put(dna[point], newPassword.get(dna[point]) - 1);

            if(checkCount(check, newPassword)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean checkCount(Map<String, Integer> check, Map<String, Integer> newPassword) {
        System.out.println("check = " + check + ", newPassword = " + newPassword);
        for(String key : check.keySet()) {
            if(check.get(key) != newPassword.get(key)) {
                return false;
            }
        }

        return true;
    }

}
