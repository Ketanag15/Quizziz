package quiz_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {

    String[][] questions;
    String[][] answers;
    String[][] user_answers;

    {
        user_answers = new String[10][1];
        questions = new String[10][5];
        answers = new String[10][2];
    }

    ButtonGroup group;
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton next, LL, submit;
    public static int timer = 30;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    String name;

    Quiz(String name) {

        this.name = name;
        setBounds(200, 0, 1440, 1025);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        //QUESTIONS
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        //ANSWERS

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        //Option 1
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        //Option 2
        opt2 = new JRadioButton();
        opt2.setBounds(170, 550, 700, 30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        //Option 3
        opt3 = new JRadioButton();
        opt3.setBounds(170, 580, 700, 30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        //Option 4
        opt4 = new JRadioButton();
        opt4.setBounds(170, 610, 700, 30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        //NEXT Button
        next = new JButton("Next Question");
        next.setBounds(1100, 530, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 20));
        next.setForeground(new Color(2, 2, 2));
        next.setBackground(new Color(255, 255, 255));
        next.addActionListener(this);
        add(next);

        //LifeLine Button
        LL = new JButton("LifeLife 50-50");
        LL.setBounds(1100, 580, 200, 40);
        LL.setFont(new Font("Tahoma", Font.PLAIN, 20));
        LL.setForeground(new Color(2, 2, 2));
        LL.setBackground(new Color(255, 255, 255));
        LL.addActionListener(this);
        add(LL);

        //SUBMIT Button
        submit = new JButton("Submit");
        submit.setBounds(1100, 630, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        submit.setForeground(new Color(2, 2, 2));
        submit.setBackground(new Color(255, 255, 255));
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time Left:  " + timer + " seconds"; //30 seconds initially
        g.setColor(Color.red);
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Time Over, Next Question", 1100, 500);
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 30;
        } else if (timer < 0) {
            timer = 30;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {         //Question 9, then it is incremented, so it'll appear at question 10.
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if (count == 9) {      //10th question, user didn't submit the quiz. So it has to be submitted automatically.
                if (group.getSelection() == null) {
                    user_answers[count][0] = "";
                } else {
                    user_answers[count][0] = group.getSelection().getActionCommand();
                }

                for (int i = 0; i < user_answers.length; i++) {
                    if (user_answers[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }

                setVisible(false);
                new Score(name, score);

            } else {               //Next button case
                if (group.getSelection() == null) {
                    user_answers[count][0] = "";
                } else {
                    user_answers[count][0] = group.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ".");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        group.clearSelection();
    }

    public void actionPerformed(ActionEvent ae) {
        //next button is clicked
        if (ae.getSource() == next) {
            repaint();

            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (group.getSelection() == null) {
                user_answers[count][0] = "";
            } else {
                user_answers[count][0] = group.getSelection().getActionCommand();
            }

            if (count == 8) {    //Question 9, then it is incremented, so it'll appear at question 10.
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        }
        //LifeLine Button is clicked
        else if (ae.getSource() == LL) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) { //Question 1,3,5,7,8
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {                                                                  //Question 2,4,6,8,10
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            LL.setEnabled(false);
        }
        //Submit button is clicked
        else if (ae.getSource() == submit) {
            ans_given = 1;
            if (group.getSelection() == null) {
                user_answers[count][0] = "";
            } else {
                user_answers[count][0] = group.getSelection().getActionCommand();
            }

            for (int i = 0; i < user_answers.length; i++) {
                if (user_answers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}