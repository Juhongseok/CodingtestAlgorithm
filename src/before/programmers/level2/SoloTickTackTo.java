package before.programmers.level2;

public class SoloTickTackTo {
    static class Solution {
        public static int solution(String[] board) {
            int oCount = 0;
            int xCount = 0;

            String[][] boards = new String[board.length][board.length];
            for (int i = 0; i < board.length; i++) {
                String[] s = board[i].split("");
                System.arraycopy(s, 0, boards[i], 0, s.length);
            }

            for (String[] strings : boards) {
                for (String string : strings) {
                    if (string.equals("O")) {
                        oCount++;
                    } else if (string.equals("X")) {
                        xCount++;
                    }
                }
            }

            if(xCount > oCount || oCount - xCount > 1)
                return 0;
            if(win(boards, "O") > 0 && win(boards, "X") > 0)
                return 0;
            if(win(boards, "O") > 0) {
                if(oCount == xCount)
                    return 0;
            }
            if(win(boards, "X") > 0) {
                if (oCount > xCount) {
                    return 0;
                }
            }
            return 1;
        }

        public static int win(String[][] map, String c) {
            int game = 0;
            for(int i = 0; i < 3; i++)
            {
                if (map[i][0].equals(c) && map[i][0].equals(map[i][1]) && map[i][1].equals(map[i][2])) {
                    game++;
                }
                if (map[0][i].equals(c) && map[0][i].equals(map[1][i]) && map[1][i].equals(map[2][i])) {
                    game++;
                }
            }
            if (map[0][0].equals(c) && map[0][0].equals(map[1][1]) && map[1][1].equals(map[2][2])) {
                game++;
            }
            if (map[0][2].equals(c) && map[0][2].equals(map[1][1]) && map[1][1].equals(map[2][0])) {
                game++;
            }
            return game;
        }

    }

    public static void main(String[] args) {
//        String[] board = {"O.X", ".O.", "..X"};
//        String[] board = {"...", ".X.", "..."};
        String[] board = {"OOO", "...", "XXX"};
        System.out.println(Solution.solution(board));
    }
}
