package before.programmers.level3;

public class IntegerTriangle {
    static class Solution {
        public static int solution(int[][] triangle) {
            int answer = 0;
            Point[][] points = new Point[triangle.length][];

            for (int i = 0; i < triangle.length; i++) {
                points[i] = new Point[triangle[i].length];
                for (int j = 0; j < triangle[i].length; j++) {
                    points[i][j] = new Point(triangle[i][j], 0);
                }
            }

            points[0][0].changeValue = points[0][0].basicValue;
            for (int i = 0; i < points.length - 1; i++) {
                for (int j = 0; j < points[i].length; j++) {
                    points[i + 1][j].changeValue = Math.max(points[i + 1][j].changeValue, points[i + 1][j].basicValue + points[i][j].changeValue);
                    points[i + 1][j + 1].changeValue = Math.max(points[i + 1][j + 1].changeValue, points[i + 1][j + 1].basicValue + points[i][j].changeValue);
                }
            }

            for (Point point : points[points.length - 1]) {
                answer = Math.max(answer, point.changeValue);
            }
            return answer;
        }

        static class Point {
            int basicValue;
            int changeValue;

            public Point(int basicValue, int changeValue) {
                this.basicValue = basicValue;
                this.changeValue = changeValue;
            }
        }
    }

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(Solution.solution(triangle));
    }
}
