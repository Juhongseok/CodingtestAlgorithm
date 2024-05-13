package current.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DivideTestRoom {

    static class Solution {
        public int solution(int k, int[] num, int[][] links) {
            List<Node> testRooms = Arrays.stream(num)
                    .mapToObj(j -> new Node(j, null, null))
                    .toList();

            int root = IntStream.range(0, num.length).sum();
            for (int i = 0; i < links.length; i++) {
                Node node = testRooms.get(i);
                if (links[i][0] != -1) {
                    node.addLeftChild(testRooms.get(links[i][0]));
                    root -= links[i][0];
                }
                if (links[i][1] != -1) {
                    node.addRightChild(testRooms.get(links[i][1]));
                    root -= links[i][1];
                }
            }

            Node rootNode = testRooms.get(root);
            int total = Arrays.stream(num).sum();
            int left = total / k;
            int right = total;

            while (left <= right) {
                System.out.println("--------------------------");
                System.out.println("left = " + left);
                System.out.println("right = " + right);
                int mid = (left + right) / 2;
                if (rootNode.check(mid, k)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }

        class Node {
            private int participationCount;
            private Node leftChild;
            private Node rightChild;

            public Node(int participationCount, Node leftChild, Node rightChild) {
                this.participationCount = participationCount;
                this.leftChild = leftChild;
                this.rightChild = rightChild;
            }

            public boolean hasLeftChild() {
                return leftChild != null;
            }

            public boolean hasRightChild() {
                return rightChild != null;
            }

            public void addLeftChild(Node node) {
                this.leftChild = node;
            }

            public void addRightChild(Node node) {
                this.rightChild = node;
            }

            public boolean check(int mid, int k) {
                if (hasLeftChild()) {
                    int cutCount = leftChild.getCutCount(mid);
                    System.out.println("left cutCount = " + cutCount);
                    k -= cutCount;
                }

                if (hasRightChild()) {
                    int cutCount = rightChild.getCutCount(mid);
                    System.out.println("right cutCount = " + cutCount);
                    k -= cutCount;
                }

                return k == 1;
            }

            private int getCutCount(int mid) {
                int leftChildCount = 0;
                int rightChildCount = 0;
                if (hasLeftChild()) {
                    leftChildCount = leftChild.getSum(mid);
                }

                if (hasRightChild()) {
                    rightChildCount = rightChild.getSum(mid);
                }
                System.out.println("leftChildCount = " + leftChildCount);
                System.out.println("rightChildCount = " + rightChildCount);
                if (leftChildCount + rightChildCount + participationCount < mid) {
                    return 0;
                }

                return 1;
            }

            private int getSum(int mid) {
                int leftChildSum = 0;
                int rightChildSum = 0;
                if (hasLeftChild()) {
                    leftChildSum = leftChild.getSum(mid);
                }

                if (hasRightChild()) {
                    rightChildSum += rightChild.getSum(mid);
                }

                if (leftChildSum + rightChildSum + participationCount > mid) {
                    getCutCount(mid);
                }

                return leftChildSum + rightChildSum + participationCount;
            }

        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] num = {12, 30, 1, 8, 8, 6, 20, 7, 5, 10, 4, 1};
        int[][] links = {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {8, 5}, {2, 10}, {3, 0}, {6, 1}, {11, -1}, {7, 4}, {-1, -1}, {-1, -1}};

        Solution solution = new Solution();
        System.out.println(solution.solution(k, num, links));
    }

}
