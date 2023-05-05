package BOJ.BOJ_2562;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MAX_SIZE = 9;

        int index = 0;
        int max = sc.nextInt();
        for (int i = 1; i < MAX_SIZE; i++) {
            int element = sc.nextInt();
            if (max < element) {
                max = element;
                index = i;
            }
        }

        System.out.println(max + " " + (index+1));
    }
}
