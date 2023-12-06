package before.programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Network {

    static class Solution {
        public static int solution(int n, int[][] computers) {
            int answer = 0;

            List<Computer> computerList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                computerList.add(new Computer(i));
            }

            for (int i = 0; i < computers.length; i++) {
                for (int j = 0; j < computers[i].length; j++) {
                    if (i != j && computers[i][j] == 1) {
                        computerList.get(i).addLinkedComputer(computerList.get(j));
                    }
                }
            }

            for (int i = 0; i < computerList.size(); i++) {
                if (computerList.get(i).canGo()) {
                    check(i, computerList);
                    answer++;
                }
            }

            return answer;
        }

        public static void check(int index, List<Computer> computerList){
            computerList.get(index).isVisit = true;
            for (Computer linkedComputer : computerList.get(index).linkedComputer) {
                if (linkedComputer.canGo())
                    check(linkedComputer.index, computerList);
            }
        }

        static class Computer{
            int index;
            boolean isVisit;
            List<Computer> linkedComputer = new ArrayList<>();

            public Computer(int index) {
                this.index = index;
                this.isVisit = false;
            }

            public void addLinkedComputer(Computer computer) {
                this.linkedComputer.add(computer);
            }

            public boolean canGo(){
                return !isVisit;
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(Solution.solution(n, computers));
    }
}
