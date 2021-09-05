/*
 * ©Edward, 2021
 */

package ru.edward.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode092021Test {

    @Test
    void twoSum() {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = LeetCode092021.twoSum(nums, target);

        int[] expRes = {0,1};

        assertArrayEquals(expRes, res);
    }

    @Test
    void addTwoNumbers() {
        //[2,4,3]
        LeetCode092021.ListNode curNode1;
        curNode1 = new LeetCode092021.ListNode(3);
        curNode1 = new LeetCode092021.ListNode(4, curNode1);
        curNode1 = new LeetCode092021.ListNode(2, curNode1);
        //[5,6,4]
        LeetCode092021.ListNode curNode2;
        curNode2 = new LeetCode092021.ListNode(4);
        curNode2 = new LeetCode092021.ListNode(6, curNode2);
        curNode2 = new LeetCode092021.ListNode(5, curNode2);

        LeetCode092021.ListNode resNode = LeetCode092021.addTwoNumbers(curNode1, curNode2);

        //[7,0,8] 342 + 465 = 807
        assertEquals(7, resNode.val);
        resNode = resNode.next;
        assertEquals(0, resNode.val);
        resNode = resNode.next;
        assertEquals(8, resNode.val);
    }
}