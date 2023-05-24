package Programmers.Programmers_MBTI;

import java.util.HashMap;
import java.util.Map;


// 프로그래머스 성격 유형 검사
// https://school.programmers.co.kr/learn/courses/30/lessons/118666


public class Main {
    public static void main(String[] args) {

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        Solution sol = new Solution();
        System.out.println(sol.solution(survey, choices));
    }
}

class Solution {
    // HashMap 선언 후 각각 키(유형)과 값(점수)를 저장한다.
    private Map<Character, Integer> typeMap = new HashMap();

    public String solution(String[] survey, int[] choices) {
        // 문자열 연산을 빠르게 하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // choices = {1,2,3,4,5,6,7}까지 0은 없으므로 0으로 설정
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

        // R/T + C/F + J/M + A/N 으로 16가지 가능
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        // typeMap에 유형 넣기
        for (int i = 0; i < types.length; i++)
            typeMap.put(types[i], 0);

        for (int i = 0; i < survey.length; i++) {
            int pos = 0;
            // 5 이상부터 두번째 단어 선택
            if (choices[i] >= 5)
                pos = 1;
            // AN
            // pos = 0 -> A
            // pos = 1 -> N

            // 위의 방식으로 키로 저장 후, 키로 점수를 불러와서 추가점수 더하기
            typeMap.put(survey[i].charAt(pos), typeMap.get(survey[i].charAt(pos)) + score[choices[i]]);
        }

        // 세트(2개씩) 비교
        for (int i = 0; i < types.length; i += 2) {
            // 앞의 문자가 점수가 높다면 앞을 추가!
            if (typeMap.get(types[i]) >= typeMap.get(types[i + 1]))
                sb.append(types[i]);
            else // // 뒤의 문자가 점수가 높다면 뒤를 추가!
                sb.append(types[i + 1]);
        }
        // 합쳐서 반환
        return sb.toString();
    }
}

