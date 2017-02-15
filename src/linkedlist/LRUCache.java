package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by magiclane on 13/02/2017.
 */
public class LRUCache {

    private static class Entry {
        int key, value;
        Entry pre, next;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, Entry> cache = new HashMap<>();
    Entry head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        } else {
            Entry e = cache.get(key);
            if (e != head) {
                remove(e);
                setHead(e);
            }
            return e.value;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Entry e = cache.get(key);
            e.value = value;
            remove(e);
            setHead(e);
        } else {
            Entry e = new Entry(key, value);
            cache.put(key, e);
            setHead(e);
            if (cache.size() > capacity) {
                cache.remove(tail.key);
                remove(tail);
            }
        }
    }

    private void setHead(Entry e) {
        e.next = head;
        e.pre = null;

        if (head != null) {
            head.pre = e;
        }
        head = e;
        if (tail == null) {
            tail = head;
        }

    }

    private void remove(Entry e) {
        if (e.pre != null) {
            e.pre.next = e.next;
        }

        if (e.next == null) {
            tail = e.pre;
        } else {
            e.next.pre = e.pre;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Entry h = head;
        while (h != null) {
            stringBuilder.append(h.key).append(",");
            h = h.next;
        }
        String keys = cache.keySet().toString();
        return stringBuilder.toString() + ". keys:" + keys;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 3 /* capacity */ );

        /**
         * ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
         [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
         */
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache);
        System.out.println(cache.get(4));
        System.out.println(cache);
        System.out.println(cache.get(5));
        System.out.println(cache);
    }
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
