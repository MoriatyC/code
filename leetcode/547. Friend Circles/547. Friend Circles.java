public class Solution {
    int[] pre, rank;
    int count;
    void join(int x,int y)
    {
        int fx = find(x), fy = find(y);
        if(fx == fy) return;
        if(rank[fx] > rank[fy])
        {
            pre[fy] = fx;
        }
        else
        {
            pre[fx] = fy;
            if(rank[fx] == rank[fy])
            {
                rank[fy]++;
            }
        }
        count--;
    }
    int find(int x)
    {
        if(x != pre[x])
        {
            pre[x] = find(pre[x]);
        }
        return pre[x];
    }
    public int findCircleNum(int[][] M) {
        int num = M.length;
        count = num;
        pre = new int[num];
        rank = new int[num];
        for(int i = 0; i < num; i ++)
        {
            pre[i] = i;
            rank[i] = 1;
        }
        for(int i = 0; i < num; i++)
        {
            for(int j = i + 1; j < num; j++)
            {
                if(M[i][j] == 1)
                {
                    join(i,j);
                }
            }
        }
        return count;
    }
}