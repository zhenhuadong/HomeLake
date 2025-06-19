package leetcode.zhenhua.linked;

import java.util.List;

public class Leetcode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;

        while(head != null) {
            ListNode tail = pre;
            for(int i = 0; i<k; ++i){
                tail = tail.next;
                if(tail == null) {
                    return dummy;
                }
            }
            ListNode next = tail.next;
            while(cur != null && i < k){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                i++;
            }
            temp.next = pre;
            temp = cur;
        }

        return dummy.next;
    }

    
    public static void main(String[] args) {
        Leetcode25 l = new Leetcode25();
        int[] nums = {1,2,3,4,5};
        int k = 3;
        ListNode headA = l.buildList(nums);
        System.out.println(l.reverseKGroup(headA, k).val);
    }


    public ListNode buildList(int[] listA){
        int aLen = listA.length;
        int i = aLen - 1;
        ListNode head=null;
        ListNode tail= new ListNode(listA[i--]);
        head=tail;
        while (i >= 0) {
            ListNode temp = new ListNode(listA[i]);
            temp.next = head;
            head = temp;
            i--;
        }
        return head;
    }
}
