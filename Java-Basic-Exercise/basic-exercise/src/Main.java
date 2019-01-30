import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.forEach(Test::log);
    }
}
