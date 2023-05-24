import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        for (int i = 1; i < 10; i++) {
            int num = sc.nextInt();
            if (num > max)
                max = num;
        }
        System.out.println(max);
    }
}
