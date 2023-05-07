package Programmers.Programmers_FindDecimal;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839


import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();

        Solution sol = new Solution();
        System.out.println("answer: " + sol.solution(numbers));
    }
}

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>(); // 중복 제거를 위해 HashSet 사용
        permutation("", numbers, set); // 모든 순열 생성

        // 중복이 제거된 모든 순열을 소수 판별
        for(int num : set) {
            System.out.println(num);
            if(isDecimal(num)) // 소수 판별
                answer++; // 소수 찾으면 증가
        }

        return answer;
    }

    // 순열 생성 메소드
    public void permutation(String preStr, String str, HashSet<Integer> set) {
        int n = str.length();

        if(!preStr.equals(""))
            set.add(Integer.valueOf(preStr));
            // 만들어진 숫자 저장 (정수형으로 변환되면서 0으로 시작하는 수 없어짐)

        // 재귀적으로 순열 생성
        for(int i = 0; i < n; i++)
            permutation(preStr + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        // preStr에 현재 선택한 숫자를 더하고, str에서 현재 선택한 숫자를 제외한 문자열로 재귀호출
    }

    // 소수 판별 메소드 (에라토스테네스의 체)
    public boolean isDecimal(int num) {
        // 0과 1은 소수가 아님
        if(num == 0 || num == 1)
            return false;
        // 2부터 해당 숫자의 제곱근까지 나누어 떨어지는지 확인
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0)
                return false; // 나누어 떨어지면 소수가 아님
        }
        return true; // 나누어 떨어지는 경우가 없으면 소수
    }
}
