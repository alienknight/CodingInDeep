
public class CopyRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head==null) return null;
        RandomListNode root = new RandomListNode(head.label);
        RandomListNode r = root;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        map.put(head,root);
        while(head!=null) {
            if(head.next!=null) {
                if(!map.containsKey(head.next)) {
                    RandomListNode temp = new RandomListNode(head.next.label);
                    r.next = temp;
                    map.put(head.next,temp);
                }
                else
                    r.next = map.get(head.next);
            }
            if(head.random!=null) {
                if(!map.containsKey(head.random)) {
                    RandomListNode temp1 = new RandomListNode(head.random.label);
                    r.random = temp1;
                    map.put(head.random,temp1);
                }
                else
                    r.random = map.get(head.random);
            }
            r = r.next;
            head = head.next;
        }
        return root;
    }
}
