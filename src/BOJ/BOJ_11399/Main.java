package BOJ.BOJ_11399;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 초기 배열
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        // 배열 오름차순 정렬
        Collections.sort(list);

        // 부분합 저장 배열
        ArrayList<Integer> list_sum = new ArrayList<>();

        int sum = 0;
        for (Integer num : list) {
            sum += num; // 부분합
            list_sum.add(sum);
        }

        int answer = 0;
        for (Integer num_sum : list_sum)
            answer += num_sum;

        System.out.println(answer);
    }
}
