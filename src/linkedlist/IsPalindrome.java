package linkedlist;

/**
 * Created by magiclane on 08/11/2016.
 *
 * 2.7
 */
public class IsPalindrome {

    private Node reverseNode(Node n) {
        if (n == null || n.next == null) return n;

        Node p = n;
        Node head = new Node(n.data);
        Node pre = null;

        while (p != null) {
            Node next = p.next;
            p = p.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    private boolean isPalindrome(Node n) {
        Node r = reverseNode(n);
        System.out.println(r);
        while (n != null && r != null) {
            if (n.data != r.data) {
                return false;
            }
            n = n.next;
            r = r.next;
        }

        return n == null && r == null;
    }

    public static void main(String[] args) {
        Node node = new Node(0);
        node.appendToTail(1);
        node.appendToTail(1);
        System.out.println(node);
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(node));
    }
}
