package prepare;
/** 
* @author : Menghui Chen 
* @version ：2018年3月20日 下午7:14:04 
* @Description:
*/
public class HashMap<T, V> {
    static class Node<T, V> {
        Node<T, V> next;
        private T key;
        private V value;
        public void setKey(T k) {
            this.key = k;
        }
        public T getKey() {
            return key;
        }
        public void setValue(V value) {
            this.value = value;
        }
        public V getValue() {
            return value;
        }
        public Node(T k, V v) {
            this.key = k;
            this.value = v;
        }
    }
    Node[] tab;
    public HashMap(int capacity) {
        tab = new Node[capacity];
    }
    public V put(T key, V value) {
        int index = getIndex(key);
        Node node = new Node(key, value);
        if (tab[index] == null) {
            tab[index] = node;
            return null;
        } else {
            Node head = tab[index];
            Node pre = searchList(head, key);
            if (pre.next == null) {
                pre.next = node;
                return null;
            } else {
                V old =  (V) pre.next.value;//here
                pre.next.value = value;
                return old;
            }
        }
        
    }
    public Node searchList(Node node, T k) {
        Node pre = null;
        while (node != null) {
            if (hash((T)node.key) == hash(k) && (node.key == k || node.key.equals(k))) {
                break;
            }
            pre = node;
            node = node.next;
        }
        return pre;
    }
    public V get(T key) {
        int index = getIndex(key);
        if (tab[index] == null) {
            return null;
        } else {
            Node head = tab[index];
            head = searchList(head, key);
            if (head == null && head.next == null) {
                return null;
            } else {
                return (V)head.next.value;
            }
        }
    }
    public int hash(T key) {
        return (key.hashCode() >> 16) ^ key.hashCode();
    }
    public int getIndex(T key) {
        return hash(key) % tab.length; 
    }
}
