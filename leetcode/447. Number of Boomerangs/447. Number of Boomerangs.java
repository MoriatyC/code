public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = points.length;
        int ret = 0;
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < count; i ++)
        {
            for(int j = 0; j < count; j ++)
            {
                 if(j == i)
                {
                    continue;
                }
                int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +(points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                map.put(dis,map.getOrDefault(dis, 0) + 1);
            }
            for(int value: map.values())
            {
                if(value > 1)
                {
                    if(value == 2)
                    {
                        ret +=2;
                    }
                    else
                    {
                        ret += value * (value - 1);
                    }
                    
                }
            }
            map.clear();
          
        }
        
          return ret;
    }
}