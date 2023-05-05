package LinkedList;

public class Main {

    // 리스트 생성
    static Node createList() {
        Node head = new Node(0); // 헤드 = 더미노드
        return head;
    }

    // 삽입 (삽입할 원소, 시작(헤드), 삽입 위치)
    static Node insert (int x, Node head, Node p) {
        // p -> null
        Node newNode = new Node(x); // 새로운 노드 생성
        newNode.next = p.next; // newNode -> null
        p.next = newNode; // p -> newNode -> null

        return newNode;
    }

    // x를 가진 노드의 이전 위치
    static Node findPrevious(int x, Node head) {
        Node p = head; // 시작 노드 (헤드 노드)

        // 노드의 다음이 없을 때까지
        while (p.next != null) {
            // 해당 원소를 찾으면
            if (p.next.element == x)
                return p;
            else
                p = p.next;
        }

        return p;
    }

    // 삭제
    static int delete(int x, Node head) {
        // 해당 노드의 전 위치를 찾은 후
        Node p = findPrevious(x, head);
        // p -> target -> p2

        if (p.next == null)
            return 0; // 해당 값이 없을 경우

        p.next = p.next.next; // p -> p2
        // 사용하지 않으면 자동 삭제! ( Garbage Collector )
        return 1;
    }

    // 찾기
    static Node find(int x, Node head) {
        Node p = head.next;

        // 노드가 없을 때까지
        while (p != null) {
            if (p.element == x)
                return p;
            else
                p = p.next;
        }

        return p;
    }

    // 리스트 출력
    static void printList(Node head) {
        Node p = head.next; // 헤드의 다음 노드

        System.out.print("DummyHead -> ");
        while (p != null) {
            System.out.print(p.element + " -> ");
            p = p.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node head = createList();

        System.out.println("#### 1. 추가 ####");
        insert(10, head, head); // 10 -> NULL
        printList(head);
        insert(5, head, head); // 5 -> 10 -> NULL
        printList(head);
        insert(15, head, head); // 15 -> 5 -> 10 -> NULL
        printList(head);

        System.out.println("\n#### 2. 삽입 ####");
        System.out.println("5의 위치를 찾고 20을 뒤에 삽입한다.");

        Node p = find(5, head); // 5의 위치를 찾고
        insert(20, head, p); // 20을 5 다음으로 연결
        printList(head); // 15 -> 5 -> 20 -> 10 -> NULL

        System.out.println("15의 위치를 찾고 45을 뒤에 삽입한다.");
        Node p2 = find(15, head); // 5의 위치를 찾고
        insert(45, head, p2); // 20을 5 다음으로 연결
        printList(head); // 15 -> 45 -> 5 -> 20 -> 10 -> NULL


        System.out.println("\n#### 3. 제거 ####");
        System.out.println("5를 제거한다.");

        delete(5, head); // 5 제거
        printList(head); // 15 -> 20 -> 10-> NULL
    }
}