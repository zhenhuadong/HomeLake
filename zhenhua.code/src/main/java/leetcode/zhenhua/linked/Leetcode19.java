package leetcode.zhenhua.linked;

import java.util.List;

public class Leetcode19 {

    public int index = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode first = head;
        ListNode second = dump;


        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while(first != null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        ListNode ans = dump.next;
        return ans;
    }

    public static void main(String[] args) {
        int[] listA = {1,2,3,4,5};
        int aPosition = 2;
        int[] listB = {1};
        int bPosition = 1;
        Leetcode19 l = new Leetcode19();
        ListNode headA = l.buildList(listA);
        ListNode headB = l.buildList(listB);
        System.out.println(l.removeNthFromEnd(headA, aPosition).val);
        System.out.println(l.removeNthFromEnd(headB, bPosition).val);

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
