package prepare;

import java.util.HashMap;
import java.util.Map;

/** 
* @author : Menghui Chen 
* @version ：2018年3月14日 下午4:30:11 
* @Description:
*/
public class LRUCache {
    public static class DLink {
        DLink before;
        DLink after;
        int value;
        int key;
    }
    int capacity;
    int size;
    Map<Integer, DLink> map;
    DLink head;
    DLink tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLink();
        this.tail = new DLink();
        head.after = tail;
        tail.before = head;
        map = new HashMap<>();
    }

    public void delete(int key, DLink node) {
        map.remove(key);
        DLink pre = node.before;
        DLink post = node.after;
        pre.after = post;
        post.before = pre;
        size--;
    }
    public void add(int key, DLink node) {
        map.put(key, node);
        DLink last = tail.before;
        last.after = node;
        node.before = last;
        node.after = tail;
        tail.before = node;
        size++;
         if (size > capacity) {
            DLink first = head.after;
            head.after = first.after;
            first.after.before = head;
            map.remove(first.key);
            size--;
        }
    }
    public int get(int key) {
        DLink cur = map.get(key);
        if (cur != null) {
            delete(key, cur);
            add(key, cur);
            return cur.value;
        }
        return -1;
    }
    public void set(int key, int value) {
        DLink cur = map.get(key);
        if (cur == null) {
            DLink node = new DLink();
            node.value = value;
            node.key = key;
            add(key, node);
        } else {
            cur.value = value;
            delete(key, cur);
            add(key, cur);
        }
    }
}