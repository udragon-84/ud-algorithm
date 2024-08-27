package algorithm.test.yanolja;

public class FizzBuzz {

    public void solution(int n) {
        for (int i = 1; i <= n; i++) {
            boolean isFizz = (i % 3) == 0;
            boolean isBuzz = (i % 5) == 0;

            if (isFizz && isBuzz) {
                System.out.println("FizzBuzz");
            } else if (isFizz) {
                System.out.println("Fizz");
            } else if (isBuzz) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        int n = 15;
        fizzBuzz.solution(n);
    }

}
