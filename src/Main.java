// 클래스 생성
class MyClass {
    // 멤버 변수
    private int number;

    // 생성자
    public MyClass(int number) {
        this.number = number;
    }

    // 멤버 메서드
    public int getNumber() {
        return number;
    }

    // 나누기 메서드
    public double divide(double a) throws Exception {
        if (a == 0)
            throw new Exception("Cannot divide by zero");
        return number / a;
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass(123); // 객체 생성

        int[] arr =  {10, 0};
        // 123/10 = 12.3, 123/0 = x
        for (Integer num : arr) {
            try {
                System.out.println(obj.getNumber() + " / " + num + " = " + obj.divide(num));
            } catch (Exception ex) {
                System.out.println(obj.getNumber() + " / " + num + " is " + ex.getMessage());
            }
        }
    }
}