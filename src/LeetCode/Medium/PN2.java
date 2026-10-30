package LeetCode.Medium;

import LeetCode.ListNode;

public class PN2 {

    public static void main(String[] args) {
        // Create test nodes
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        PN2 solution = new PN2();
        ListNode result = solution.addTwoNumbersOPTIMAL(l1, l2);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    // Reduced repeted null checks to make solution faster
    public ListNode addTwoNumbersOPTIMAL(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        int carryForward = 0;

        // Phase 1: Both lists have digits (No null checks needed inside)
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryForward;
            carryForward = sum / 10;
            current.next = new ListNode(sum % 10);

            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // Phase 2: Only l1 has digits left
        while (l1 != null) {
            int sum = l1.val + carryForward;
            carryForward = sum / 10;
            current.next = new ListNode(sum % 10);

            current = current.next;
            l1 = l1.next;
        }

        // Phase 3: Only l2 has digits left
        while (l2 != null) {
            int sum = l2.val + carryForward;
            carryForward = sum / 10;
            current.next = new ListNode(sum % 10);

            current = current.next;
            l2 = l2.next;
        }

        // Phase 4: Both lists are empty, but we have a leftover carry (e.g., 8 + 5 =
        // 13)
        if (carryForward > 0) {
            current.next = new ListNode(carryForward);
        }

        return dummyNode.next;
    }

    // new approach add numbers as we get and just carry forward remained
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;

        int carryForward = 0;

        while (l1 != null || l2 != null || carryForward != 0) {

            int digit1 = l1 != null ? l1.val : 0;
            int digit2 = l2 != null ? l2.val : 0;

            int newDigit = digit1 + digit2 + carryForward;
            carryForward = newDigit / 10;
            int currentDigit = newDigit % 10;

            current.next = new ListNode(currentDigit);
            current = current.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return dummyNode.next;
    }

    // this failed as long can store number until 19 digits long but test cases on
    // leetcode has numbers till as of I know 31 digits so this wont work
    public ListNode addTwoNumbersFAILEDTESTCASES(ListNode l1, ListNode l2) {

        long num1 = 0;
        long num2 = 0;
        long pointer1 = 1;

        while (l1 != null) {
            num1 += l1.val * pointer1;
            pointer1 *= 10;
            l1 = l1.next;
        }

        pointer1 = 1;
        while (l2 != null) {
            num2 += l2.val * pointer1;
            pointer1 *= 10;
            l2 = l2.next;
        }

        long outputNumber = num1 + num2;

        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;

        if (outputNumber == 0)
            return new ListNode(0);

        while (outputNumber > 0) {
            long digit = outputNumber % 10;
            current.next = new ListNode((int) digit);
            current = current.next;
            outputNumber /= 10;
        }

        return dummyNode.next;
    }
}
