package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SumSwing extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton btn;

    public SumSwing() {
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t3.setEditable(false);

        btn = new JButton("OK");

        setLayout(new FlowLayout());

        add(new JLabel("First:"));
        add(t1);

        add(new JLabel("Second:"));
        add(t2);

        add(new JLabel("Sum:"));
        add(t3);

        add(btn);
        btn.addActionListener(this);

        setTitle("Sum of Two Numbers");
        setSize(250, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            t3.setText(String.valueOf(a + b));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter valid numbers only!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SumSwing::new);
    }
}
