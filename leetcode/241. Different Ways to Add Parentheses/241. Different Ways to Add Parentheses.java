public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> cache = new HashMap<>();       
        return helper(input, cache);
    }
    List<Integer> helper(String input, Map<String, List<Integer>> cache) {
        if (cache.get(input) != null) {
            return cache.get(input);
        }    
        boolean single = true;
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if ("+-*".indexOf(input.charAt(i)) != -1) {
                single = false;
                List<Integer> lefts = helper(input.substring(0, i), cache);
                List<Integer> rights = helper(input.substring(i + 1), cache);
                for (int left: lefts) {
                    for (int right: rights) {
                        ret.add(cal(left, right, input.charAt(i)));
                    }
                }
            }
        }
        if (single) {
            ret.add(Integer.parseInt(input));
        }
        cache.put(input, ret);
        return ret;
    }
    int cal(int a, int b, char operator) {
        switch(operator) {
            case '+': return a + b;
            case '-': return a - b;
            default : return a * b;
        }
    }
}