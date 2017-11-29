public static void solution(int n) {
        if (n < 0) {
            return;
        }
        int[][] arr = new int[2][6 * n +1];
        for (int i = 1; i <= 6; i++) {
            arr[0][i] = 1;
        }
        int flag = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[1 - flag][j] = 0;//防止在做转换的时候把无法得到的部分算进去
            }
            for (int j = i; j <= 6 * i; j++) {//j 下一次数组的可能值
                arr[1 - flag][j] = 0;//先把另一个数组清空
                for (int k = 1; j >= k && k <= 6; k++) {
                    arr[1 - flag][j] += arr[flag][j - k];
                }
            }
            
            flag = 1 - flag;
        }
        for (int i = n; i <= 6 * n; i++) {
            System.out.println(arr[flag][i] / Math.pow(6, n));
        }
    }