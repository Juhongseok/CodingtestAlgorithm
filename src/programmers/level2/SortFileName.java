package programmers.level2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortFileName {
    static class Solution {
        public static String[] solution(String[] files) {
            String[] answer = new String[files.length];
            List<File> list = new ArrayList<>();
            int index = 0;
            for (String file : files) {
                StringBuilder head = new StringBuilder();
                StringBuilder number = new StringBuilder();
                StringBuilder tail = new StringBuilder();
                boolean isNumberStart = false;
                for (int i = 0; i < file.length(); i++) {
                    char c = file.charAt(i);
                    if (c >= '0' && c <= '9') {
                        number.append(c);
                        isNumberStart = true;
                    }else {
                        if (!isNumberStart) {
                            head.append(c);
                        } else {
                            tail.append(file.substring(i));
                            break;
                        }
                    }
                }
                list.add(new File(index++, head, number, tail));
            }

            Collections.sort(list);
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i).getResult();
            }
            return answer;
        }
        private static class File implements Comparable<File> {
            private int index;
            private String head;
            private String number;
            private String tail;

            public File(int index, StringBuilder head, StringBuilder number, StringBuilder tail) {
                this.index = index;
                this.head = head.toString();
                this.number = number.toString();
                this.tail = tail.toString();
            }

            @Override
            public int compareTo(File f) {
                if (this.head.equalsIgnoreCase(f.head)) {
                    if (Integer.parseInt(this.number) == Integer.parseInt(f.number)) {
                        return this.index - f.index;
                    }
                    return Integer.parseInt(this.number) - Integer.parseInt(f.number);
                }
                return this.head.toLowerCase().compareTo(f.head.toLowerCase());
            }

            public String getResult() {
                return head + number + tail;
            }
        }
        public static String[] solution2(String[] files) {
            Pattern p = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");

            Arrays.sort(files, (s1, s2) -> {
                Matcher m1 = p.matcher(s1.toLowerCase());
                Matcher m2 = p.matcher(s2.toLowerCase());
                m1.find();
                m2.find();

                String file1Head = m1.group(1);
                String file2Head = m2.group(1);

                int file1Number = Integer.parseInt(m1.group(2));
                int file2Number = Integer.parseInt(m2.group(2));

                return file1Head.equals(file2Head) ? file1Number - file2Number : file1Head.compareTo(file2Head);
            });

            return files;
        }
    }

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] solution = Solution.solution2(files);
        for (String s : solution) {
            System.out.print(s + " ");
        }
    }
}
