public class Solution {
    String reverse(String s){
		char[] chars = s.toCharArray();
		char temp;
		for(int i=0,j=chars.length - 1;i < j;i++,j--)
		{
			temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return new String(chars);
	}
    public String reverseWords(String s) {
		StringBuilder ret = new StringBuilder();
		String[] words = s.split(" ");
		for(String word: words)
		{
			ret.append(reverse(word) + " ");
		}
	    return ret.toString().trim();
    }
}