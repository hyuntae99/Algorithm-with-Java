package BOJ.BOJ_10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int MAX_SIZE = 15;
        char[][] arr = new char[5][MAX_SIZE];

        String s;
        for (int i = 0; i < 5; i++) {
            s = in.readLine();
            for (int j = 0; j < MAX_SIZE; j++) {
                // 문자열 크기만큼 char 배열에 넣기
                if (s.length() > j)
                    arr[i][j] = s.charAt(j);
                    // 문자열 크기보다 크면 공백으로 넣기
                else
                    arr[i][j] = ' ';
            }
        }

        String answer = "";
        for (int j = 0; j < MAX_SIZE; j++)
            for (int i = 0; i < 5; i++)
                answer += arr[i][j];

        // 공백 제거
        System.out.println(answer.replace(" ",""));

        in.close();

    }
}
