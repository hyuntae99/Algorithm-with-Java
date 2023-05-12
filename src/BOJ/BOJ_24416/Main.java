package BOJ.BOJ_24416;

import java.util.Scanner;

public class Main {
    static int count1 = 0;
    static int count2 = 0;
    // 5 <= n <= 40
    static int[] f = new int[41];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        fib(n);
        fibonacci(n);

        // 재귀 함수 횟수, DP 횟수
        System.out.println(count1 + " " + count2);
    }

    // 피보나치 수 (재귀함수 구현)
    private static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    // 피보나치 수 (동적 프로그래밍 구현)
    private static int fibonacci(int n) {
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            count2++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
