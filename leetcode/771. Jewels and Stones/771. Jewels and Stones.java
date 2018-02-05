class Solution {
    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        char[] jewels = J.toCharArray();
        for (int i = 0; i < jewels.length; i++) {
            map.putIfAbsent(jewels[i], 0);
        }
        char[] stones = S.toCharArray();
        for (int i =0; i < stones.length; i++) {
            if (map.containsKey(stones[i])) {
                map.put(stones[i], map.get(stones[i]) + 1);
            }
        }
        int ret = 0;
        for (int i : map.values()) {
            ret += i;
        }
        return ret;
    }
}