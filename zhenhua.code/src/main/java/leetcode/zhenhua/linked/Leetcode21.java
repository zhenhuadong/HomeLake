package leetcode.zhenhua.linked;

import java.util.Objects;

public class Leetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        } else if(list2 == null){
            return list1;
        }

        ListNode ans = null;
        if (list1.val <= list2.val){
            ans = list1;
            list1 = list1.next;
        } else {
            ans = list2;
            list2 = list2.next;
        }
        ans.next = null;

        ListNode temp = ans;

        while(list1 != null && list2 != null){
            if (list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
            temp.next = null;
        }

        if(list1 != null){
            temp.next = list1;
        }
        if(list2 != null) {
            temp.next = list2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] listA = {1,2,4};
        int[] listB = {1,3,4};
        Leetcode21 l = new Leetcode21();
        ListNode headA = l.buildList(listA);
        ListNode headB = l.buildList(listB);
        System.out.println(l.mergeTwoLists(headA, headB));
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
