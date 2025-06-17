package leetcode.zhenhua.linked;

import java.util.Objects;

public class Leetcode234 {

    private ListNode left;
    public boolean isPalindrome(ListNode head) {
        left=head;
        ListNode cur = head;
        return recursiveCheck(cur);
    }

    public boolean recursiveCheck(ListNode cur){
        if(cur != null){
            if(!recursiveCheck(cur.next)){
                return false;
            }

            if(cur.val != left.val){
                return false;
            }

            left = left.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int intersectVal = 8;
        int[] listA = {1,2,2,1};
        int[] listB = {1,2};

        Leetcode234 l = new Leetcode234();
        ListNode headA = l.buildList(listA);
        System.out.println(Objects.equals(true, l.isPalindrome(headA)));
        ListNode headB = l.buildList(listB);
        System.out.println(Objects.equals(false, l.isPalindrome(headB)));
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
