package Programmers_MoreSpicy;

// https://school.programmers.co.kr/learn/courses/30/lessons/42626

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] scoville = new int[N];
        for (int i = 0 ; i < N; i++)
            scoville[i] = sc.nextInt();

        System.out.println(sol.solution(scoville, K));


    }
}

class Solution {
    public int solution(int[] scoville, int K){

        // 우선순위 큐 = 힙
        // 가장 작은 것부터 반환한다.
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // 힙에 배열 입력
        for (int i : scoville)
            heap.offer(i);

        int count = 0; // 횟수
        // 가장 작은 것이 K보다 클 때까지 실행
        while (heap.peek() < K) {
            // 힙의 크기가 2보다 작아지면 -> K 이상으로 만들지 못했다.
            if (heap.size() < 2)
                return -1;
            int first = heap.poll(); // 첫번째 + 힙 제거
            int second = heap.poll(); // 두번째 + 힙 제거
            int new_scoville = first + (second * 2); // 새로운 음식의 스코빌 지수
            heap.offer(new_scoville); // 힙 추가
            count ++; // 횟수 1 증가
        }

        return count;
    }
}
