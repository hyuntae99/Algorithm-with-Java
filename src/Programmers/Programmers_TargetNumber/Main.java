package Programmers.Programmers_TargetNumber;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 배열의 크기
        int [] numbers = new int[N];
        for (int i = 0; i < N; i++)
            numbers[i] = sc.nextInt(); // 배열의 원소
        int target = sc.nextInt(); // 타겟

        System.out.println(sol.solution(numbers, target));

    }
}

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        // 함수 실행
        dfs(numbers, target, 0, 0);

        return answer;
    }

    // dfs 재귀 함수
    private void dfs(int[] numbers, int target, int L, int sum) {
        // System.out.println("dfs(numbers," +target+","+ L + "," + sum +")"); // 함수 호출 순서 파악 용

        // 인덱스가 마지막에 도달했을 때
        if (L == numbers.length) {
            // 타겟이 sum과 같다면
            if (target == sum) {
                answer++; // 가능 횟수 증가
            }
            return; // 종료
        }

        dfs(numbers, target, L + 1, sum + numbers[L]);
        dfs(numbers, target, L + 1, sum - numbers[L]);

    }
}
