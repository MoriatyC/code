public class LogSystem {
    public List<Logger> db;
    public Map<String, Integer> map;
    public Map<String, String[]> tail;
    public LogSystem() {
        db = new ArrayList<>();
        map = new HashMap<>();
        tail = new HashMap<>();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
        tail.put("Year", new String[]{":00:00:00:00:00", ":12:31:23:59:59"});
        tail.put("Month", new String[]{":00:00:00:00", ":31:23:59:59"});
        tail.put("Day", new String[]{":00:00:00", ":23:59:59"});
        tail.put("Hour", new String[]{":00:00", ":59:59"});
        tail.put("Minute", new String[]{":00", ":59"});
        tail.put("Second", new String[]{"", ""});
    }
    
    public void put(int id, String timestamp) {
        Logger logger = new Logger(id, timestamp);
        db.add(logger);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> ret = new ArrayList<>();
        String start = s.substring(0, this.map.get(gra)) + this.tail.get(gra)[0];
        String end = e.substring(0, this.map.get(gra)) + this.tail.get(gra)[1];
        String tmp;
        for (Logger i: db) {
            tmp = i.time;
            if (tmp.compareTo(start) >= 0 && tmp.compareTo(end) <= 0) {
                ret.add(i.id);
            }
        }
        return ret;
    }
    static class Logger {
        int id;
        String time;
        public Logger(int id, String time) {
            this.id = id;
            this.time = time;
        }
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */