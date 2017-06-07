public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        List<String> cur = null;
        for (String path: paths) {
            String[] file = path.split(" ");
            for (int i = 1; i < file.length; i++) {
                int index = file[i].indexOf("(");
                String sub = file[i].substring(index, file[i].length()-1);
                if (map.containsKey(sub)) {
                    cur = map.get(sub);
                    cur.add(file[0]+"/"+file[i].substring(0, index));
                } else {
                    cur = new ArrayList<>();
                    cur.add(file[0]+"/"+file[i].substring(0, index));
                    map.put(sub, cur);
                }
            }
        }
        for (String key: map.keySet()) {
            if (map.get(key).size() >= 2) {
                ret.add(map.get(key));
            }
        }
        return ret;
    }
}