public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int row = matrix.size();
        int col = matrix.get(0).size();
        Queue<int[]> que = new LinkedList();
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(matrix.get(i).get(j) == 0)
                {
                    que.offer(new int[]{i,j});
                }
                else
                {
                    matrix.get(i).set(j,Integer.MAX_VALUE);
                }
            }
        }
        while(!que.isEmpty())
        {
            int[] cur = que.poll();
            for(int[] d: dir)
            {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if(r < 0 || c < 0 || r >= row|| c >= col || matrix.get(cur[0]).get(cur[1]) + 1 >= matrix.get(r).get(c))
                {
                    continue;
                }
                //�����ֵ��������0�ľ��룬����ʽ�������Ƚ�����1�ľ�����Ϊ�����ÿ����������1��ֵ���޸�ʱ�򣬿����ֻ�Ӱ���Ǹ�ֵ��Χ��ֵ���ٴμ����������
                que.add(new int[]{r,c});
                matrix.get(r).set(c,matrix.get(cur[0]).get(cur[1]) + 1);
            }
        }
        return matrix;
    }
}