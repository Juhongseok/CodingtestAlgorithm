package current.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableHashFunction {

    static class Solution {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            Table table = new Table(data, col);

            return table.hash(row_begin, row_end);
        }
    }

    static class Table {
        private List<Row> rows;

        public Table(int[][] data, int targetColumn) {
            List<Row> rows = new ArrayList<>();
            for (int[] d : data) {
                rows.add(new Row(d[0], d[targetColumn - 1], d));
            }
            Collections.sort(rows);

            this.rows = rows;
        }

        public int hash(int from, int to) {
            int answer = 0;

            for (int i = from - 1; i < to; i++) {
                answer ^= rows.get(i).getSValue(i + 1);
            }

            return answer;
        }

    }

    static class Row implements Comparable<Row> {
        private int primaryKey;
        private int sortedValue;
        private List<Integer> rowValues;

        public Row(int primaryKey, int sortedValue, int[] rowValues) {
            this.primaryKey = primaryKey;
            this.sortedValue = sortedValue;
            List<Integer> temp = new ArrayList<>();
            for (int rowValue : rowValues) {
                temp.add(rowValue);
            }
            this.rowValues = temp;
        }

        public int getSValue(int modular) {
            return rowValues.stream()
                    .map(value -> value % modular)
                    .reduce(0, Integer::sum);
        }

        @Override
        public int compareTo(Row other) {
            if (sortedValue == other.sortedValue) {
                return other.primaryKey - primaryKey;
            }

            return sortedValue - other.sortedValue;
        }

    }

    public static void main(String[] args) {
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        int col = 2;
        int rowBegin = 2;
        int rowEnd = 3;

        Solution solution = new Solution();
        System.out.println(solution.solution(data, col, rowBegin, rowEnd));
    }

}
