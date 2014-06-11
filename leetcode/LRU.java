public class LRUCache {
    class ListNode {
        int key;
        int val;
        public ListNode(int k, int v) {
            key = k;
            val = v;
        }
        ListNode prev;
        ListNode next;
    }
    int c;
    ListNode head;
    ListNode tail;
    HashMap<Integer,ListNode> map = new HashMap<>();
    public LRUCache(int capacity) {
        c = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            int value = map.get(key).val;
            set(key,value);
            return value;
        } else
            return -1;
    }
    
    public void set(int key, int value) {
        if(!map.containsKey(key)) {
            ListNode node = new ListNode(key, value);
            map.put(key,node);
            node.next = head;
            node.prev = null;
            if(head!=null) head.prev = node;
            if(tail==null) tail = node;
            head = node;
            if(map.size()>c) {
                ListNode temp = tail.prev;
                map.remove(tail.key);
                if(temp!=null) {
                    temp.next = null;
                    tail = temp;
                } else 
                    tail = null;
            }
        }
        else {
            ListNode node = map.get(key);
            node.val = value;
            if(node.prev!=null)
                node.prev.next = node.next;
            if(node.next!=null)
                node.next.prev = node.prev!=null ? node.prev : node;
            if(node.next==null)
                tail = node.prev!=null ? node.prev : node;
            if(node.prev!=null) {
                node.next = head;
                head.prev = node;
                node.prev = null;
                head = node;
            }
        }
    }
}

// Using LinkedHashMap in java library
public class LRUCache {
    int c;
    Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        c = capacity;
        map = new LinkedHashMap<Integer,Integer>(c,0.75f,true) {
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldestEntry) {
                return size() > c;
            }
        };
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        return map.get(key);
    }
    
    public void set(int key, int value) {
        map.put(key, value);
    }
}
