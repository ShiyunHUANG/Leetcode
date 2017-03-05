package AmazonOA;

import java.util.HashMap;
import java.util.Map;

public class _DeepCopyListWithRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        //use a map to copy nodes and map old node to new node
        //old node as key will make sure the mapping is right regardless of value
        //new nodes will have the correct amount (no duplicate)
        if(head == null) return null;
        RandomListNode curr = head;
        //put all nodes in a map
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while(curr != null) {
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        //deep copy
        curr = head;
        RandomListNode fake = new RandomListNode(0), node = fake;
        while(curr != null) {
            RandomListNode tmp = map.get(curr);
            tmp.next = map.get(curr.next);
            tmp.random = map.get(curr.random);
            node.next = tmp;
            node = node.next;
            curr = curr.next;
        }
        return fake.next;
    }
    public static void main(String[] args) {

    }

}
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
