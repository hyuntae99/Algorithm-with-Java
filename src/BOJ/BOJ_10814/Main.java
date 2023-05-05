package BOJ.BOJ_10814;

import java.util.*;

// 멤버 클래스
class Member{
    int age;
    String name;
    int index;

    // 생성자
    public Member (int age, String name, int index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }
}

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N 입력 받은 후
        Member[] members = new Member[N]; // N 만큼 멤버 배열 생성

        // 멤버 정보 받기
        for (int i = 0 ; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.nextLine();
            name = name.replace(" ","");
            members[i] = new Member(age, name, i); // index는 i로
        }

        // 나이 순으로 정렬
        Arrays.sort(members, new Comparator<Member>() {
            @Override // 오버라딩
            public int compare(Member m1, Member m2) {
                // 나이가 다르면, 나이 순으로 정렬
                if (m1.age != m2.age) {
                    return Integer.compare(m1.age, m2.age);
                }
                // 나이가 같다면, 입력된 순서(index)로 정렬
                return Integer.compare(m1.index, m2.index);
            }
        });

        // 정답 출력
        for (Member member : members)
            System.out.println(member.age + " " + member.name);
    }
}
