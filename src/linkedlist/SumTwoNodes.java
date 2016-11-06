package linkedlist;

/**
 * Created by magiclane on 06/11/2016.
 *
 * 2.4
 */
public class SumTwoNodes {

    private Node sumTwoNodes1(Node n1, Node n2) {
        if (n1 == null || n2 == null) return null;

        int sum;
        int t = 0;
        Node result = new Node(0);
        Node p = result;

        while (n1 != null || n2 != null) {
            if (n1 != null && n2 != null) {
                sum = n1.data + n2.data + t;
                n1 = n1.next;
                n2 = n2.next;
            } else if (n1 != null) {
                sum = n1.data + t;
                n1 = n1.next;
            } else {
                sum = n2.data + t;
                n2 = n2.next;
            }
            t = sum / 10;
            p.next = new Node(sum % 10);
            p = p.next;

        }

        if (t != 0) {
            p.next = new Node(1);
        }
        return result.next;
    }

    private Node sumTwoNodes2(Node n1, Node n2) {
        if (n1 == null || n2 == null) return null;

        int count = 0;
        Node result = new Node(0);
        Node p = result;
        while (n1 != null) {
            p.next = new Node(n1.data + n2.data);
            n1 = n1.next;
            n2 = n2.next;
            count ++;
            p = p.next;
        }
        boolean over = false;
        for (int i = count; i > 0; i--) {
            p = result;
            for (int j = i; j > 0; j--) {
                p = p.next;
            }
            int sum = p.data + (over ? 1 : 0);
            over = (sum / 10) != 0;
            p.data = sum % 10;
        }
        if (over) {
            result.data = 1;
            return result;
        } else {
            return result.next;
        }
    }

    Node align(Node n, int k) {
        if (k < 1) return n;
        Node result = new Node(0);
        Node p = result;
        for (int i = 0; i < k - 1; i++) {
            p.next = new Node(0);
            p = p.next;
        }
        p.next = n;
        return result;
    }

    SumWrapper addList(Node n1, Node n2) {
        if (n1 == null || n2 == null) return new SumWrapper();

        int sum = n1.data + n2.data;
        SumWrapper wrapper = addList(n1.next, n2.next);
        sum += wrapper.carry;
        int carry = sum / 10;
        Node n = new Node(sum % 10);
        n.next = wrapper.next;
        wrapper.next = n;
        wrapper.carry = carry;
        return wrapper;
    }

    Node sumTwoNodes2Recursivily(Node n1, Node n2) {
        if (n1 == null || n2 == null) return null;
        Node p1 = n1, p2 = n2;
        int c1 = 0, c2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            c1 ++;
        }

        while (p2 != null) {
            p2 = p2.next;
            c2 ++;
        }

        if (c1 > c2) {
            n2 = align(n2, c1 -c2);
        } else if (c1 < c2) {
            n1 = align(n1, c2 - c1);
        }

        SumWrapper sumWrapper = addList(n1, n2);

        if (sumWrapper.carry == 0) {
            return sumWrapper.next;
        } else {
            Node result = new Node(sumWrapper.carry);
            result.next = sumWrapper.next;
            return result;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(6);
        n1.appendToTail(1);
        n1.appendToTail(7);

        Node n2 = new Node(4);
        n2.appendToTail(9);
        n2.appendToTail(5);

        SumTwoNodes sumTwoNodes = new SumTwoNodes();
//        System.out.println(sumTwoNodes.sumTwoNodes1(n1, n2));
        System.out.println(sumTwoNodes.sumTwoNodes2Recursivily(n1, n2));
    }
}
