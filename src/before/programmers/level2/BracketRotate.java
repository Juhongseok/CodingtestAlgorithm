package before.programmers.level2;

import java.util.HashMap;
import java.util.Stack;

public class BracketRotate {
    static class Solution {
        private static HashMap<String, String> bracketMap = new HashMap<>();
        static{
            bracketMap.put("[", "]");
            bracketMap.put("]", "");
            bracketMap.put("(", ")");
            bracketMap.put(")", "");
            bracketMap.put("{", "}");
            bracketMap.put("}", "");
        }

        public static int solution(String s) {
            int answer = 0;
            for (int i = 0; i < s.length(); i++) {
                if (isCorrect(s.split(""))) {
                    answer++;
                }
                s = s.substring(1) + s.substring(0, 1);
            }
            return answer;
        }

        private static boolean isCorrect(String[] brackets) {
            Stack<String> stack = new Stack<>();
            stack.push(brackets[0]);
            for (int i = 1; i < brackets.length; i++) {
                if (!stack.isEmpty()) {
                    String before = stack.peek();
                    if (bracketMap.get(before).equals(brackets[i])) {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(brackets[i]);
            }

            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        String s = "}]()[{";
        System.out.println(Solution.solution(s));
    }
}
