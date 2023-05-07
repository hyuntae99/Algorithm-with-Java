package BOJ.BOJ_12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 이진 탐색 구현
    public static int binarySearch(int[] increase, int left, int right, int value) {
        while (left <= right) {
            int mid = (left + right) / 2;
            // 중간 값이 목표 값보다 작으면
            if (increase[mid] < value)
                left = mid + 1; // left 증가
            // 중간 값이 목표 값보다 크면
            else if (increase[mid] > value)
                right = mid - 1; // 오른쪽 감소
            // 중간 값과 목표 값이 일치한다면
            else
                return mid; // 인덱스 바로 반환
        }
        // 못 찾았을 경우 일반적으로 -1을 출력하지만
        // 위치를 알아야하기 때문에 left 값을 음수로 출력함
        return -left; // increase[left] -> value, 바로 이전 값 인덱스 = left
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력 받을 숫자의 개수

        // 입력받은 숫자를 저장할 배열
        int[] a = new int[N];
        // 증가하는 부분 수열을 저장할 배열
        int[] increase = new int[N];
        // increase 배열의 길이를 저장하는 변수
        int len = 0;

        // 공백으로 구분된 문자열을 입력받기 위한 StringTokenizer 객체 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // 문자열을 숫자로 변환하여 a 배열에 저장
            a[i] = Integer.parseInt(st.nextToken());

            // increase 배열이 비어있거나, 현재 값이 가장 큰 값인 경우
            if (len == 0 || increase[len - 1] < a[i]) {
                increase[len++] = a[i]; // increase 배열에 현재 값을 추가하고, len을 1 증가시킴
            } else { // 이분 탐색으로 자리를 찾아서 값 삽입
                // 이분 탐색으로 a[i]가 삽입될 위치를 찾음
                int idx = binarySearch(increase, 0, len-1, a[i]);
                // idx가 음수인 경우 == 삽입될 위치를 찾지 못한 경우
                if (idx < 0) {
                    idx = -idx; // idx의 부호를 바꾼 후 삽입될 위치를 구함
                }
                increase[idx] = a[i]; // increase 배열의 idx 위치에 a[i] 값을 삽입
            }
        }

        System.out.println(len); // increase 배열의 길이를 출력
    }
}

// 기존의 라이브러리 활용해도 좋음!
// int idx = Arrays.binarySearch(increase, 0, len, a[i]);
// if (idx < 0)
//      idx = -idx - 1; // idx의 부호를 바꾼 후 -1
