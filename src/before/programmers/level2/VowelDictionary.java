package before.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {
    static class Solution {
        static List<String> list = new ArrayList<>();
        static void dfs(StringBuilder sb) {
            if(sb.length() > 5) return;
            list.add(sb.toString());
            for(int i = 0; i < 5; i++){
                dfs(sb.append("AEIOU".charAt(i)));
                sb.delete(sb.length() - 1, sb.length());
            }
        }
        public static int solution(String word) {
            dfs(new StringBuilder());
            return list.indexOf(word);
        }
    }

    public static void main(String[] args) {
        String word = "I";
        System.out.println(Solution.solution(word));
    }
}
