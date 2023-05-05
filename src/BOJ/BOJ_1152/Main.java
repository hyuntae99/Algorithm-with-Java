package BOJ.BOJ_1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = in.readLine()) != null && !s.isEmpty()) {
            // 문장이 끝날 때는 공백이 아니기 때문
            int word_count = 1;
            s = s.trim(); // 앞뒤 공백 제거
            // 공백으로만 이루어진 경우
            if (s.isEmpty()) {
                System.out.println(0);
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == ' ')
                        word_count++;
                }
                System.out.println(word_count);
            }
        }
        in.close();
    }
}
