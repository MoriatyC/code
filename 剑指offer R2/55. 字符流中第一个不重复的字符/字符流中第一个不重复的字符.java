public class Solution {
    //Insert one char from stringstream
    int[] arr = new int[128];
    int index = 1;
    public void Insert(char ch)
    {
        if (arr[ch] == 0) {
            arr[ch] = index;
        } else if (arr[ch] > 0) {
            arr[ch] = -1;
        }
        index++;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int min = Integer.MAX_VALUE;
        char ret = '#';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] < min) {
                min = arr[i];
                ret = (char)i;
            }
        }
        return ret;
    }
}