public class SubThread implements Runnable {
    Thread t;

    SubThread() {
        t = new Thread(this, "demo thread");
        t.start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println("Child Thread: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("exit Child Thread");
    }
}
