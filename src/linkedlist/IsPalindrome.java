package linkedlist;

import java.util.Stack;

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

    private boolean isPalindrome2(Node n) {
        if (n == null || n.next == null) return true;

        Node p1 = n, p2 = n;
        int len = 1;
        while (p1.next != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2.next != null) {
                p2 = p2.next;
                len ++;
            }
            len ++;
        }

        Stack<Integer> stack = new Stack<>();
        if (len % 2 != 0) {
            p1 = p1.next;
        }

        while (p1 != null) {
            stack.push(p1.data);
            p1 = p1.next;
        }

        p2 = n;
        while (!stack.empty()) {
            if (stack.pop() != p2.data) {
                return false;
            }
            p2 = p2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Node node = new Node(0);
        node.appendToTail(1);
        node.appendToTail(0);
        node.appendToTail(0);
        System.out.println(node);
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome2(node));
    }
}
