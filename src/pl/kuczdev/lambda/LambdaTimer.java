package pl.kuczdev.lambda;

import javax.swing.*;
import java.util.Date;

public class LambdaTimer extends JFrame {

    public static void main(String[] args) {
        LambdaTimer frame = new LambdaTimer();
        frame.setTitle("Timer");
        frame.setSize(300, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        frame.add(label);

        Timer timer = new Timer(1000, event -> {
            Date d = new Date();
            label.setText(d.toString());
            System.out.println(d.toString());
        });

        timer.start();
    }
}
