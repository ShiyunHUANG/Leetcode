package hard;

import java.util.HashMap;
import java.util.Map;

//every time a cache-line is used, the age of all other cache-lines changes
public class LRUCache146 {
    private int capacity;
    private DLinkedNode fakeHead, fakeTail;//
    private Map<Integer, DLinkedNode> map; //map keys to nodes
    public LRUCache146 (int capacity) {
        //create a fake head and a fake tail
        fakeHead = new DLinkedNode();
        fakeTail = new DLinkedNode();
        fakeHead.setNext(fakeTail);
        fakeTail.setPrev(fakeHead);
        this.capacity = capacity;
        map = new HashMap<Integer, DLinkedNode>();
    }

    /**
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * move this node to head because it is accessed
     * move the accessed node to head!
     */
    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.getValue();
        } else return -1;
    }
    /**
     * put(key, value) - Set or insert the value if the key is not already present. 
     * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     * If the node is already present, update its value.
     */
    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            addNode(node);
        } else {
            node.setValue(value);
            moveToHead(node);
        }
        map.put(key, node); //update value or add new node
        if(map.size() > capacity) {
            DLinkedNode tail = popTail();
            map.remove(tail.getKey());
        } 
    }
    /**
     * remove node if exsit
     */
    public void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.getPrev();
        DLinkedNode next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);;
        //   map.remove(node.getKey());
    }
    /**
     * add node to head
     */
    private void addNode(DLinkedNode node) {
        DLinkedNode tmp = fakeHead.getNext();
        fakeHead.setNext(node);
        node.setNext(tmp);
        node.setPrev(fakeHead);
        tmp.setPrev(node);
    }
    /**
     * pop tail
     */
    private DLinkedNode popTail() {
        DLinkedNode lastone = fakeTail.getPrev();
        removeNode(lastone);
        //   map.remove(lastone.getKey());
        return lastone;
    }
    /**
     * move to head, since calling remove and add method, both of them should update
     * map, or both do not!
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

}
class DLinkedNode {
    private int key;
    private int value;
    private DLinkedNode prev, next; //previous node and next node
    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public DLinkedNode() {}
    public void setNext(DLinkedNode node) {
        this.next = node;
    }
    public void setPrev(DLinkedNode node) {
        this.prev = node;
    }
    public int getValue() {
        return this.value;
    }
    public int getKey() {
        return this.key;
    }
    public DLinkedNode getPrev() {
        return this.prev;
    }
    public DLinkedNode getNext() {
        return this.next;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
