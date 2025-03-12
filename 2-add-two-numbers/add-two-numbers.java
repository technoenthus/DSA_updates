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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null)
        {
            return l2;
    }
    if (l2==null)
        {
            return l1;
    }
        
        ListNode temp1=l1;
        ListNode temp2=l2;
        int carry=0;
        ListNode newhead=new ListNode(-1);
        ListNode curr=newhead;
        while(temp1!=null || temp2!=null){
            int sum=carry;
            if (temp1!=null){sum+=temp1.val; temp1=temp1.next;}
            if (temp2!=null){sum+=temp2.val; temp2=temp2.next;}
            ListNode newnode=new ListNode();
            newnode.val=sum%10;
            carry=sum/10;
            curr.next=newnode;

            curr=curr.next;
            
            

        }
        if (carry!=0){
            ListNode neww=new ListNode(carry);
            curr.next=neww;
        }
        return newhead.next;
    }
}