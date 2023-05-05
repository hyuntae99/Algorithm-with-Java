package Programmers.Programmers_RecommendID;

import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/72410

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println(sol.solution(sc.nextLine()));

    }
}

class Solution {
    public String solution(String new_id) {
        // regex(정규식)

        // Step 1: 대문자를 소문자로 변환
        new_id = new_id.toLowerCase();
        // 소문자로 변환

        // Step 2: 알파벳 소문자, 숫자, '-', '_', '.' 이외의 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        // 소문자(a-z), 숫자(0-9),-, _, . 을 제외한 나머지 제거  ([^ ]: 제외)

        // Step 3: '.'가 2번 이상 연속된 부분을 하나의 '.'로 치환
        new_id = new_id.replaceAll("[.]{2,}", ".");
        // [.]이 2번 이상 {2,} -> . 으로 변환

        // Step 4: '.'가 처음이나 끝에 위치하면 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        // ^[.] : 시작문자가 . 이거나 [.]$ : 끝 문자가 . 일 때

        // Step 5: 빈 문자열일 경우 "a"로 대체
        if (new_id.isEmpty())
            new_id = "a";


        // Step 6: 길이가 16자 이상이면, 첫 15개의 문자 이외의 문자들을 제거
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", ""); // [.]$ 마지막에 . 이 있으면 제거
        }

        // Step 7: 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 붙임
        while (new_id.length() < 3)
            new_id += new_id.charAt(new_id.length() - 1);

        return new_id;
    }
}
