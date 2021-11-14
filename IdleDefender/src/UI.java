import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User Interface the user will use to start / stop / exit the application.
 */
public class UI extends JFrame implements ActionListener {

    public MoveSystem move = new MoveSystem();

    //keeps track of how many minutes the app has been running.
//    int minutesLog = move.minutes;

//    Timer timer = new Timer();
//    TimerTask task = new TimerTask() {
//        @Override
//        public void run() {
//            minutesLog++;
//            int delay = 60 * 1000;
//            timer.schedule(task, delay);
//            started.repaint();
//        }
//    };

    //getContentPane returns a reference so we will create a reference for the container
    Container container = getContentPane();

    //Image displayed when app has started.
    Image logo = new ImageIcon(getClass().getClassLoader().getResource("stick_man_fight.gif")).getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
    ImageIcon icon = new ImageIcon(logo);
    JLabel startedImage = new JLabel(icon, JLabel.CENTER);

    //Header text for our window
    JLabel welcomeHeader = new JLabel("Welcome to Idle Defender");

    //labels for our selections
    JButton start_Button = new JButton("Start");
    JButton stop_Button = new JButton("Stop");
    JButton exit_Button = new JButton("Exit");
    JLabel running = new JLabel("Running.....");
    JLabel stopped = new JLabel("Stopped");

    //constructor for our window
    public UI() {
        setLayoutManager();
        setLocationAndSize();
        addComponentstoContainer();
        addActionEvent();
        running.setVisible(false);
        stopped.setVisible(false);
        startedImage.setVisible(false);
        container.setBackground(Color.WHITE);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        //setting location, Size & font for component using setBounds() method.
        welcomeHeader.setBounds(75, 20, 230, 20);
        welcomeHeader.setFont(new Font("Bodoni MT BlacT", Font.PLAIN, 18));
        start_Button.setBounds(75, 60, 100, 30);
        stop_Button.setBounds(190, 60, 100, 30);
        exit_Button.setBounds(130, 100, 100, 30);
        running.setBounds(155, 140, 100, 18);
        stopped.setBounds(155, 140, 100, 18);
        startedImage.setBounds(1, 103, 60, 60);
    }

    public void addComponentstoContainer() {
        container.add(welcomeHeader);
        container.add(start_Button);
        container.add(stop_Button);
        container.add(exit_Button);
        container.add(running);
        container.add(stopped);
        container.add(startedImage);
    }

    public void addActionEvent() {
        //adds action listener to components so when they are used things happen.

        start_Button.addActionListener(this);
        stop_Button.addActionListener(this);
        exit_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //what happens when Start button is pressed
        if (e.getSource() == start_Button) {
            //start the loop to move the mouse
            move.setStart(true);
            stopped.setVisible(false);
            running.setVisible(true);
            startedImage.setVisible(true);
            try {
                move.move_mouse();
            } catch (AWTException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        //what happens when stop button is pressed
        if (e.getSource() == stop_Button) {
            //stop the loop
            container.repaint();
            container.revalidate();
            running.setVisible(false);
            stopped.setVisible(true);
            startedImage.setVisible(false);
            move.setStart(false);
        }

        if (e.getSource() == exit_Button){
            //exits the program
            move.setStart(false);
            System.exit(1);
        }
    }
}

