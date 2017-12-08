public class Solution {
    //Insert one char from stringstream
    public int count;
    public int[] arr;
    public Solution() {
        count = 0;
        arr = new int[128];
    }
    public void Insert(char ch)
    {
        this.count++;
        if (arr[ch] == 0) {
            arr[ch] = count;
        } else if (arr[ch] > 0) {
            arr[ch] = -1;
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char ret = '#';
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 128; i++) {
            if (arr[i] > 0 && arr[i] < min) {
                min = arr[i];
                ret = (char)i;
            }
        }
        return ret;
    }
}