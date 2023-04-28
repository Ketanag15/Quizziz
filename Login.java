package quiz_app;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    int Frame_Width = 600;
    int Frame_Height = 500;

    JButton rule, back;
    JTextField textName;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(I1);
        image.setBounds(0, 0, Frame_Width, Frame_Height);
        add(image);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("QUIZIZZ");
        heading.setBounds(790, 60, 310, 45);
        heading.setFont(new Font("Viner Hand ITC ", Font.ITALIC, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(800, 150, 300, 25);
        name.setFont(new Font("Mongolian Baiti ", Font.BOLD, 20));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        textName = new JTextField();
        textName.setBounds(735, 200, 300, 25);
        textName.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        add(textName);

        rule = new JButton("Start");
        rule.setBounds(770, 270, 120, 25);
        rule.setBackground(new Color(30, 144, 254));
        rule.setForeground(new Color(255, 255, 255));
        rule.setSize(75, 25);
        rule.addActionListener(this);
        add(rule);

        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(new Color(255, 255, 255));
        back.setSize(75, 25);
        back.addActionListener(this);
        add(back);

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rule) {
            String name = textName.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();    //Class object without storing it into new variable.
    }
}