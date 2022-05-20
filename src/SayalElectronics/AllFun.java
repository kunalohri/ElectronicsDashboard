package SayalElectronics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllFun extends JFrame {

    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb10;
    AllFun(){
        super("Sayal Electronics Dashboard");
        getContentPane().setBackground(Color.white);
        setLayout(null);
        handler h = new handler();


        jb1 = new JButton("New Customer");
        jb1.setBounds(10,30,200,30);
        jb1.setBackground(Color.black);
        jb1.setForeground(Color.white);
        jb1.addActionListener(h);
        add(jb1);

        jb2 = new JButton("Customer Info");
        jb2.setBounds(10,70,200,30);
        jb2.setBackground(Color.black);
        jb2.setForeground(Color.white);
        jb2.addActionListener(h);
        add(jb2);

        jb3 = new JButton("Products");
        jb3.setBounds(10,110,200,30);
        jb3.setBackground(Color.black);
        jb3.setForeground(Color.white);
        jb3.addActionListener(h);
        add(jb3);

        jb4 = new JButton("Delivery Service");
        jb4.setBounds(10,150,200,30);
        jb4.setBackground(Color.black);
        jb4.setForeground(Color.white);
        add(jb4);

        jb5 = new JButton("Search Product");
        jb5.setBounds(10,190,200,30);
        jb5.setBackground(Color.black);
        jb5.setForeground(Color.white);
        jb5.addActionListener(h);
        add(jb5);

        jb6 = new JButton("Create Bill");
        jb6.setBounds(10,230,200,30);
        jb6.setBackground(Color.black);
        jb6.setForeground(Color.white);
        jb6.addActionListener(h);
        add(jb6);

        jb7 = new JButton("Update Product Status");
        jb7.setBounds(10,270,200,30);
        jb7.setBackground(Color.black);
        jb7.setForeground(Color.white);
        jb7.addActionListener(h);
        add(jb7);

        jb8 = new JButton("Employee Details");
        jb8.setBounds(10,310,200,30);
        jb8.setBackground(Color.black);
        jb8.setForeground(Color.white);
        jb8.addActionListener(h);
        add(jb8);


        jb10 = new JButton("Logout");
        jb10.setBounds(10,350,200,30);
        jb10.setBackground(Color.black);
        jb10.setForeground(Color.white);
        jb10.addActionListener(h);
        add(jb10);


        JLabel heading = new JLabel("Sayal Electronics Dashboard");
        heading.setBounds(11, 430, 800, 60);
        heading.setFont(new Font("Tahoma", Font.BOLD, 53));
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, 30, 400, 400);
        add(image);



        setBounds(350,200,800,550);
        setVisible(true);
    }
    public class handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == jb1){
                NewCustomer nc = new NewCustomer();
                setVisible(false);
            }
            else if(e.getSource()==jb3){
                AllProducts ap = new AllProducts();
                setVisible(false);
            }
            else if(e.getSource()==jb2){
                CustomerInfo ci = new CustomerInfo();
                setVisible(false);
            }
            else if(e.getSource()==jb8){
                employeeinfo ei = new employeeinfo();
                setVisible(false);
            }
            else if(e.getSource()==jb5){
                searchProduct sp = new searchProduct();
                setVisible(false);
            }
            else if (e.getSource()==jb10){
                setVisible(false);
                SayalElectronics se = new SayalElectronics();
            }
            else if(e.getSource()==jb6){
                setVisible(false);
                CreateBill cb = new CreateBill();
            }
            else if(e.getSource()==jb7){
                setVisible(false);
                UpdateProductStatus ups = new UpdateProductStatus();
            }
        }
    }
    public  static  void main(String args[]){
        AllFun af = new AllFun();
    }

}
