public class LRUCache {
    static class DLinkedList {
        int key;
        int value;
        DLinkedList pre;
        DLinkedList post;
    }
    int count;
    int capacity;
    Map<Integer, DLinkedList> map;
    DLinkedList head;
    DLinkedList tail;
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>(capacity);
        head = new DLinkedList();
        tail = new DLinkedList();
        head.post = tail;
        tail.pre = head;
    }
    public void deleteNode(DLinkedList node) {
        DLinkedList post = node.post;
        DLinkedList pre = node.pre;
        pre.post = post;
        post.pre = pre;
    }
    public void deleteTail() {
        DLinkedList last = tail.pre;
        deleteNode(last);
    }
    //每次插入的结点都在head之后
    public void addNode(DLinkedList node) {
        node.pre = head;
        node.post =head.post;
        head.post = node;
        node.post.pre = node;
    }
    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        DLinkedList node = map.get(key);
        if (node != null) {
            deleteNode(node);
            addNode(node);
            return node.value;
        }
        return -1;
    }
    public DLinkedList popTail() {
        return tail.pre;
    }
    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        DLinkedList node = map.get(key);
        if (node != null) {
            deleteNode(node);
            node.value = value;
            map.put(key, node);
            addNode(node);
        } else {
            if (count < capacity) {
                count++;
            } else {
                DLinkedList tail = popTail();
                map.remove(tail.key);
                deleteTail();
            }
            node = new DLinkedList();
            node.key = key;
            node.value = value;
            addNode(node);
            map.put(key, node);
        }
    }
}