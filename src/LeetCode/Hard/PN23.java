package LeetCode.Hard;

public class PN23 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;
        ListNode output = lists[0];

        for (int i = 1; i < lists.length; i++)
            output = merge(output, lists[i]);

        return output;
    }

    public static ListNode merge(ListNode list1, ListNode list2) {

        ListNode temp = new ListNode(0);
        ListNode dummy = temp;

        while (list1 != null && list2 != null) {
            int v1 = list1.val;
            int v2 = list2.val;

            if (v1 < v2) {
                if (temp == null)
                    temp = list1;
                else {
                    temp.next = list1;
                    temp = temp.next;
                }
                list1 = list1.next;
            } else {
                if (temp == null)
                    temp = list2;
                else {
                    temp.next = list2;
                    temp = temp.next;
                }
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            if (temp == null)
                temp = list1;
            else {
                temp.next = list1;
                temp = temp.next;
            }
            list1 = list1.next;
        }

        while (list2 != null) {
            if (temp == null)
                temp = list2;
            else {
                temp.next = list2;
                temp = temp.next;
            }
            list2 = list2.next;
        }

        return dummy.next;
    }
}
