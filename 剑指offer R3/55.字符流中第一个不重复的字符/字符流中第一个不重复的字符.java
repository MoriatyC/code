public class Solution {
    int index = 1;
    int[] arr = new int[256];
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (arr[ch] == 0) {
            arr[ch] = index;
        } else {
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