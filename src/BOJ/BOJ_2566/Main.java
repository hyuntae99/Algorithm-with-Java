package BOJ.BOJ_2566;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MAX_SIZE = 9;

        int[][] arr = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) // 행
            for (int j = 0; j < MAX_SIZE; j++) // 열
                arr[i][j] = sc.nextInt();

        int row = 0; // 행
        int col = 0; // 열
        int max = arr[0][0];
        for (int i = 0; i < MAX_SIZE; i++)
            for (int j = 0; j < MAX_SIZE; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        System.out.println(max);
        System.out.println((row+1) + " " + (col+1));
    }
}
