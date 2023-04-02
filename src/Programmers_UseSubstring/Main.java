package Programmers_UseSubstring;

import java.util.Scanner;

// 프로그래머스 문자열 압축 문제
// https://school.programmers.co.kr/learn/courses/30/lessons/60057

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        s = sc.nextLine();

        int answer = s.length(); // 압축을 못하면 원래 길이 출력

        // i는 문자열 단위
        // ex) i=1 -> 3a / i=3 -> 4abc
        for (int i = 1; i <= s.length()/2; i++) {
            StringBuilder list = new StringBuilder(); // 문자열 연산 효율을 위해
            String prev = s.substring(0,i); // 이전 문자열
            int count = 1; // 문자열 카운트

            // 완전탐색 -> 문자열 단위(= i)만큼 증가
            for (int j = i; j <= s.length(); j+=i) {
                String next = "";
                // i+j가 문자열 크기 보다 크다면
                if (i+j > s.length()){
                    next = s.substring(j,s.length()); // 남아있는 모든 문자열 추가
                    if (count > 1) {
                        list.append(count); // 숫자 추가
                    }
                    list.append(prev); // 이전 문자열 추가
                    list.append(next); // 딱 맞아 떨어지면 ""이 추가되고 아니면 남아있는 모든 문자열 추가
                } else { // i+j가 문자열 크기 이내 라면
                    next = s.substring(j, j+i); // prev 다음 요소부터 문자열 단위(i)만큼
                    if (prev.equals(next)) { // prev와 next가 같다면
                        count++; // 문자열 카운트 증가
                    } else { // 다르다면
                        if (count > 1) { // 중복이 된다면
                            list.append(count); // 숫자 추가
                        }
                        list.append(prev); // 이전 문자열 배열 추가

                        prev = next; // 비교대상을 다음으로
                        count = 1; // 중복 카운드 초기화
                    }
                }
            }
            // answer(원래 문자열 길이)보다 작으면 최신화
            if (answer > list.length())
                answer = list.length();
        }

        System.out.println(answer);
    }
}