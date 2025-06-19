package leetcode.zhenhua.linked;

import java.util.HashMap;
import java.util.Objects;

public class Leetcode142 {

    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast=fast.next.next;
            } else {
                return null;
            }

            if(fast == slow){
                ListNode ans = head;
                while(ans != slow){
                    ans = ans.next;
                    slow = slow.next;
                }
                return ans;
            }
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<>();

        while(head != null){
            if(map.get(head) !=null){
                return head;
            }
            map.put(head, head);
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] listA = {3,2,0,-4};
        int aPos = 1;
        int[] listB = {1,2};
        int bPos = 0;
        int[] listC = {1};
        int cPos = -1;

        Leetcode142 l = new Leetcode142();
        ListNode headA = l.buildList(listA, aPos);
        System.out.println(l.detectCycle1(headA).val);
        ListNode headB = l.buildList(listB, bPos);
        System.out.println(l.detectCycle(headB).val);
        ListNode headC = l.buildList(listC, cPos);
        System.out.println(l.detectCycle(headC));
    }

    public ListNode buildList(int[] listA, int pos){
        int aLen = listA.length;
        int i = aLen - 1;
        ListNode head=null;
        ListNode tail= new ListNode(listA[i--]);
        head=tail;
        while (i >= 0) {
            ListNode temp = new ListNode(listA[i]);
            temp.next = head;
            if(i == pos){
                tail.next = temp;
            }
            head = temp;
            i--;
        }
        return head;
    }
}
