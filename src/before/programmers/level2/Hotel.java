package before.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

public class Hotel {
    static class Solution {
        public static int solution(String[][] bookTime) {
            List<BookInfo> books = getBookInfos(bookTime);
            return getBooksResult(books).size();
        }

        private static List<BookInfo> getBookInfos(String[][] bookTime) {
            return Arrays.stream(bookTime)
                    .map(BookInfo::new)
                    .sorted(Comparator.comparing(o -> o.startTime))
                    .collect(Collectors.toList());
        }

        private static Queue<BookInfo> getBooksResult(List<BookInfo> books) {
            Queue<BookInfo> booksResult = new PriorityQueue<>();
            booksResult.add(books.get(0));
            for (int i = 1; i < books.size(); i++) {
                BookInfo current = books.get(i);
                if (current.canIn(booksResult.peek())) {
                    booksResult.poll();
                }
                booksResult.add(current);
            }
            return booksResult;
        }

        static class BookInfo implements Comparable<BookInfo>{
            int startTime;
            int endTime;

            public BookInfo(String[] times) {
                this.startTime = toMinute(times[0]);
                this.endTime = toMinute(times[1]) + 10;
            }

            public boolean canIn(BookInfo beforeBook) {
                return this.startTime >= beforeBook.endTime;
            }
            @Override
            public int compareTo(BookInfo o) {
                return this.endTime - o.endTime;
            }

            private static int toMinute(String time) {
                String[] times = time.split(":");
                return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            }
        }
    }
    public static void main(String[] args) {
        String[][] bookTime = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(Solution.solution(bookTime));
    }
}
