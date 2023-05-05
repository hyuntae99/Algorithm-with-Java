package BOJ.BOJ_2884;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = 0, M = 0;
        H = sc.nextInt();
        M = sc.nextInt();

        int gap = M - 45;
        if (gap < 0) {
            H -= ((gap/60)+1);
            M = 60 + gap;
        }
        else
            M = gap;

        if (H < 0)
            H = 24 + H;

        System.out.println(H + " " + M);
    }
}
