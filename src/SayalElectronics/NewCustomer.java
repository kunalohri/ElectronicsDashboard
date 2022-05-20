package SayalElectronics;

import javax.lang.model.element.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class NewCustomer extends JFrame {

    JLabel Id, M_number , Name , Email , Address ;
    JTextField jtId , jtmnumber , jtname , jtAddress , jtEmail;
    JRadioButton rbmale, rbfemale;
    JButton AddCustomer , Back;

    NewCustomer (){



        super("Sayal Electronics Software");
        setLayout(null);
        handeler h = new handeler();


        JLabel heading = new JLabel("Fill The Customer Details");
        heading.setBounds(60, 25, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(heading);

        Id = new JLabel("Adhar No.");
        Id.setBounds(60,90,120,30);
        Id.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Id);

        jtId = new JTextField();
        jtId.setBounds(200,90,150, 30);
        add(jtId);

        M_number = new JLabel("Mobile Number");
        M_number.setBounds(60,140,120,30);
        M_number.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(M_number);

        jtmnumber = new JTextField();
        jtmnumber.setBounds(200,140,150, 30);
        add(jtmnumber);

        Name = new JLabel("Name");
        Name.setBounds(60,190,120,30);
        Name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Name);

        jtname = new JTextField();
        jtname.setBounds(200,190,150, 30);
        add(jtname);

        Email= new JLabel("Email");
        Email.setBounds(60,240,120,30);
        Email.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Email);

        jtEmail = new JTextField();
        jtEmail.setBounds(200,240,150, 30);
        add(jtEmail);


        Address = new JLabel("Address");
        Address.setBounds(60,290,120,30);
        Address.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Address);

        jtAddress = new JTextField();
        jtAddress.setBounds(200,290,150, 30);
        add(jtAddress);

        AddCustomer = new JButton("Add Customer");
        AddCustomer.setBackground(Color.black);
        AddCustomer.setForeground(Color.white);
        AddCustomer.addActionListener(h);
        AddCustomer.setBounds(40,340,150,40);
        add(AddCustomer);

        Back = new JButton("Back");
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.addActionListener(h);
        Back.setBounds(200,340,150,40);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/5.png"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,20,450,450);
        add(image);


        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(350,200,850,480);
        setVisible(true);

    }
    public class handeler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==AddCustomer){

                String Id = jtId.getText();
                String Number = jtmnumber.getText();
                String Nadme = jtname.getText();
                String Email = jtEmail.getText();
                String Addres = jtAddress.getText();


                try{
                    connection con = new connection();
                    String str = "select * from Customers where number = '"+Number+"'";
                    ResultSet rs = con.s.executeQuery(str);
                    String query = "Insert into Customers values('"+Id+"','"+Number+ "','" +Nadme+"','"+Email+"' , '"+Addres+ "')";
                    if (rs.next()){
                        JOptionPane.showMessageDialog(null,"Number Already Exits !");
                        rs.close();
                        con.s.close();
                    }else{
                        con.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Customer added Successfully");
                        con.s.close();
                    }

                    con.s.close();



                }catch (Exception p){
                    p.printStackTrace();
                }




            }else if (e.getSource()==Back){

                setVisible(false);
                AllFun ae = new AllFun();

            }
        }
    }
    public static void main(String args[]){
        NewCustomer nc = new NewCustomer();
    }
}
