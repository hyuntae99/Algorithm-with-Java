package BOJ_1806;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, S;
        N = sc.nextInt();
        S = sc.nextInt();

        int[] arr = new int[N]; // 배열 생성
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt(); // 배열 값 입력

        int left = 0, right = 0, sum = 0; // 좌우 인덱스 조절 변수, 부분합 변수
        int len = Integer.MAX_VALUE; // 길이

        while (true) {
            // 부분합이 S 이상일 경우
            if (sum >= S) {
                len = Math.min(len, right - left); // 길이와 현재 길이 중 작은 것을 저장
                sum -= arr[left++]; // 왼쪽의 인덱스를 한칸 조절 (왼쪽의 값을 빼준다)
            }
            // 오른쪽 인덱스 변수가 끝에 도달했을 때
            else if (right == N) {
                break; // 종료
            }
            // 부분합이 S보다 작을 때
            else {
                sum += arr[right++]; // 부분합에 arr의 다음 값을 더한다.
            }
        }

        // 과정 설명 //
        // 10 15
        // 5 1 3 5 10 7 4 9 2 8

        // 5 1 3 5 10 -> len = 5, sum = 24 / (left = 0, right = 5)
        // 1 3 5 10 -> len = 4, sum = 19 / (1, 5)
        // 3 5 10 -> len = 3, sum = 18 / (2, 5)
        // 5 10 -> len = 2, sum = 15 / (3, 5)
        // 10 7 -> len = 2, sum = 17 / (4, 6)
        // 7 4 9 -> len = 3, sum = 20 / (5, 8)
        // 4 9 2 -> len = 3, sum = 15 / (6, 9)
        // 9 2 8 -> len = 3, sum = 19 / (7, 10)


        // 길이가 변하지 않은 경우
        if (len == Integer.MAX_VALUE) {
            System.out.println(0); // 불가능하므로 0 출력
        }
        // 길이가 변했을 경우
        else {
            System.out.println(len); // 길이 출력
        }

    }
}
