public class Solution {
    public int distributeCandies(int[] candies) {
        int len = candies.length;
        int half = len / 2;
        Set<Integer> kinds = new HashSet<Integer>();
        for (int i : candies) {
            kinds.add(i);
        }
        if (half <= kinds.size()) {
            return half;
        }
        return kinds.size();
    }
}