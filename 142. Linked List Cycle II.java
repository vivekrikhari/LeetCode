// Medium
// Given the head of a linked list, 
// return the node where the cycle begins. 
// If there is no cycle, 
// return null.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
// Internally, 
// pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). 
// It is -1 if there is no cycle. 
// Note that pos is not passed as a parameter.

// Do not modify the linked list.

// Example 1:
// Input: 
// head = [3,2,0,-4], pos = 1
// Output: 
// tail connects to node index 1
  
// Explanation: 
// There is a cycle in the linked list, 
// where tail connects to the second node.

// Example 2:
// Input: 
// head = [1,2], pos = 0
// Output: 
// tail connects to node index 0
  
// Explanation: 
// There is a cycle in the linked list, 
// where tail connects to the first node.
  
// Example 3:
// Input: 
// head = [1], pos = -1
// Output: 
// no cycle

// Explanation: 
// There is no cycle in the linked list.
 
// Constraints:
// The number of the nodes in the list is in the range [0, 104].
// -105 <= Node.val <= 105
// pos is -1 or a valid index in the linked-list.
 
// Follow up: Can you solve it using O(1) (i.e. constant) memory?

// Solution 1
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            
            set.add(node);
            node = node.next;
        }
        
        return null;
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 6 ms, faster than 11.88% of Java online submissions for Linked List Cycle II.
// Memory Usage: 47 MB, less than 5.71% of Java online submissions for Linked List Cycle II.

// Solution 2
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null || head.next.next.next == null) {
            return null;
        }
        
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                break;
            }
            
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (fast == null || fast.next == null) {
            return null;
        }
        
        ListNode start = head;
        
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }
        
        return start;
    }
}
// TC: O(n); SC: O(1)
