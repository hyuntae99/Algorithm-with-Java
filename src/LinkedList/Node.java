package LinkedList;

// 노드 클래스
public class Node {
    int element; // 원소
    Node next; // 다음 노드

    // 노드 선언
    public Node (int element) {
        this.element = element; // 원소
        this.next = null; // 다음 노드는 일단 비워둔다.
    }
}
