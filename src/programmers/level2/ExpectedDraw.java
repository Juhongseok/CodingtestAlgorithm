package programmers.level2;

public class ExpectedDraw {
    static class Solution
    {
        public static int solution(int n, int a, int b)
        {
            int answer = 0;

            double participant1 = (double)a;
            double participant2 = (double)b;

            while(Math.ceil(participant1/2) != Math.ceil(participant2/2)){
                participant1 = participant1/2;
                participant2 = participant2/2;
                answer++;
            }

            return answer+1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(8,4,7));
    }
}
