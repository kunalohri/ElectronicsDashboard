package SayalElectronics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddProducts extends JFrame {

    JTextField tfId , tfPrice, tfName, taDiscription;
    JLabel jlId , jlStatus, jlPrice, jlCatogry , jlName , jlDiscription;
    JComboBox cbCatogry , cbStatus;
    JButton AddProduct, Cancel;

    AddProducts(){
        super("Sayal Electronics Software");
        handeler h = new handeler();
        setLayout(null);

        JLabel heading = new JLabel("Add Product Details");
        heading.setBounds(60,25,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,28));
        add(heading);

        jlId = new JLabel("Product Id");
        jlId.setBounds(60,90,120,30);
        jlId.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(jlId);

        tfId = new JTextField();
        tfId.setBounds(200,90,150, 30);
        add(tfId);

        jlName = new JLabel("Product Name");
        jlName.setBounds(60,140,120,30);
        jlName.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(jlName);

        tfName = new JTextField();
        tfName.setBounds(200,140,150, 30);
        add(tfName);

        jlPrice = new JLabel("Price");
        jlPrice.setBounds(60,190,120,30);
        jlPrice.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(jlPrice);

        tfPrice = new JTextField();
        tfPrice.setBounds(200,190,150, 30);
        add(tfPrice);

        jlCatogry = new JLabel("Category");
        jlCatogry.setBounds(60,240,120,30);
        jlCatogry.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(jlCatogry);

        String str[]= {"Mobiles", "Laptops","LED TVs", "Window ACs", "Split ACs", "Washing Machines" , "Refrigerators" , "Fans" , "Mobile Accessories"};
        cbCatogry = new JComboBox(str);
        cbCatogry.setBounds(200,240,150,30);
        cbCatogry.setBackground(Color.white);
        add(cbCatogry);

        jlStatus = new JLabel("Status");
        jlStatus.setBounds(60,290,120,30);
        jlStatus.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(jlStatus);

        String str1[]= {"Available", "Not Available"};
        cbStatus = new JComboBox(str1);
        cbStatus.setBounds(200,290,150,30);
        cbStatus.setBackground(Color.white);
        add(cbStatus);

        jlDiscription = new JLabel("Description");
        jlDiscription.setBounds(60,340,120,30);
        jlDiscription.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(jlDiscription);

        taDiscription = new JTextField();
        taDiscription.setBounds(200,340,150, 30);
        add(taDiscription);


        AddProduct = new JButton("Add Product");
        AddProduct.setBackground(Color.black);
        AddProduct.setForeground(Color.white);
        AddProduct.addActionListener(h);
        AddProduct.setBounds(40,390,150,40);
        add(AddProduct);

        Cancel = new JButton("Back");
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(h);
        Cancel.setBounds(200,390,150,40);
        add(Cancel);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,20,450,450);
        add(image);



        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(350,200,850,540);
        setVisible(true);
    }
    public class handeler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==AddProduct){

                String Productid = tfId.getText();
                String name = tfName.getText();
                String price = tfPrice.getText();
                String cat = (String) cbCatogry.getSelectedItem();
                String status = (String) cbStatus.getSelectedItem();
                String Dis = taDiscription.getText();

                try{
                    connection con = new connection();
                    String query = "Insert into products values('"+Productid+"','"+name+ "','" +price+"','"+cat+"' , '"+status+ "','" +Dis+ "')";
                    String str = "select * from products where productId = '"+Productid+"'";
                    ResultSet rs = con.s.executeQuery(str);
                    if (rs.next()){
                        JOptionPane.showMessageDialog(null,"Product Already Exits !");
                        rs.close();
                        con.s.close();
                    }
                    else {
                        con.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Product added Successfully");
                        con.s.close();
                    }

                    con.s.close();

                }catch (Exception p){
                    p.printStackTrace();
                }




            }else if (e.getSource()==Cancel){

                setVisible(false);

            }
        }
    }
    public static void main(String args[]){
        AddProducts ap = new AddProducts();
    }

}
