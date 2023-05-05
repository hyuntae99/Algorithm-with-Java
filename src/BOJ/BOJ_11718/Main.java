package BOJ.BOJ_11718;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        while ((s = in.readLine()) != null && !s.isEmpty()) {
            out.write(s+"\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}

