package BOJ_2525;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int hour,min;
        hour = sc.nextInt();
        min = sc.nextInt();

        int plus;
        plus = sc.nextInt();

        hour += (min + plus) / 60;
        hour = hour % 24;
        min = (min + plus) % 60;

        System.out.println(hour + " " + min);
    }
}
