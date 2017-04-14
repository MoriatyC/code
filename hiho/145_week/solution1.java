import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        while(Q-- > 0)
        {
            int N = sc.nextInt();//总关卡guanka
            int M = sc.nextInt();//答题机会
            int S = sc.nextInt();//right
            int T = sc.nextInt();//wrong
            int[] A = new int[N + 1];
            int[][] dp = new int[N + 1][M + 1];//nm;
            int[][] level = new int[N + 1][M + 1];//nm
            for(int i = 1; i <= N; i++)
            {
            	for(int j = 0; j <= M; j++)
            		dp[i][j] = Integer.MAX_VALUE;
            }
            for(int i = 1; i <= N; i++)
            {
                A[i] = sc.nextInt();
                for(int j = 0; j <= M; j++)
                {
                    level[i][j] = Math.max(0, (int)(Math.ceil((1.0 * A[i] - j * T) / S)));
                }
            }
            for(int i = 1; i <= N; i++)
            {
            	for(int j = 0; j <= M; j++)
            	{
            		for(int x = 0; x <= (int)Math.ceil(1.0 * A[i]/T); x++)
            		{
            			if(x <= j)
            			{
            				dp[i][j] = Math.min(dp[i][j], level[i][x] + dp[i - 1][j - x]);
            				
            			}
            		}
            	}
            }
            int ret = Integer.MAX_VALUE;
            for(int i = 0; i <= M; i++)
            {
//            	if(ret > dp[N][i])
//            	{
//            		ret = dp[N][i];
//            	}
            	if((dp[N][i] + i) <= M)
                    ret = Math.min(ret, dp[N][i]);

            }
            if(ret == Integer.MAX_VALUE)
            {
            	System.out.println("No");
            	
            }
            else
            	System.out.println(ret);
        }
    }
}