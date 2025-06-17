package leetcode.zhenhua.linked;

import java.util.Objects;

public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        int intersectVal = 8;
        int[] listA = {1,2,3,4,5};
        int[] listB = {1,2};
        int[] listC = {};
        Leetcode206 l = new Leetcode206();
        ListNode headA = l.buildList(listA);
        System.out.println(Objects.equals(5, l.reverseList(headA).val));
        ListNode headB = l.buildList(listB);
        System.out.println(Objects.equals(2, l.reverseList(headB).val));

        ListNode headC = l.buildList(listC);
        System.out.println(Objects.equals(headC, l.reverseList(headC)));
    }

    public ListNode buildList(int[] listA){
        int aLen = listA.length;
        int i = aLen - 1;
        ListNode head=null;

        while (i >= 0) {
            ListNode temp = new ListNode(listA[i]);
            temp.next = head;
            head = temp;
            i--;
        }

        return head;
    }
}
