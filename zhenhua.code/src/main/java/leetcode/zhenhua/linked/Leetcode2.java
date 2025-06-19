package leetcode.zhenhua.linked;

public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val == 0)
            return l2;
        else if (l2.val == 0) {
            return l1;
        }
        ListNode ans = l1;
        ListNode pre = null;
        int carry = 0;
        while (l1 != null && l2 != null){
            int temp  = l1.val + l2.val + carry;
            l1.val = temp % 10;
            carry = temp / 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null) {
            pre.next = l2;
            l1 = l2;
        }
        while(l1 != null){
            int temp  = l1.val + carry;
            l1.val = temp % 10;
            carry = temp / 10;
            pre = l1;
            l1 = l1.next;
        }
        if(carry != 0){
            pre.next = new ListNode(carry);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] listA = {9,9,9,9,9,9,9};
        int[] listB = {9,9,9,9};
        Leetcode2 l = new Leetcode2();
        ListNode headA = l.buildList(listA);
        ListNode headB = l.buildList(listB);
        System.out.println(l.addTwoNumbers(headA, headB));
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
