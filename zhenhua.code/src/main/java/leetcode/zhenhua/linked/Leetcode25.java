package leetcode.zhenhua.linked;

import java.util.List;

public class Leetcode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        int count;
        for (count = 1; cur.next != null; count++) {
            cur = cur.next;
        }

        for (int i = 0; i < count / k; i++) {
            cur = head;
            for (int j = 0; j < k; j++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }

        return dummy.next;
    }

    public ListNode retate(ListNode pre, int k){
        ListNode cur = pre.next;
        int i =1;
        for(; i<k && cur != null & cur.next!=null; i++){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return null;
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
