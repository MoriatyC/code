package distributed;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/** 
* @author : Menghui Chen 
* @version ：2018年4月25日 下午3:18:07 
* @Description:
* 原理
* SnowFlake算法产生的ID是一个64位的整型，结构如下（每一部分用“-”符号分隔）：
* 
* 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000
* 1位标识部分，在java中由于long的最高位是符号位，正数是0，负数是1，一般生成的ID为正数，所以为0；
* 41位时间戳部分，这个是毫秒级的时间，一般实现上不会存储当前的时间戳，而是时间戳的差值（当前时间-固定的开始时间），这样可以使产生的ID从更小值开始；41位的时间戳可以使用69年，(1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69年；
* 10位节点部分，Twitter实现中使用前5位作为数据中心标识，后5位作为机器标识(5位datacenterId和5位workerId)，可以部署1024个节点；
* 12位序列号部分，支持同一毫秒内同一个节点可以生成4096个ID；
* SnowFlake算法生成的ID大致上是按照时间递增的，用在分布式系统中时，需要注意数据中心标识和机器标识必须唯一，这样就能保证每个节点生成的ID都是唯一的。或许我们不一定都需要像上面那样使用5位作为数据中心标识，5位作为机器标识，可以根据我们业务的需要，灵活分配节点部分，如：若不需要数据中心，完全可以使用全部10位作为机器标识；若数据中心不多，也可以只使用3位作为数据中心，7位作为机器标识。
*/
public class SnowFlake {
    /**
     * 起始时间戳
     */
    private static final long START_STAMP = System.currentTimeMillis();
    
    /**
     * 数据中心所占位数
     */
    private static final long DATA_CENTER_ID_BITS = 5L;
    
    /**
     * 数据中心最大id最大值
     */
    private static final long MAX_DATA_CENTER_ID = -1 ^ (-1 << DATA_CENTER_ID_BITS);
    /**
     * 机器表示所占位数
     */
    private static final long WORKER_ID_BITS = 5L;
    
    /**
     * 机器id最大值
     */
    private static final long MAX_WORKER_ID = -1 ^ (-1 << WORKER_ID_BITS);
    
    /**
     * 序列号所占位数
     */
    private static final long SEQUENCE_BITS = 12L;
    /**
     * 序列号最大值
     */
    private static final long MAX_SEQUENCE = -1 ^ (-1 << SEQUENCE_BITS);
    
    /**
     * 机器号左移位数
     */
    private static final long WORDER_LEFT = SEQUENCE_BITS;
    
    /**
     * 数据中心左移位数
     */
    private static final long DATA_CENTER_LEFT = SEQUENCE_BITS + WORDER_LEFT;
    /**
     * 时间戳左移位数
     */
    private static final long TIME_LEFT = SEQUENCE_BITS + WORDER_LEFT + DATA_CENTER_ID_BITS;
    
    /**
     * 数据中心id(0-31)
     */
    private long dataCenterId;
    /**
     * 机器id(0-31)
     */
    private long workderId;
    /**
     * 序列号(0-4095)
     */
    private long sequence = 0L;
    /**
     * 上次生成id的时间戳
     */
    private long lastStmp = -1L;
    public SnowFlake(long workerId, long dataCenter) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException("workerid can't be greater than MAX_WORKER_ID or less than 0");
        }
        if (dataCenter > MAX_DATA_CENTER_ID || dataCenter < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATA_CENTER_ID or less than 0");
        }
        this.workderId = workerId;
        this.dataCenterId = dataCenter;
    }
    /**
     * 生成下一个全局自增id
     * @return SnowFlakeId
     */
    public synchronized long nextId() {
        long curStmp = System.currentTimeMillis();
        while (curStmp < lastStmp) {
            curStmp = System.currentTimeMillis();
        }
        if (curStmp == lastStmp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0L) {
                curStmp = getNextMill();
            }
        } else {
            sequence = 0L;
        }
        lastStmp = curStmp;
        return ((lastStmp - curStmp) << TIME_LEFT) 
                | (dataCenterId << DATA_CENTER_LEFT)
                | (workderId << WORDER_LEFT)
                | sequence;
    }
    private long getNextMill() {
        long mill = System.currentTimeMillis();
        while (mill == lastStmp) {
            mill = System.currentTimeMillis();
        }
        return mill;
    }
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        SnowFlake snow = new SnowFlake(3, 3);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            snow.nextId();
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);
    }
}
