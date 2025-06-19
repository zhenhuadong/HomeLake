package leetcode.zhenhua.linked;

public class Leetcode24 {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;

        return newHead;
    }

    public ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while(temp.next != null && temp.next.next !=null) {
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            temp.next = second;
            first.next = second.next;
            second.next = first;
            temp=first;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        int[] listA = {1,2,3,4};
        int[] listB = {1};
        Leetcode24 l = new Leetcode24();
        ListNode headA = l.buildList(listA);
        ListNode headB = l.buildList(listB);
        System.out.println(l.swapPairs(headB).val);
        System.out.println(l.swapPairs(headA).val);

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
