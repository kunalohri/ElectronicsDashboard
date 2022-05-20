package SayalElectronics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateProductStatus extends JFrame {

    JTextField productId , productname ,tfAvailin;
    JButton Upadate , Back;
    UpdateProductStatus(){

        super("Sayal Electronics Software");
        setLayout(null);
        JLabel heading = new JLabel("Update Product Status");
        heading.setBounds(60,25,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,22));
        add(heading);

        JLabel lproductId = new JLabel("Product ID");
        lproductId.setBounds(60,70,120,30);
        lproductId.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lproductId);

        productId = new JTextField();
        productId.setBounds(200,70,150, 30);
        productId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pid = productId.getText();
                try{
                    connection c = new connection();
                    ResultSet rs = c.s.executeQuery("select * from products where productId like '"+pid+"%'");
                    if (rs.next()){
                        productId.setText(rs.getString(1));
                        productname.setText(rs.getString(2));
                        tfAvailin.setText(rs.getString(5));

                    }
                    else{

                        productId.setText("");
                       productname.setText("");

                    }
                    c.s.close();


                }catch(Exception io){
                    io.printStackTrace();
                }

            }
        });
        add(productId);

        JLabel lProductname = new JLabel("Product Name");
        lProductname.setBounds(60,120,120,30);
        lProductname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lProductname);

        productname = new JTextField();
        productname.setBounds(200,120,150, 30);
        add(productname);

        JLabel Availiability = new JLabel("Availiability");
        Availiability.setBounds(60,170,120,30);
        Availiability.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Availiability);

        tfAvailin = new JTextField();
        tfAvailin.setBounds(200,170,150,30);
        add(tfAvailin);

        Upadate = new JButton("Update Status");
        Upadate.setBackground(Color.black);
        Upadate.setForeground(Color.white);

        Upadate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = productId.getText();
                String product = productname.getText();
                String Avail = tfAvailin.getText();

                try
                {
                    connection c = new connection();
                    c.s.executeUpdate("update products set status ='"+Avail+"' where productId =  '"+number+"'");
                    JOptionPane.showMessageDialog(null,"Product Status Updated !");
                    c.s.close();
                    setVisible(false);
                    AllFun af = new AllFun();
                }
                catch (Exception ep){
                    ep.printStackTrace();
                }


            }
        });
        Upadate.setBounds(40,220,150,40);
        add(Upadate);

        Back = new JButton("Back");
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AllFun af = new AllFun();
            }
        });
        Back.setBounds(200,220,150,40);
        add(Back);

        getContentPane().setBackground(Color.white);
        setBounds(350,200,420,330);
        setVisible(true);


    }
    public static  void main(String args[]){
        UpdateProductStatus ups = new UpdateProductStatus();
    }
}
