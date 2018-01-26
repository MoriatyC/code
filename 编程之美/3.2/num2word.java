package first_maven;

public class Main {
    static int flag = 0;
    static char[][] map = new char[][]{
        "".toCharArray(),
        "".toCharArray(),
        "abc".toCharArray(),
        "def".toCharArray(),
        "ghi".toCharArray(),
        "jkl".toCharArray(),
        "mno".toCharArray(),
        "pqrs".toCharArray(),
        "tuv".toCharArray(),
        "wxyz".toCharArray(),
    };
    public static void recuNum2Word(int index, int len, int[] tele, int[] answer) {
        if (index == len) {
            for (int i = 0; i < len; i++) {
                System.out.print(map[tele[i]][answer[i]]);
            }
            System.out.println();
            flag++;
            return;
        }
        for (answer[index] = 0; answer[index] < map[tele[index]].length; answer[index]++) {
            recuNum2Word(index + 1, len, tele, answer);
        }
        
    }
    public static void num2word(String num) {
        char[] nums = num.toCharArray();
        int len = nums.length;
        int[] tele = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] < '2' || nums[i] > '9') {
                System.out.println("请输入合适的数字");
                return;
            } else {
                tele[i] = nums[i] - '0';
            }
        }
        int[] answer = new int[len];
        while (true) {
            for (int i = 0; i < len; i++) {
                System.out.print(map[tele[i]][answer[i]]);
            }
            flag++;
            System.out.println();
            int k = len - 1;
            while (k >= 0) {
                if (answer[k] < map[tele[k]].length - 1) {
                    answer[k]++;
                    break;
                } else {
                    answer[k] = 0;
                    k--;
                }
            }
            if (k < 0) {
                break;
            }
        }
        
    }
    public static void main(String[] args) {
        int[] tele = {2,3,4};
        int[] answer = new int[tele.length];
        recuNum2Word(0, tele.length, tele, answer);
        System.out.println(flag);
    }
}