package Programmers.Programmers_Tuple;

// 프로그래머스 튜플
// https://school.programmers.co.kr/learn/courses/30/lessons/64065


import java.util.*;

public class Main {
    public static void main(String[] args) {

        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        Solution sol = new Solution();
        int[] tuple = sol.solution(s);

        System.out.println(Arrays.toString(tuple));
    }
}

class Solution {
    public int[] solution(String s) {
        // 문자열에서 {}를 모두 제거하고 ,로 분리
        String[] elements = s.replaceAll("[{}]", "").split(",");

        // 숫자의 등장 횟수를 카운트하는 Map 생성 -> 많이 등장한 숫자를 앞으로 보내줘야 하기 때문에!!
        Map<String, Integer> countMap = new HashMap<>();
        for (String element : elements) {
            // 원소가 존재하면 원소 반환, 없다면 0 반환
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);  // 카운트 +1
        }

        // tuple 리스트
        List<String> tupleList = new ArrayList<>(countMap.keySet());
        // 양수 : b > a -> b, a
        // 음수 : a > b -> a, b
        Collections.sort(tupleList, (a, b) -> countMap.get(b) - countMap.get(a));

        // 튜플의 원소들을 순서대로 배열에 저장
        int[] answer = new int[tupleList.size()];
        int index = 0;
        for (String tuple : tupleList) {
            answer[index] = Integer.parseInt(tuple);
            index++;
        }

        return answer;
    }
}

