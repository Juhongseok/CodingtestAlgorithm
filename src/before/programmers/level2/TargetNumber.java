package before.programmers.level2;


public class TargetNumber {
    static class Result {
        public static int solution(int[] numbers, int target) {
            return calc(numbers, 0, 0, target);
        }

        private static int calc(int[] numbers, int index, int result, int target) {
            if (index == numbers.length) {
                return target == result ? 1 : 0;
            }
            return calc(numbers, index + 1, result + numbers[index], target)
                    + calc(numbers, index + 1, result - numbers[index], target);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(Result.solution(numbers, target));
    }
}
