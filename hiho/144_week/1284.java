import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();
        long lenn = 0, lenm = 0, ret1, same = 0;
        for(long i = 1; i <= (long)Math.sqrt(N); i++)
        {
            if(N % i == 0)
            {          
                lenn += 2;
                if(M % i == 0)
                {
                    same++;
                }
                if(M * i % N == 0)
                {
                    same++;
                }
            }
            if(i * i == N)
            {
                lenn--;
            }
        }
        for(long i = 1; i <= (long)Math.sqrt(M); i++)
        {
            if(M % i == 0)
            {
                lenm += 2;
            }
            if(i * i == M)
            {
                lenm--;
            }
        }
        ret1 = lenn * lenm;
        for(long i = same; i >= 2; i--)
        {
            if(same % i == 0 && ret1 % i == 0)
            {
                same /= i;
                ret1 /= i;
            }
        }
        System.out.println(ret1 + " " + same);
    }
}