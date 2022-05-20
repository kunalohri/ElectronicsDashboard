package SayalElectronics;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class searchProduct extends JFrame {
    JTable table;
    JLabel Search_Mobile;
    JTextField Tfsearch;
    JButton Back, search;

    searchProduct(){
        super("Sayal Electronics : Search Product Page");
        setLayout(null);
        handeler h = new handeler();
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Product Info");
        heading.setBounds(400,5 , 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        add(heading);

        Search_Mobile = new JLabel("Search :");
        Search_Mobile.setBounds(10,20,50,30);
        add(Search_Mobile);

        Tfsearch = new JTextField();
        Tfsearch.setBounds(60,22,120,30);
        add(Tfsearch);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/6.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        search = new JButton(i3);
        search.setBackground(Color.white);
        search.setForeground(Color.black);
        search.addActionListener(h);

        search.setBounds(182,22,30,30);
        add(search);


        JLabel l1 = new JLabel("Product Id");
        l1.setBounds(50,80,100,20);
        add(l1);

        JLabel l2 = new JLabel("Product Name");
        l2.setBounds(200,80,100,20);
        add(l2);

        JLabel l3 = new JLabel("Product Price");
        l3.setBounds(370,80,100,20);
        add(l3);

        JLabel l4 = new JLabel("Category");
        l4.setBounds(520,80,100,20);
        add(l4);

        JLabel l5 = new JLabel("Status");
        l5.setBounds(720,80,100,20);
        add(l5);

        JLabel l6 = new JLabel("Description");
        l6.setBounds(860,80,100,20);
        add(l6);

        table = new JTable();
        table.setBounds(10,100,980,350);
        add(table);

        try{
            connection c = new connection();
            ResultSet rs = c.s.executeQuery("select * from products");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        Back = new JButton("Back");
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        Back.addActionListener(h);
        Back.setBounds(420,500,150,40);
        add(Back);



        setBounds(350,200,1000,580);
        setVisible(true);
    }

    public class handeler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==Back){
                setVisible(false);
                AllFun af = new AllFun();
            }
            else if (e.getSource() == search){
                String id = Tfsearch.getText();
                try {
                    connection c = new connection();
                    String str = "select * from products where productId = '"+id+"'";
                    if (!id.isEmpty()){
                        ResultSet rs;
                        rs = c.s.executeQuery(str);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    else{
                        connection m = new connection();
                        ResultSet rs2 = m.s.executeQuery("select * from products");
                        table.setModel(DbUtils.resultSetToTableModel(rs2));

                    }


                }
                catch (Exception m){
                    m.printStackTrace();
                }
            }

        }
    }
    public  static void main(String args[]){
        searchProduct sp = new searchProduct();
    }
}
