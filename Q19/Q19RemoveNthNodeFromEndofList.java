package Q19;

class Q19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for(int i=0; i < len - n; i++){
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return dummy.next;
    }
}