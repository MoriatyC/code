public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ret = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (i > min) {
                break;
            }
            if (map.containsKey(list2[i])) {
                int index = i + map.get(list2[i]);
                if (index == min) {
                    ret.add(list2[i]);
                } else if (index < min) {
                    min = index;
                    ret.clear();
                    ret.add(list2[i]);
                }
            }
        }
        int size = ret.size();
        return ret.toArray(new String[size]);
    }
}