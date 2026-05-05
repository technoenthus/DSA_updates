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
    public ListNode rotateRight(ListNode head, int k) {
        int length=1;
        if (head==null || head.next==null){
            return head;
        }
        ListNode curr=head;
        while(curr.next!=null){
            length++;
            curr=curr.next;
        }
        curr.next=head;
        int rot=k%length;
        int skip=length-rot;
        ListNode newl=head;
        for (int i=0;i<skip-1;i++){
            newl=newl.next;
        }
        head=newl.next;
        newl.next=null;

        return head;
    }
}