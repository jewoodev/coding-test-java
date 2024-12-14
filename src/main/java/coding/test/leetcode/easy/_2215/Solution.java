package coding.test.leetcode.easy._2215;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        boolean flag;
        for (int i = 0; i < nums1.length; i++) {
            flag = true;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    flag = false;
                    nums2[j] = 10002;
                }
            }
            if (flag == true && !l1.contains(Integer.valueOf(nums1[i]))) l1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] != 10002) l2.add(nums2[i]);
        }
        List<List<Integer>> output = new ArrayList<>();
        output.add(l1);
        output.add(l2);
        return output;
    }
}
