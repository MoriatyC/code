class trie{
    trie[] children;
    public trie()
    {
        children = new trie[2];
    }
}
public class Solution {
     public int findMaximumXOR(int[] nums) {
    	if(nums == null || nums.length == 0)
    	{
    	    return 0;
    	}
    	trie root = new trie();
    	for(int num: nums)
    	{
    	    trie curNode = root;
    	    for(int i = 31; i >= 0; i --)
    	    {
    	        int curBit = (num >> i) & 1;
    	        if(curNode.children[curBit] == null)
    	        {
    	            curNode.children[curBit] = new trie();
    	        }
    	        curNode = curNode.children[curBit];
    	    }
    	}
    	int max = 0;
    	for(int num: nums)
    	{
    	    int sum = 0;
    	    trie curNode = root;
    	    for(int i = 31; i >= 0; i--)
    	    {
    	        int curBit = (num >> i) & 1;
    	        if(curNode.children[curBit ^ 1] != null)
    	        {
    	            curNode = curNode.children[curBit ^ 1];
    	            sum += 1 << i;
    	        }
    	        else
    	        {
    	            curNode = curNode.children[curBit];
    	        }
    	        if(max > sum + (1 << i) - 1)
    	        {
    	            break;
    	        }
    	    }
    	    max = max > sum ? max : sum;
    	}
    	return max;
        
    }
}