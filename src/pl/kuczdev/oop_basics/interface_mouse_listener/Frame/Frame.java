package pl.kuczdev.oop_basics.interface_mouse_listener.Frame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame implements MouseListener {
    private JLabel label;

    public Frame() {
        label = new JLabel("----");
        label.setBounds(10,10,250,50);
        this.add(label);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        String str = "Mouse clicked in X = " + x + ", Y = " + y;
        label.setText(str);
        System.out.println(str);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(250,200);
        frame.setTitle("Testowe okno");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.addMouseListener(frame);
    }
}
