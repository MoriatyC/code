public class Solution {
    public String addStrings(String num1, String num2) {
        Stack<String> s = new Stack();
		int in = 0, temp = 0, len1 = num1.length() - 1, len2 = num2.length() - 1;
		while(true)
		{
			if(len1 >= 0 && len2 >= 0)
			{
				temp = in + num1.charAt(len1) + num2.charAt(len2) - 96;
				if(temp >= 10)
				{
					in = 1;
					temp %= 10;
				}
				else
				{
				    in = 0;
				}
			}
			else if(len1 >= 0 && len2 < 0)
			{
				temp = in + num1.charAt(len1) - 48;
				if(temp >= 10)
				{
					in = 1;
					temp = 0;
				}
				else
				{
				    in = 0;
				}
			}
			else if(len2 >= 0 && len1 < 0)
			{
				temp = in +num2.charAt(len2) - 48;
				if(temp >= 10)
				{
					in = 1;
					temp = 0;
				}
				else
				{
				    in = 0;
				}
			}
			else
			{
			    if(in == 1)
			    s.push("" + 1);
				break;
			}
			s.push("" + temp);
			len1--;
			len2--;
		}
		StringBuilder sb = new StringBuilder();
		while(!s.empty())
		{
		    sb.append(s.pop());
		}
		return sb.toString();
    }
}