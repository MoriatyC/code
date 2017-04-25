public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length, k = 3;  //in this question, k=3 specifically
        List<Integer> result = new ArrayList<Integer>();
        if (n==0 || k<2) {
		    return result;
	    } 
        int[] candidates = new int[k-1];
        int[] counts = new int[k-1];
        for (int num: nums) {
            boolean settled = false;
            for (int i=0; i<k-1; i++) {
                if (candidates[i]==num) {
                    counts[i]++;
                    settled = true;
                    break;
                } 
            }
            if (settled) {
                continue;
		    } 
            for (int i=0; i<k-1; i++) {
                if (counts[i]==0) {
                    counts[i] = 1;
                    candidates[i] = num;
                    settled = true;
                    break;
                } 
            }
            if (settled) {
                continue;
            }
            for (int i=0; i<k-1; i++) {
                counts[i] = (counts[i] > 0) ? (counts[i]-1) : 0;
            }
        }
        Arrays.fill(counts, 0);
        for (int num: nums) {
            for (int i=0;i<k-1; i++) {
                if (candidates[i]==num) {
                    counts[i]++;
                    break;
                }
            }
        }
        for (int i=0; i<k-1; i++) {
            if (counts[i]>n/k) {
                result.add(candidates[i]);
            }
        } 
        return result;
    }
}