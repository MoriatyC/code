package concurrentdemo;

public class PrintABC {

    /**
     * @param args
     */
    public static void main(String[] args) {
        char[] chars = new char[] {'A', 'B', 'C', 'D'};
        Mutex mutex = new Mutex(chars);
        for(int i = 0; i < chars.length; i++) {
            Thread print = new PrintThread(chars[i], mutex);
            print.start();
        }
    }
}

class PrintThread extends Thread {
    char ch;
    Mutex mutex;
    public PrintThread(char ch, Mutex mutex) {
        this.ch = ch;
        this.mutex = mutex;
    }
    
    @Override
    public void run() {
        super.run();
        while(true) {
            synchronized (mutex) {
                if(mutex.next() != ch)
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                else {
                    try {
                        Thread.sleep(1 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\n" + mutex.nextPrint());
                    mutex.notifyAll();
                }
            }
        }
    }
}

class Mutex {
    char[] chars;
    int i = 0;
    
    public Mutex(char[] chars) {
        this.chars = chars;
    }
    
    public char next() {
        return chars[i % chars.length];
    }
    
    public char nextPrint() {
        return chars[i++ % chars.length];
    }
}