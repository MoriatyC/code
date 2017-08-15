public class Solution {
    public boolean judgeCircle(String moves) {
        char[] move = moves.toCharArray();
        int[] arr = {0, 0};
        for (char s: move) {
            switch(s) {
                case 'L': arr[0]++;
                    break;
                case 'R': arr[0]--;
                    break;
                case 'U': arr[1]++;
                    break;
                default: arr[1]--;
                    break;
            }
        }
        if (arr[0] == 0 && arr[1] == 0) {
            return true;
        }
        return false;
    }
}