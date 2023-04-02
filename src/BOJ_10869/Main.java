package BOJ_10869;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int a, b; // 두 자연수 A, B
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt(); // int a 입력받기
        b = sc.nextInt(); // int b 입력받기

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);

    }
}