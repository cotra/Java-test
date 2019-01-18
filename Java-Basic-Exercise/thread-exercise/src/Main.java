public class Main {

    public static void main(String[] args) {
        SubThread3 subThread3 = new SubThread3();
        System.out.println(subThread3.t.isAlive());
        try {
            subThread3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Main Thread Interrupted");
        }
        System.out.println(subThread3.t.isAlive());
    }
}
