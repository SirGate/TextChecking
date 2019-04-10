/*
 * @author Tulupov Sergei
 */
package TextCheck;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static TextCheck.CheckOut.calculate;

public class UI extends JFrame
        implements ActionListener {

    private JFrame frame, helpframe,resframe;
    private JTextArea text1,text2,help,result;
    private Label head, head1;
    private JButton exit, check;


    public UI() {
        frame = this;
        setTitle("Text checking");
        setLocation(130, 80);
        setSize(1115, 620);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container cp = getContentPane();
        cp.setBackground(Color.LIGHT_GRAY);
        head = new Label("Text1:");
        cp.add(head);
        head1 = new Label("Text2:");
        cp.add(head1);
        text2 = new JTextArea();
        cp.add(text2);
        text2.setLineWrap(true);
        text2.setWrapStyleWord(true);
        text1 = new JTextArea();
        cp.add(text1);
        text1.setLineWrap(true);
        text1.setWrapStyleWord(true);
        check = new JButton("Check");
        cp.add(check);
        exit = new JButton("Exit");
        cp.add(exit);
        setDesign();
        createMenu();
        setVisible(true);
        helpframe = new JFrame("О программе:");
        helpframe.setSize(500, 140);
        helpframe.setLocation(400, 300);
        helpframe.setResizable(false);
        helpframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        help = new JTextArea();
        help.setLineWrap(true);
        help.setText("        Эта программа вычисляет процент совпадений слов  "
                + "из второго текста в первом.\n"
                + "Анализируются слова ,длиной больше 2-х символов.\n"
                + "Тексты можно скопировать из буфера обмена или ввести вручную в двух разных окнах.\n "
                +"    После ввода текстов, для осуществления вычисления необходимо нажать клавишу \"Check\".\n "
                +"       Результат выводится в появляющемся окне.\n"
                +"       Для выхода из программы нажмите клавишу \"Exit\"."
        );

        helpframe.add(help);
        help.setEditable(false);

        resframe = new JFrame();
        resframe.setSize(180, 50);
        resframe.setLocation(550, 300);
        resframe.setResizable(false);
        resframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        result = new JTextArea();
        result.setLineWrap(true);
        resframe.add(result);
        result.setEditable(false);

    }

    public static void main(String[] args) {
        new UI();
    }

    private void setDesign() {
        head.setBounds(25, 40, 250, 28);
        head1.setBounds(640, 40, 250, 28);
        text2.setBounds(640, 70, 450, 420);
        text1.setBounds(25, 70, 450, 420);
        check.setBounds(500, 33, 100, 25);
        exit.setBounds(500, 520, 100, 25);

        check.setActionCommand("Check");

        check.addActionListener(new ActionListener() {
            @Override
            public void
                    actionPerformed(ActionEvent ae) {
                String cmd = ae.getActionCommand();
                if (cmd.equals("Check")) {
            result.setText("    Процент совпадений: "
                    +calculate(text1.getText(),text2.getText())
                    +"%"
            );
                    resframe.setVisible(true);
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void
                    actionPerformed(ActionEvent ae) {
                String cmd = ae.getActionCommand();
                if (cmd.equals("Exit")) {
                    frame.dispose();
                }
            }
        });

    }

    private void createMenu() {
        JMenuItem first = new JMenuItem("About programm");
        first.addActionListener(this);
        JMenu view = new JMenu("Help");
        view.add(first);
        JMenuBar bar = new JMenuBar();
        bar.add(view);
        setJMenuBar(bar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("About programm")) {
            helpframe.setVisible(true);
        }
    }
}
