package Programmers_Babbling;

// 프로그래머스 옹알이 (2) 문제
// https://school.programmers.co.kr/learn/courses/30/lessons/133499


public class Main {
    public static void main(String[] args) {
        // 기본 설정
        // String[] list ={"aya", "ye", "woo", "ma"};

        // 입력 값
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa", ""};


        Solution sol = new Solution();
        System.out.println(sol.solution(babbling));

    }
}

class Solution {
    public int solution (String[] babbling) {

        int answer = 0; // 정답의 개수

        for (String word : babbling) { // 입력 문자열 리스트에서 하나씩 word에 저장
            // 연속으로 발음을 할 경우, pass
            // countains(ayaaya)의 경우, aya * N(2이상) 모두 포함
            if (word.contains("ayaaya") || word.contains("yeye") || word.contains("woowoo") || word.contains("mama")){
                continue;
            }
            // 가능한 발음을 했을 경우, 지워준다.
            // replace("a",""); 이렇게 처리하면 오류가 발생...? 왜지??
            word = word.replace("aya", "0");
            word = word.replace("ye", "0");
            word = word.replace("woo", "0");
            word = word.replace("ma", "0");
            word = word.replace("0", "");

            // 모두 지웠을 때, 발음이 가능하다고 판단.
            if (word.length() == 0)
                answer ++;

        }

    return answer;
    }
}