public class SubThread3 implements Runnable {
    Thread t;

    SubThread3() {
        t = new Thread(this, "demo thread 3");
        t.start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println("Child Thread 3: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("exit Child Thread 3");
    }
}
