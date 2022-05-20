package SayalElectronics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
    JMenuItem Addemployee , Dashboard;

    MainPage(){

        super("Sayal Electronics Software");

        handelers h = new handelers();
        setBounds(0 , 0 , 1550,1000);
        setVisible(true);

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text = new JLabel("Sayal Electronics DashBoard");
        text.setBounds(250,350,1100,80);
        image.add(text);
        text.setFont(new Font("Tahoma",Font.BOLD,76));
        text.setForeground(Color.blue);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu electronics = new JMenu("Main");
        mb.add(electronics);
        electronics.setForeground(Color.red);

        Dashboard = new JMenuItem("Dashboard");
        electronics.add(Dashboard);
        Dashboard.addActionListener(h);




        JMenu Other = new JMenu("Menu");
        mb.add(Other);
        Other.setForeground(Color.blue);

        Addemployee = new JMenuItem("Add Employee");
        Other.add(Addemployee);
        Addemployee.addActionListener(h);

        JMenuItem AddDrivers = new JMenuItem("Add Driver");
        Other.add(AddDrivers);
        AddDrivers.addActionListener(h);

        JMenuItem AddProducts = new JMenuItem("Add Products");
        Other.add(AddProducts);
        AddProducts.addActionListener(h);

        setVisible(true);


    }
    public class handelers implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add Employee")){
                AddEmployee ae = new AddEmployee();
            }
            else if(e.getActionCommand().equals("Add Products")){
                AddProducts ap = new AddProducts();
            }
            else if (e.getActionCommand().equals("Add Driver")){
                AddDriver ad = new AddDriver();
            }
            else if(e.getActionCommand().equals("Dashboard")){
                AllFun af = new AllFun();
            }
        }

    }

}
