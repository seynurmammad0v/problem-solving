
class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;

        if (list1 == null) return list2;

        if (list2 == null) return list1;

        ListNode head = new ListNode();
        ListNode temp = head;
        ListNode lt;

        do {
            if (list1.val > list2.val) {
                lt = list2.next;
                temp.next = list2;
                temp.next.next = null;
                list2 = lt;
            } else {
                lt = list1.next;
                temp.next = list1;
                temp.next.next = null;
                list1 = lt;
            }
            temp = temp.next;
        }
        while (list1 != null && list2 != null);

        if (list1 == null) temp.next = list2;
        else temp.next = list1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listHead = new ListNode(1);
        listHead.next = new ListNode(2);
        listHead.next.next = new ListNode(4);
        ListNode listHead2 = new ListNode(1);
        listHead2.next = new ListNode(3);
        listHead2.next.next = new ListNode(4);
        mergeTwoLists(listHead, listHead2);
    }

}