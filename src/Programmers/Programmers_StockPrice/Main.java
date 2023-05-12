package Programmers.Programmers_StockPrice;

// https://school.programmers.co.kr/learn/courses/30/lessons/42584

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 가격 배열 생성 후 입력
        int prices[] = new int[N];
        for (int i = 0; i < N; i++)
            prices[i] = sc.nextInt();

        // 정답 출력
        for (int i = 0; i < N; i++)
            System.out.print(sol.solution(prices)[i] + " ");
        System.out.println();
    }
}

class Solution {
    public int[] solution(int prices[]) {
        // 각 주식의 유지 시간의 배열
        int len = prices.length;
        int times[] = new int[len];

        // int 배열의 스택 (가격, 시간)
        Stack<Integer[]> s = new Stack<>();
        // 스택 채우기
        for (int i = 0; i < prices.length; i++) {
            Integer[] tmp = {prices[i], i}; // 현재 스택
            // 스택이 비어있다면
            if (s.empty()) {
                s.push(tmp); // 바로 추가
                continue;
            }
            // 스택이 비어있지 않다면
            else {
                // 스택을 오름차순으로 만들기 위해서
                // 현재 스택보다 큰 스택이 없을 때까지
                while (s.peek()[0] > tmp[0]) {
                    // 그 시점의 시간을 times 배열에 바로 저장
                    times[s.peek()[1]] = tmp[1] - s.peek()[1];
                    s.pop(); // 저장한 스택은 제거
                    if (s.empty())
                        break;
                }
            }
            // tmp보다 큰 스택을 없애고 추가
            s.push(tmp);
        }

        // 스택이 없을 때까지
        while (!s.empty()) {
            // times 배열 = 최대크기 - 1 - 스택의 시간
            times[s.peek()[1]] = len - 1 - s.peek()[1];
            s.pop(); // 제거
        }

        return times;
    }
}