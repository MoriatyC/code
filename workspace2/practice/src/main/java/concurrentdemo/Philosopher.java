package concurrentdemo;
/** 
* @author : Menghui Chen 
* @version ：2018年1月30日 下午8:03:06 
* @Description:
*/
public class Philosopher implements Runnable{
    static int[] arr = {1,1,1,1,1};
    int index;
    public Philosopher(int index) {
        this.index = index;
    }
    @Override
    public void run() {
        while (true) {
            eat(index);
            think(index);
        }
    }
    public void think(int index) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void eat(int index) {
        synchronized(arr){
            while (true) {
                if (arr[index] != 0) {
                    arr[index]--;
                    System.out.println(index + " :" + "拿到了左边的筷子");
                    break;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                if (arr[(index + 1) % 5] != 0) {
                    arr[(index + 1) % 5]--;
                    System.out.println("index" + "拿到了右边的筷子");
                    break;
                }
            }
            System.out.println(index + " is eating");
            arr[index]++;
            arr[(index + 1) % 5]++;
        }
        
    }
    public static void main(String[] args) {
        Thread p1 = new Thread(new Philosopher(1));
        Thread p2 = new Thread(new Philosopher(2));
        Thread p3 = new Thread(new Philosopher(3));
        Thread p4 = new Thread(new Philosopher(4));
        Thread p0 = new Thread(new Philosopher(0));
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p0.start();
    }
}
