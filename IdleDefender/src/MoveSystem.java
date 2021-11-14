import java.awt.*;

/**
 * Class with the move algorithm.  Utilizes a java Robot to make subtle movements every 60 seconds.
 */
public class MoveSystem {

    public int minutes = 0;

    public void setStart(boolean start) {
        this.start = start;
    }

    boolean start = true;

    public MoveSystem(){}

    public void move_mouse() throws AWTException, InterruptedException {

        //Added new thread for the Mouse movement timer to run on to give us the ability to stop.
        Thread thread = new Thread(new Runnable() {

            final Robot robot = new Robot();

            @Override
            public void run() {
                int SLEEP_MILLIS = 60 * 1000;

                while (start) {
                    Point point = MouseInfo.getPointerInfo().getLocation();
                    robot.mouseMove(point.x, point.y);
                    System.out.println("Minutes Idle: " + minutes);
                    minutes++;
                    try {
                        Thread.sleep(SLEEP_MILLIS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
