package BOJ.BOJ_10818;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];

        int max = sc.nextInt();
        int min = max;
        for (int i = 1; i < N; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i])
                max = arr[i];
            if (min > arr[i])
                min = arr[i];
        }
        System.out.println(min + " " + max);
    }
}
