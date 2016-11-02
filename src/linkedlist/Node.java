package linkedlist;

/**
 * Created by magiclane on 02/11/2016.
 */
public class Node {
    int data;
    Node next = null;
    public Node(int data) {
        this.data = data;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Node n = this;
        while (n != null) {
            stringBuffer.append(n.data).append("->");
            n = n.next;
        }
        stringBuffer.append("null");
        return stringBuffer.toString();
    }
}
