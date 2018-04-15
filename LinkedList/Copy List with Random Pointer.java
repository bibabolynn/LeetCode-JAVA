Problem : A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

https://leetcode.com/problems/copy-list-with-random-pointer/description/

Thought : The idea is to associate the original node with its copy node in a single linked list. In this way, we don’t need extra space to keep track of the new nodes.

The algorithm is composed of the follow three steps which are also 3 iteration rounds.

Iterate the original list and duplicate each node. The duplicate
of each node follows its original immediately.
Iterate the new list and assign the random pointer for each
duplicated node.
Restore the original list and extract the duplicated nodes.

Thanks to liaison
Complexity Analysis :
Time Complexity O(n),
 Space complexity O(1)

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode iter = head, next;

		// First round: make copy of each node,
		// and link them together side-by-side in a single list.
		while (iter != null) {
			next = iter.next;
			RandomListNode copy = new RandomListNode(iter.label);
			iter.next = copy;
			copy.next = next;
			iter = next;
		}

		// Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}

		// Third round: restore the original list, and extract the copy list.
		iter = head;
		RandomListNode newHead = new newHead(0);//head of copy list
		RandomListNode copy, curr = newHead;

		while (iter != null) {
			next = iter.next.next;

			// extract the copy
			copy = iter.next;
			curr.next = copy;
			curr = copy;

			// restore the original list
			iter.next = next;

			iter = next;
		}

		return newHead.next;
	}
}
