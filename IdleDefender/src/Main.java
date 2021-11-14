import javax.swing.*;
import java.awt.*;

/**
 * Following is an application that uses a Java Robot to keep the machine from going idle.
 * It does this by making subtle movements every 60 seconds.
 *
 * @Author Will J Sanchez
 * @Version 1.2
 */
public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException {
        UI start = null;
        try{
            start = new UI();
            start.setTitle("Idle Defender! v1.1");
            start.setVisible(true);
            start.setBounds(10,10,370,200);
            start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            start.setResizable(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
