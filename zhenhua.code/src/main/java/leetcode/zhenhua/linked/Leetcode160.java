package leetcode.zhenhua.linked;

import java.util.HashMap;
import java.util.Objects;

public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB)
            return headA;

        HashMap<ListNode, Boolean> map = new HashMap<>();
        ListNode temp = headA;
        while(temp!= null){
            map.put(temp, Boolean.TRUE);
            temp=temp.next;
        }
        temp = headB;
        while(temp != null){
            if(Objects.equals(Boolean.TRUE, map.get(temp)))
                return temp;
            temp = temp.next;
        }

        return null;
    }

    public static void main(String[] args) {
        int intersectVal = 8;
        int[] listA = {4,1,8,4,5};
        int[] listB = {5,6,1,8,4,5};
        int skipA = 2;
        int skipB = 3;
        Leetcode160 l = new Leetcode160();
        ListNode share = new ListNode(8);
        ListNode headA = l.buildList(listA, skipA, share);
        ListNode headB = l.buildList(listB, skipB, share);
        System.out.println(l.getIntersectionNode(headA, headB).val == intersectVal);
    }

    public ListNode buildList(int[] listA, int skip, ListNode share){
        int aLen = listA.length;
        int i = aLen - 1;
        ListNode head=null;

        while (i >= 0) {
            ListNode temp = new ListNode(listA[i]);
            if(i == skip){
                share.next = head.next;
                temp = share;
            }
            temp.next = head;
            head = temp;
            i--;
        }

        return head;
    }
}
