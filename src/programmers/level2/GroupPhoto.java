package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class GroupPhoto {

    static class Result {
        public static int solution(int n, String[] data) {
            return dfs(data, new ArrayList<>());
        }

        private static int dfs(String[] data, List<String> list){
            String[] user = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
            int answer = 0;
            if (list.size() == user.length) {
                if (check(data, list)) {
                    return 1;
                }
            }
            for (int i = 0; i < 8; i++) {
                if (!list.contains(user[i])) {
                    list.add(user[i]);
                    answer += dfs(data, list);
                    list.remove(list.size() - 1);
                }
            }
            return answer;
        }

        private static boolean check(String[] data, List<String> list) {
            for (String d : data) {
                String user1 = String.valueOf(d.charAt(0));
                String user2 = String.valueOf(d.charAt(2));
                char operator = d.charAt(3);
                int betweenCount = d.charAt(4) - '0'+1;

                int abs = Math.abs(list.indexOf(user1) - list.indexOf(user2));
                switch (operator) {
                    case '=':
                        if(abs != betweenCount)
                            return false;
                        break;
                    case '>':
                        if(abs <= betweenCount)
                            return false;
                        break;
                    case '<':
                        if(abs >= betweenCount)
                            return false;
                        break;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(Result.solution(n, data));
    }
}
