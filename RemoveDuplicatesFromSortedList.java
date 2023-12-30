/* 
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:
[1]->[1]->[2]

Input: head = [1,1,2]
Output: [1,2]
Example 2:
[1]->[1]->[2]->[3]->[3]

Input: head = [1,1,2,3,3]
Output: [1,2,3]
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveDuplicatesFromSortedList {
    static ListNode deleteDuplicates(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            if (currentNode.val == nextNode.val) {
                currentNode.next = nextNode.next;
                nextNode = currentNode.next;
            } else {
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }
        return head;
    }

    static void printLinkedNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new
        // ListNode(3,new ListNode(3,new ListNode(4))))));
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));
        printLinkedNode(head);
        head = deleteDuplicates(head);
        printLinkedNode(head);

    }
}
