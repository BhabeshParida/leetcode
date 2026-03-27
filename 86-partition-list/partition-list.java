class Solution {
    public ListNode partition(ListNode head, int x) {

        // Create two dummy lists
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        ListNode before = beforeHead;
        ListNode after = afterHead;

        // Traverse original list
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Important: terminate the after list
        after.next = null;

        // Connect both lists
        before.next = afterHead.next;

        return beforeHead.next;
    }
}