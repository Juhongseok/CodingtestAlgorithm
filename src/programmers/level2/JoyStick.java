package programmers.level2;

public class JoyStick {
    static class Solution {
        public static int solution(String name) {
            int answer = 0;

            int len = name.length();
            int move = len-1;

            for(int i=0; i<len; ++i){
                answer += getHowManyMove(name.charAt(i));
                int index = i + 1;
                while(index < len && name.charAt(index) == 'A'){
                    index++;
                }

                move = Math.min(move, i * 2 + len - index);
                move = Math.min(move, (len - index) * 2 + i);
            }
            return answer + move;
        }

        public static int getHowManyMove(char nameSpell){
            return Math.min(nameSpell-'A', 'Z'-nameSpell+1);
        }
    }

    public static void main(String[] args) {
        String name = "JEROEN";
        System.out.println(Solution.solution(name));
    }
}
