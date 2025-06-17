package leetcode.zhenhua.linked;

import java.util.HashMap;
import java.util.Objects;

public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Boolean> map = new HashMap<>();

        while(head != null){
            if(Objects.equals(Boolean.TRUE, map.get(head))){
                return true;
            }
            map.put(head, Boolean.TRUE);
            head = head.next;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] listA = {3,2,0,-4};
        int aPos = 2;
        int[] listB = {1,2};
        int bPos = 0;
        int[] listC = {1};
        int cPos = -1;

        Leetcode141 l = new Leetcode141();
        ListNode headA = l.buildList(listA, aPos);
        System.out.println(Objects.equals(true, l.hasCycle(headA)));
        ListNode headB = l.buildList(listB, bPos);
        System.out.println(Objects.equals(true, l.hasCycle(headB)));
        ListNode headC = l.buildList(listC, cPos);
        System.out.println(Objects.equals(false, l.hasCycle(headC)));
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
                tail.next = head;
            }
            head = temp;
            i--;
        }
        return head;
    }
}
