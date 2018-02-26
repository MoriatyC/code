package concurrentdemo;
/**
 * @author cmh
 *
 */
class PrintService {
    volatile int flag = 1;
    public synchronized void printA() {
        while (true) {
            
            if (flag == 1) {
                System.out.println("A");
                flag = 2;
                this.notifyAll();
            } 
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    public  synchronized void printB() {
        while (true) {
            
            if (flag == 2) {
                System.out.println("B");
                flag = 3;
                this.notifyAll();
            } 
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public synchronized void printC() {
        while (true) {
            
            if (flag == 3) {
                System.out.println("C");
                flag = 1;
                this.notifyAll();
            } 
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
class ThreadA extends Thread{
    PrintService ps;
    public ThreadA(PrintService ps) {
        this.ps = ps;
    }
    @Override 
    public void run() {
        ps.printA();
    }
}
class ThreadB extends Thread{
    PrintService ps;
    public ThreadB(PrintService ps) {
        this.ps = ps;
    }
    @Override 
    public void run() {
        ps.printB();
    }
}
class ThreadC extends Thread{
    PrintService ps;
    public ThreadC(PrintService ps) {
        this.ps = ps;
    }
    @Override 
    public void run() {
        ps.printC();
    }
}
public class PrintABC {
    public static void main(String[] args) {     
        PrintService ps = new PrintService();
        Thread a = new ThreadA(ps);
        Thread b = new ThreadB(ps);
        ThreadC c = new ThreadC(ps);
        a.start();
        b.start();
        c.start();
    }
}
