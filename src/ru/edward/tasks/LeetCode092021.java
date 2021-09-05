/*
 * ©Edward, 2021
 */
package ru.edward.tasks;

import java.util.HashMap;
import java.util.Map;
//import java.util.Optional;

import java.math.BigInteger;

public class LeetCode092021 {
    /**
     * https://leetcode.com/problems/two-sum/
     * Решение "в лоб"
     */
    public static int[] twoSum_2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //Пытаемся сложить с каждым следующим числом
            if (i <= nums.length - 1) {
                for (int k = i + 1; k < nums.length; k++) {
                    if (nums[i] + nums[k] == target) {
                        return new int[]{i, k};
                    }
                }
            }
        }
        return null;
    }

    /**
     * https://leetcode.com/problems/two-sum/
     * Решение с помощью HashMap (самое шустрое)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    /**
     * https://leetcode.com/problems/add-two-numbers/
     */
    public static class ListNode {
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

    /**
     * https://leetcode.com/problems/add-two-numbers/
     * Решение "в лоб"
     */
    public static ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        StringBuilder val1 = new StringBuilder();
        StringBuilder val2 = new StringBuilder();
        ListNode curNode;

        curNode = l1;
        do {
            val1.insert(0, curNode.val);
            curNode = curNode.next;
        }
        while (curNode != null);

        curNode = l2;
        do {
            val2.insert(0, curNode.val);
            curNode = curNode.next;
        }
        while (curNode != null);

        BigInteger a = new BigInteger(val1.toString());
        BigInteger b = new BigInteger(val2.toString());
        BigInteger result = a.add(b);

        String sumStr = result.toString();

        curNode = null;
        for (int i = 0; i < sumStr.length(); i++) {
            //Первый элемент
            if (curNode == null) {
                curNode = new ListNode(Integer.parseInt(sumStr.substring(i, i + 1)));
            } else {
                curNode = new ListNode(Integer.parseInt(sumStr.substring(i, i + 1)), curNode);
            }
        }
        return curNode;
    }

    /**
     * https://leetcode.com/problems/add-two-numbers/
     * Решение "конвейером"
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lr;
        ListNode prevLr = null;
        ListNode result = null;
        int m = 0;

        do {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + m;

            lr = new ListNode(sum < 10 ? sum : sum - 10);
            if (prevLr == null) result = lr;
            else prevLr.next = lr;

            m = sum < 10 ? 0 : 1;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            prevLr = lr;
        }
        while (l1 != null || l2 != null);

        if (m == 1) {
            lr.next = new ListNode(1);
        }

        return result;
    }
}

