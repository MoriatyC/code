class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
        }
        for (int l = 0, r = 0; r < s2.length(); r++) {
            if (--count[s2.charAt(r)] < 0) {
                while (++count[s2.charAt(l++)] != 0) {
                    //出现不匹配的时候值肯定是-1，有个值是invalid或者个数不匹配，所以只要修复到那个值为0，就可以继续匹配。
                }
            } else if (r - l + 1 == s1.length()) {//当长度相同时一定匹配，因为一旦出现不匹配，就会提前处理。
                return true;
            }
        }
        return false;
    }
}