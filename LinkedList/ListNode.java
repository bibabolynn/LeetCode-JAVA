public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
/**
 * turn an array to a linkedlist
 *@return the head of the list
 **/
    public static ListNode arrayToList(int[] a){
        if(a.length == 0)
            return null;
        ListNode head =new ListNode(a[0]);
        ListNode curr = head;
        for (int i = 1; i <a.length ; i++) {
            ListNode next = new ListNode(a[i]);
            curr.next = next;
            curr = next;
        }
        return head;
    }
/**
 *  print list like 1 --> 2 --> 3
 **/
    public static void print(ListNode head){
        while (head.next != null){
            System.out.print(head.val+" --> ");
            head = head.next;
        }
        System.out.println(head.val);

    }
}
