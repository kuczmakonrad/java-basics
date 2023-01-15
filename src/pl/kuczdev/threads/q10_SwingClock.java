package pl.kuczdev.threads;

import javax.swing.*;
import java.time.LocalDateTime;

public class q10_SwingClock extends JFrame implements Runnable {
    private Thread thread;
    String hour, minutes, seconds;
    JLabel label;

    public q10_SwingClock()  {
        label = new JLabel("", JLabel.CENTER);
        label.setBounds(5,5,100,40);
        add(label);
        setSize(100,80);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
          while(true){
              LocalDateTime localDateTime = LocalDateTime.now();
              hour = String.format("%02d", localDateTime.getHour());
              minutes = String.format("%02d", localDateTime.getMinute());
              seconds = String.format("%02d", localDateTime.getSecond());
              label.setText(hour + ":" + minutes + ":"+ seconds);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        q10_SwingClock clock = new q10_SwingClock();
    }
}
