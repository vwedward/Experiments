/*
 * ©Edward, 2021
 */
package ru.edward.tasks;

//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;

import java.math.BigInteger;

public class LeetCode092021 {
    /*
     * https://leetcode.com/problems/two-sum/
     * Решение 2 с помощью HashMap (медленнее чем первое)
    public static int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];

            if (map.containsValue(diff)) {
                Optional<Integer> result = map.entrySet()
                        .stream()
                        .filter(entry -> diff.equals(entry.getValue()))
                        .map(Map.Entry::getKey)
                        .findFirst();


                int[] res = new int[2];
                res[0] = result.get();
                res[1] = i;
                return res;
            } else {
                map.put(i, nums[i]);
            }
        }
        return null;
    }*/

    /**
     * https://leetcode.com/problems/two-sum/
     * Решение "в лоб"
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //Пытаемся сложить с каждым следующим числом
            if (i <= nums.length - 1) {
                for (int k = i + 1; k < nums.length; k++) {
                    if (nums[i] + nums[k] == target) {
                        int[] res = new int[2];
                        res[0] = i;
                        res[1] = k;
                        return res;
                    }
                }
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder val1 = new StringBuilder();
        StringBuilder val2 = new StringBuilder();
        ListNode curNode;

        curNode = l1;
        do {
            val1.insert(0, curNode.val);
            //val1.append(curNode.val);
            curNode = curNode.next;
        }
        while (curNode != null);

        curNode = l2;
        do {
            val2.insert(0, curNode.val);
            //val2.append(curNode.val);
            curNode = curNode.next;
        }
        while (curNode != null);

        BigInteger a = new BigInteger(val1.toString());
        BigInteger b = new BigInteger(val2.toString());
        BigInteger result = a.add(b);

        String sumStr = result.toString();

       // String sumStr = String.valueOf(BigInteger.valueOf(val1.toString()) + Long.parseLong(val2.toString()));

        curNode = null;
        for (int i = 0; i < sumStr.length(); i++) {
        //for (int i = sumStr.length() - 1; i >= 0 ; i--) {
            //Первый элемент
            if (curNode == null) {
                curNode = new ListNode(Integer.parseInt(sumStr.substring(i, i + 1)));
            } else {
                curNode = new ListNode(Integer.parseInt(sumStr.substring(i, i + 1)), curNode);
            }
        }
        return curNode;
    }
}


