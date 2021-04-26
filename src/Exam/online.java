/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class online extends JFrame implements ActionListener {

    JLabel l;
    JRadioButton jb[] = new JRadioButton[5];

    JButton b1, b2;
    ButtonGroup bg;

    int count = 0, current = 0, x = 1, y = 1;
    int m[] = new int[15];

    online(String s) {

        super(s);
        l = new JLabel();
        add(l);

        bg = new ButtonGroup();

        for (int i = 0; i < 5; i++) {

            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }

        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");

        b1.addActionListener(this);
        b2.addActionListener(this);

        add(b1);
        add(b2);

        set();

        l.setBounds(30, 40, 450, 45);

        jb[0].setBounds(50, 100, 200, 20);
        jb[1].setBounds(50, 130, 200, 20);
        jb[2].setBounds(50, 160, 200, 20);
        jb[3].setBounds(50, 190, 200, 20);

        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);

        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {

            if (check()) {
                count++;
            }

            current++;

            set();

            if (current == 9) {

                b1.setEnabled(false);
                b2.setText("Result");
            }
        }

        if (e.getActionCommand().equals("Bookmark")) {

            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);

            add(bk);
            bk.addActionListener(this);

            m[x] = current;
            x++;
            current++;

            set();

            if (current == 9) {

                b1.setEnabled(false);
                b2.setText("Result");
            }

            setVisible(false);
            setVisible(true);
        }

        for (int i = 0, y = 1; i < x; i++, y++) {

            if (e.getActionCommand().equals("Bookmark" + y)) {

                if (check()) {
                    count = count + 1;
                }

                current = m[y];
                set();

                ((JButton) e.getSource()).setEnabled(false);
            }
        }

        if (e.getActionCommand().equals("Result")) {

            if (check()) {
                count++;
            }

            current++;
            JOptionPane.showMessageDialog(this, "Final Marks = " + count + " / 10");
            System.exit(0);
        }
    }

    void set() {

        jb[4].setSelected(true);

        if (current == 0) {

            l.setText("<html> 1/ Which player was the first to both bowl a hat-trick and score a century <br> &emsp; in a test match? </html>");
            jb[0].setText("Alok Kapali");
            jb[1].setText("Shakib Al Hasan");
            jb[2].setText("Sohag Gazi");
            jb[3].setText("Farhad Reza");
        }

        if (current == 1) {

            l.setText("<html> 2/ Against which country did Bangladesh play their first-ever test match in <br> &emsp; November 2000? </html>");
            jb[0].setText("India");
            jb[1].setText("Sri Lanka");
            jb[2].setText("Pakistan");
            jb[3].setText("South Africa");
        }

        if (current == 2) {

            l.setText("<html> 3/ Who was the 1st bowler to take a hat-trick in a test match for Bangladesh? </html>");
            jb[0].setText("Mustafizur Rahman");
            jb[1].setText("Alok Kapali");
            jb[2].setText("Sohag Gazi");
            jb[3].setText("Mohammad Rafique");
        }

        if (current == 3) {

            l.setText("<html> 4/ Who was the first batsman to hit a century in a test match for Bangladesh? </html>");
            jb[0].setText("Mohammad Ashraful");
            jb[1].setText("Aminul Islam Bulbul");
            jb[2].setText("Naimur Rahman Durjoy");
            jb[3].setText("Khaled Mashud Pilot");
        }

        if (current == 4) {

            l.setText("<html> 5/ Who was the first-ever test captain of Bangladesh? </html>");
            jb[0].setText("Naimur Rahman Durjoy");
            jb[1].setText("Khaled Mashud Pilot");
            jb[2].setText("Habibul Bashar");
            jb[3].setText("Khaled Mahmud Sujon");
        }

        if (current == 5) {

            l.setText("<html> 6/ In which year was Mashrafe Bin Mortaza appointed captain of Bangladesh <br> &emsp; in ODIs for the first time? </html>");
            jb[0].setText("2014");
            jb[1].setText("2012");
            jb[2].setText("2010");
            jb[3].setText("2013");
        }

        if (current == 6) {

            l.setText("<html> 7/ Against which country did Bangladesh played their first ODI match, on 31 <br> &emsp; March 1986? </html>");
            jb[0].setText("West Indies");
            jb[1].setText("India");
            jb[2].setText("Pakistan");
            jb[3].setText("Srilanka");
        }

        if (current == 7) {

            l.setText("<html> 8/ Which batsman hit the first-ever double century in a test match for <br> &emsp; Bangladesh? </html>");
            jb[0].setText("Mohammad Ashraful");
            jb[1].setText("Mushfiqur Rahim");
            jb[2].setText("Shakib Al Hasan");
            jb[3].setText("Tamim Iqbal");
        }

        if (current == 8) {

            l.setText("<html> 9/ Who broke the record for the highest individual score of a <br> &emsp; Bangladeshi batsman in ODI, when he scored 176 on 6 March 2020? </html>");
            jb[0].setText("Tamim Iqbal");
            jb[1].setText("Liton Das");
            jb[2].setText("Shakib Al Hasan");
            jb[3].setText("Soumya Sarkar");
        }

        if (current == 9) {

            l.setText("<html> 10/ Mashrafe Bin Mortaza was the most successful ODI captain when <br> &emsp; he retired in March 2020. What was the winning percentage of the <br> &emsp; 'Narail Express', as ODI captain for Bangladesh? </html>");
            jb[0].setText("51.27%");
            jb[1].setText("58.13%");
            jb[2].setText("60.35%");
            jb[3].setText("55.09%");
        }
    }

    boolean check() {

        if (current == 0) {
            return (jb[2].isSelected());
        }

        if (current == 1) {
            return (jb[0].isSelected());
        }

        if (current == 2) {
            return (jb[1].isSelected());
        }

        if (current == 3) {
            return (jb[1].isSelected());
        }

        if (current == 4) {
            return (jb[0].isSelected());
        }

        if (current == 5) {
            return (jb[2].isSelected());
        }

        if (current == 6) {
            return (jb[2].isSelected());
        }

        if (current == 7) {
            return (jb[1].isSelected());
        }

        if (current == 8) {
            return (jb[1].isSelected());
        }

        if (current == 9) {
            return (jb[1].isSelected());
        }

        return false;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

        new online("Online Quiz (10 points)");
    }
}
