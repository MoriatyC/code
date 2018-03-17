class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int i: nums) {
            if (candidate1 == i) {
                count1++;
            } else if (candidate2 == i) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                candidate1 = i;
            } else if (count2 == 0) {
                count2++;
                candidate2 = i;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i: nums) {
            if (i == candidate1) {
                count1++;
            } else if(i == candidate2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            ret.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            ret.add(candidate2);
        }
        return ret;
    }
}