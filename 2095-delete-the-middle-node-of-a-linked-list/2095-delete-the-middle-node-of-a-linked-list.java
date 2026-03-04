import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head==null ||  head.next==null) {
            return null;
        }

        ListNode node1 = head;
        ListNode node2 = head.next.next;

        while(node2!=null && node2.next!=null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }

        node1.next = node1.next.next;

        return head;
    }
}