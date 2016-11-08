package linkedlist;

/**
 * Created by magiclane on 08/11/2016.
 *
 * 2.6
 */
public class FindStartNode {
    private Node findStartNode(Node n) {
        Node slow = n, fast = n;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null; //no circle
        }

        slow = n;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node a = new Node(0);
        Node b = new Node(1);
        a.next = b;
        Node c = new Node(4);
        b.next = c;
        Node d = new Node(5);
        Node e = new Node(6);
        c.next = d;
        d.next = e;
        e.next = c;

        FindStartNode findStartNode = new FindStartNode();
        System.out.println(findStartNode.findStartNode(a).data);
    }
}
