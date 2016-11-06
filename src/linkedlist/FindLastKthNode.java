package linkedlist;

/**
 * Created by magiclane on 06/11/2016.
 *
 * 2.2
 */
public class FindLastKthNode {
    private Node findLastKthNode(Node linkedList, int k) {
        int count = 1;
        Node n = linkedList, f = linkedList;
        while (f.next != null) {
            n = n.next;
            f = f.next;
            count ++;
            if (f.next != null) {
                f = f.next;
                count ++;
            }
        }

        if (k > count) return null;

        if (k >= count >> 1) {
            Node tmp = linkedList;
            for (int i = 0; i < count - k; i++) {
                tmp = tmp.next;
            }
            return tmp;
        } else {
            int range = (count % 2 == 0) ? (count / 2) : (count / 2 - 1);
            for (int i = 0; i < range; i++) {
                n = n.next;
            }
            return n;
        }
    }

    private Node findKthNode2(Node n, int k) {
        //k starts from 1
        Node p1 = n, p2 = n;
        for (int i = 0; i < k - 1; i++) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        Node linkedList = new Node(0);
        linkedList.appendToTail(1);
        linkedList.appendToTail(2);
        linkedList.appendToTail(3);
        linkedList.appendToTail(4);
        linkedList.appendToTail(5);
        linkedList.appendToTail(6);
        linkedList.appendToTail(7);
        linkedList.appendToTail(8);
//        linkedList.appendToTail(9);

        FindLastKthNode findLastKthNode = new FindLastKthNode();

        System.out.println(findLastKthNode.findKthNode2(linkedList, 1   ));
    }
}
