package prepare;
/** 
* @author : Menghui Chen 
* @version ：2018年3月12日 下午5:43:32 
* @Description:
*/
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}

class Singleton4 {
    private Singleton4() {}
    private static class Holder {
        public static Singleton4 instance = new Singleton4();
    }
    public static Singleton4 getInstance() {
        return Holder.instance;
    }
}

class Singleton2 {
    private Singleton2() {}
    private static Singleton2 instance;
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

class Singleton3 {
    private Singleton3() {}
    private static volatile Singleton3 instance;
    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized(Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    } 
}

