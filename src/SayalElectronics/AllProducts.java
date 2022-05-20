package SayalElectronics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;


public class AllProducts extends JFrame {

    JTable table;
    JButton Back;

    AllProducts(){

        super("Sayal electronics : All Products ");
        setLayout(null);
        getContentPane().setBackground(Color.white);

        handeler h = new handeler();



        JLabel l1 = new JLabel("Product Id");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Product Name");
        l2.setBounds(80,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Product Price");
        l3.setBounds(170,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("Category");
        l4.setBounds(260,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("Status");
        l5.setBounds(340,10,100,20);
        add(l5);

        JLabel l6 = new JLabel("Description");
        l6.setBounds(420,10,100,20);
        add(l6);

        table = new JTable();
        table.setBounds(5,40,500,350);
        add(table);

        try{
            connection c = new connection();
            ResultSet rs = c.s.executeQuery("select * from products");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i2 = i1.getImage().getScaledInstance(300,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,10,450,450);
        add(image);

        Back = new JButton("Back");
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.addActionListener(h);
        Back.setBounds(200,400,150,40);
        add(Back);




        setBounds(350,200,850,480);
        setVisible(true);


    }
    public class handeler implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

            setVisible(false);
            new AllFun();
        }
    }
    public static void main(String args[]){
        AllProducts ap = new AllProducts();
    }


}
