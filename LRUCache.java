import java.util.HashMap;


public class LRUCache {
    

    class Node{
        public int key;
        public int value;
    
        public Node next, prev;
    
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer,Node> cache;
    private Node head, tail;


    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head= new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key)
    {
        if(cache.containsKey(key))
        {
            Node node = cache.get(key);
            remove(node);
            add(node);  
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value)
    {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        } else if (cache.size() >= capacity)
        {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        add(newNode);
        cache.put(key, newNode );
    }


    public static void main(String[] args)
    {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}