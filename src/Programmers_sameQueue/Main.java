package Programmers_sameQueue;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/118667

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        // 길이가 같은 두 배열
        int [] queue1 = {1,2,1,2};
        int [] queue2 = {1,10,1,2};
        System.out.println(sol.solution(queue1, queue2));

    }
}

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 큐 q1, q2 생성
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // s1, s2는 각 큐의 합
        long s1 = 0, s2 = 0, sum = 0; // 오버 플로우 대비 long 사용

        // 매개변수로 받은 리스트를 큐로 변환
        for (Integer tmp : queue1) {
            q1.add(tmp);
            s1 += tmp;
        }
        for (int tmp : queue2) {
            q2.add(tmp);
            s2+=tmp;
        }

        sum = s1 + s2; // 두 큐의 합

        // 두 큐 합이 홀수이면 반으로 나누었을 때 같을 수 없으므로 (정수)
        if ((sum % 2) == 1)
            return -1; // -1 출력
        sum /= 2; // 각 큐의 목표 합

        // q1, q2의 횟수
        int num1 = 0, num2 = 0;
        // 2개의 큐가 하나의 큐로 합쳐질 때의 길이 = 더 이상 이동X
        int limit = queue1.length * 2;

        // 어느 큐의 크기가 limit과 같아질 때 까지
        while (num1 <= limit && num2 <= limit) {
            if (s1 == sum) // 양 쪽의 합이 같아졌을 때
                return num1 + num2; // q1, q2 이동 횟수를 더한 값 반환

            // s1이 sum보다 크다면
            if (s1 > sum) {
                // peek() : head의 값을 반환 (비어있으면 null 반환)
                // poll() : head의 값을 반환 후 삭제 (비어있으면 null 반환)
                s1 -= q1.peek(); // s1에 q1의 맨 앞 값 빼기
                s2 += q1.peek(); // s2에 q1의 맨 앞 값 더하기
                q2.add(q1.poll()); // q2에 q1의 맨 앞 값 추가하고 q1에서 삭제
                num1++; // q1 이동횟수 추가
            }
            // s1이 sum보다 작다면 =(s2가 sum보다 크다면)
            else {
                s2 -= q2.peek(); // s2에 q2의 맨 앞 값 빼기
                s1 += q2.peek(); // s1에 q2의 맨 앞 값 더하기
                q1.add(q2.poll()); // q1에 q2의 맨 앞 값 추가하고 q2에서 삭제
                num2++; // q2 이동횟수 추가
            }
        }
        // 끝까지 실행했지만 반반으로 나누지 못했으면 불가능하다고 판단
        return -1;
    }
}


