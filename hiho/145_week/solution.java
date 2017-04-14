import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        int[] A = new int[1005];
        int[][] dp = new int[1005][1005];//dp��i����j�����I���J��ü�¼
        int[][] level = new int[1005][1005];//nm
        int canPass, N, M, S, T;
        while(Q-- > 0)
        {
            N = sc.nextInt();//�ܹؿ�
            M = sc.nextInt();//�������
            S = sc.nextInt();//right
            T = sc.nextInt();//wrong
            for(int i = 1; i <= N; i++)
            {
            	for(int j = 0; j <= M; j++)
            		dp[i][j] = 0x7f7f7f7f;

            }
            for(int i = 1; i <= N; i++)
            {
                A[i] = sc.nextInt();
                canPass = (int)Math.ceil(1.0 * A[i] / S);//ÿ�����������
                for(int j = 0; j <= canPass; j++)
                {
                	int rest = A[i] - j * S;//��ǰlevelʣ�µķ���
                	if(rest > 0)
                	{
                		rest = (int)Math.ceil(1.0 * rest / T);//rest �����Ŀ��
                	}
                	else
                		rest = 0;
                	for (int k = 0; j + rest + k <= M  ; ++k)  
                    {  //i �� j �����Ŀ  /k
                		dp[i][j + rest + k] = Math.min (dp[i][j + rest + k], dp[i-1][k]+j );  
                       
                    } 
                }
            }
            int ret = Integer.MAX_VALUE;
            for(int i = 0; i <= M; i++)
            {
            	ret = Math.min(ret, dp[N][i]);
            }
            if(ret <= M)
            	System.out.println(ret);
            else
            	System.out.println("No");
            
        }
    }
}