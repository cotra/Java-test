import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream stream = new FileInputStream("D:\\testpalce\\Java-test\\Java-Basic-Exercise\\io-exercise\\src\\test.jpg");
            System.out.println(stream.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
