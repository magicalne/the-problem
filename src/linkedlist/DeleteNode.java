package linkedlist;

/**
 * Created by magiclane on 06/11/2016.
 * 2.3
 */
public class DeleteNode {
    boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }

        Node tmp = n.next;
        n.next = tmp.next;
        n.data = tmp.data;

        return true;
    }
}
