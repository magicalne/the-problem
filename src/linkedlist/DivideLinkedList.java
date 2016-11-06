package linkedlist;

/**
 * Created by magiclane on 06/11/2016.
 * 2.4
 */
public class DivideLinkedList {
    void divideLinkedList(Node n, int x) {
        if (n == null || n.next == null) return;

        Node p = n;
        while (p.next.data < x) {
            p = p.next;
        }

        Node p1 = p.next, pNext = p.next;
        while (p1.next != null) {
            if (p1.next.data < x) {
                Node tmp = p1.next; //save node
                p1.next = p1.next.next; //delete p1
                p.next = tmp; //append to end of p
                tmp.next = pNext; //set saved node's next to p.next
                p = p.next;
            } else {
                p1 = p1.next; //p1 move on
            }
        }
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.appendToTail(4);
        n.appendToTail(3);
        n.appendToTail(5);
        n.appendToTail(8);
        n.appendToTail(6);
        n.appendToTail(2);
        n.appendToTail(0);
        n.appendToTail(5);

        DivideLinkedList divideLinkedList = new DivideLinkedList();
        divideLinkedList.divideLinkedList(n, 5);
        System.out.println(n);
    }
}
