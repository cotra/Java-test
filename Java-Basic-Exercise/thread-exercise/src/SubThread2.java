public class SubThread2 extends Thread {
    Thread t;

    SubThread2() {
        t = new Thread(this, "demo thread2");
        t.start();
    }

    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println("Child Thread2: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("exit Child Thread2");
    }
}
