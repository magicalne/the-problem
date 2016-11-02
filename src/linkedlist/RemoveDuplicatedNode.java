package linkedlist;

/**
 * Created by magiclane on 02/11/2016.
 *
 * 2.1
 */
public class RemoveDuplicatedNode {
    void removeDuplicatedNode(Node n) {
        if (n == null) return ;
        Node current = n;
        while (current != null) {
            Node check = current;
            while (check.next != null) {
                if (current.data == check.next.data) {
                    check.next = check.next.next;
                } else {
                    check = check.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.appendToTail(2);
        node1.appendToTail(1);
        RemoveDuplicatedNode removeDuplicatedNode = new RemoveDuplicatedNode();
        System.out.println(node1);
        System.out.println(node1);
        System.out.println("===========");
        removeDuplicatedNode.removeDuplicatedNode(node1);
        System.out.println(node1);
    }
}
