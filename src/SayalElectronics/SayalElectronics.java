package SayalElectronics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SayalElectronics extends JFrame {

    SayalElectronics(){

        super("Sayal Electronics Software");

        handelers h = new handelers();
        setBounds(270 , 150 ,1000 , 498 );
        setLayout(null);



        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
        JLabel image = new JLabel(ic);
        add(image);
        image.setBounds(0,0,1000,498);


        JButton  jb = new JButton("Next");
        jb.setBounds(850,420,100,30);
        image.add(jb);
        jb.setBackground(Color.BLACK);
        jb.setForeground(Color.white);
        setVisible(true);



        jb.addActionListener(h);
    }
    public class handelers implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Login l = new Login();

        }
    }
}
