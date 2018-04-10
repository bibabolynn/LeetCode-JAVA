Problem : Sort a linked list using insertion sort.
https://leetcode.com/problems/insertion-sort-list/description/

Thought :  need a newHead as the head of the sorted list, iterat original list ,add each node to the sorted list

Complexity Analysis :Time Complexity O(n^2), Space complexity O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode newHead = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = newHead; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            // pre.next and nodes before pre.next is sorted ,if pre.next.val <= cur.val there is no need to reset pre = newHead
            if(pre.next != null &&  pre.next.val >= cur.val){ 
                pre = newHead;
            }
            //find the right place to insert
            // use <= is better than < ,if there are many nodes which have equal values, you add the cur node to the end ,point cur to null is faster than point cur to anther node
            while( pre.next != null && pre.next.val <= cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur; //pre.next and nodes before pre.next is sorted 
            cur = next;
        }

        return helper.next;
    }
}



public class InsertSort {

    public static void insertSort(int[] a){
        if(a.length<=0) return;
        int j;
        for (int i = 1; i < a.length; i++) {
            int val = a[i];//带插入元素
            for ( j = i-1; j >= 0 ; j--) { //大于val的都往后移
                if(a[j]> val)
                    a[j+1] = a[j];
                else
                    break;

            }
            a[j+1] = val;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 11, 2, 3, 4, 5, 6, 8, 7};
        System.out.println(Arrays.toString(a));
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
