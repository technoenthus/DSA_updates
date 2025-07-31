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
import java.util.Collections;

class Solution 
{
    public static ListNode convert(ArrayList<Integer> data)
    {
        ListNode head = null;
        ListNode temp;

        if(data.size() == 0)return head;

        head = new ListNode(data.get(0));
        temp = head;

        for(int i = 1;i<data.size();i++)
        {
            ListNode newNode = new ListNode(data.get(i));
            temp.next = newNode;
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    public static ListNode mergeLists(ListNode[] list)
    {
        int len = list.length;
        ArrayList<Integer> data = new ArrayList<>();

        for(int i=0;i<len;i++)
        {
            ListNode temp = list[i];
            while(temp != null)
            {
                data.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(data);
        return convert(data);
    }

    public ListNode mergeKLists(ListNode[] lists) 
    {
        return mergeLists(lists);
    }
}