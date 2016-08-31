/**
 * Created by Administrator on 2016/8/31 0031.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        test3();
    }

    /**
     * IllegalThreadStateException多次启动前程会出错
     */
    private static void test() {
        Thread thread = new Thread();
        thread.start();
        thread.start();
        thread.start();
        thread.start();
    }

    private static void test2() {
        MyThread thread = new MyThread();
        Thread threadA = new Thread(thread);
        Thread threadB = new Thread(thread);
        Thread threadC = new Thread(thread);
        Thread threadD = new Thread(thread);
        thread.start();
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

    public static void test3() {
        MyThread3 thread3 = new MyThread3();
        thread3.start();
        try {
            thread3.sleep(2000);
            thread3.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyThread3 extends Thread {
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 500000; i++)
                System.out.println("i=" + (i + 1));
        }
    }

    private static class MyThread extends Thread {
        private int i = 5;

        @Override
        public void run() {
            super.run();
            System.out.println("i=" + (i--) + "threadName=" + Thread.currentThread().getName());
        }
    }
}
