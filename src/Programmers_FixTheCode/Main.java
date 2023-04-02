package Programmers_FixTheCode;


import java.util.Scanner;
import java.util.Stack;


// 프로그래머스 괄호 변환 문제
// https://school.programmers.co.kr/learn/courses/30/lessons/60058


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Solution sol = new Solution();
        System.out.println(sol.solution(s));
    }
}


class Solution {
    // 메인함수
    public String solution(String p) {
        return func(p);
    }


    // 실행 함수
    public String func (String p) {
        // 문자열이 빈 문자열일 경우, 빈 문자열 반환
        if (p.length() == 0)
            return p;

        String answer = "";
        StringBuilder sb = new StringBuilder();

        // p -> u+v분리
        String [] tmp = sep(p);
        String u = tmp[0];
        String v = tmp[1];

        // u가 올바른 괄호 문자열이라면
        if (isOK(u)) {
            // u + func(v)(v -> u+v로 분리해서 다시 판단)
            sb.append(u).append(func((v)));
        } else { // u가 올바른 괄호 문자열이 아니라면
            // ( + func(v)(v -> u+v로 분리해서 다시 판단) + ) + u 앞뒤제거 후 뒤집기
            sb.append('(').append(func(v)).append(')').append(reverse(u));
        }

        return sb.toString();
    }


    // u,v 분리함수
    // u = "균형잡힌 문자열" , v = "빈 문자열일 수도 있음"
    public String[] sep(String s) { // u,v를 반환하기 위해 String[]

        // ( = left, ) = right
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left ++;
            else {
                right++;
            }
            // ( , )의 개수가 같으면
            if (left == right) {
                String u = s.substring(0,i+1); // u에 균형잡힌 문자열
                String v = "";
                if (s.length() >= i+1) // s의 길이가 더 클 때 (오류 발생 대비)
                    v = s.substring(i+1); // v = 나머지

                return new String[] {u,v};
            }
        }
        return new String[] {"",""};
    }


    // 올바른 문자열인지 확인
    // (), (()), (()()) 같이 괄호가 감싸진 모양
    public boolean isOK (String u) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i); // 해당 인덱스의 문자

            if (c == '(')
                s.push(c); // ( 추가
            else {
                // )부터 시작될 경우, false
                if (s.isEmpty())
                    return false;
                s.pop(); // ) 추가 == ( 제거
            }
        }
        // 길이 0 == 괄호가 잘 감싸짐 -> true
        // 길이 > 0 == 괄호가 이상함 -> false
        return s.isEmpty();
    }


    // 앞뒤문자 제거 후, 남은 괄호들 뒤집기
    public String reverse(String u) {
        // 앞뒤 문자 제거
        u = u.substring(1);
        u = u.substring(0, u.length()-1);

        // 제거했는데 아무것도 없으면 빈 문자열 반환
        if (u.length() == 0)
            return "";

        // 연산을 위해 StringBuilder 선언
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            // ) -> (
            if (u.charAt(i) == ')')
                sb.append('(');
            else // ( -> )
                sb.append(')');
        }
        // 문자열 반환
        return sb.toString();
    }
}


