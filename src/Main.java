import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Iterator;

public class Main {


    public static void main(String[] args) {

        int outerVar = 5;

        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(outerVar);
        };

        new Thread(runnable).start();

        outerVar = 39;

        System.out.println("outerVar = " + outerVar);

    }


}