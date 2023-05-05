package BOJ.BOJ_2480;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int third = sc.nextInt();

        int answer = 0;
        if (first == second && second == third)
            answer = 10000 + (first * 1000);
        else if (first == second)
            answer = 1000 + (first * 100);
        else if (first == third)
            answer = 1000 + (first * 100);
        else if (second == third)
            answer = 1000 + (second * 100);
        else {
            int max = Math.max(first, second);
            answer = Math.max(max, third) * 100;
        }

        System.out.println(answer);

    }
}
