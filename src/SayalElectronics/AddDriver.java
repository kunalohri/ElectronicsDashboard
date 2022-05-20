package SayalElectronics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Driver;
import java.sql.ResultSet;

public class AddDriver extends JFrame {

    JTextField tfname, tfphone, tfage, tfVehicle, tfadhar;
    JLabel jlname, jlage, jlphone, jlVechicle, jladhar, jlgender, jlStatus;
    JRadioButton rbmale, rbfemale;
    JComboBox cbbox;
    JButton submit, Cancel;

    AddDriver() {
        super("Sayal Electronics Software");
        setLayout(null);

        handelers h = new handelers();
        JLabel heading = new JLabel("Fill The Driver Details");
        heading.setBounds(60, 25, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(heading);

        jlname = new JLabel("Name");
        jlname.setBounds(60, 70, 120, 30);
        jlname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(jlname);

        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);

        jlage = new JLabel("Age");
        jlage.setBounds(60, 120, 120, 30);
        jlage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(jlage);

        tfage = new JTextField();
        tfage.setBounds(200, 120, 150, 30);
        add(tfage);

        jlphone = new JLabel("Phone");
        jlphone.setBounds(60, 320, 120, 30);
        jlphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(jlphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 320, 150, 30);
        add(tfphone);


        jlStatus = new JLabel("Status");
        jlStatus.setBounds(60, 220, 120, 30);
        jlStatus.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(jlStatus);


        String str[] = {"Available", "Not Available"};
        cbbox = new JComboBox(str);
        cbbox.setBounds(200, 220, 150, 30);
        cbbox.setBackground(Color.white);
        add(cbbox);

        jlVechicle = new JLabel("Vechicle");
        jlVechicle.setBounds(60, 270, 120, 30);
        jlVechicle.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(jlVechicle);

        tfVehicle = new JTextField();
        tfVehicle.setBounds(200, 270, 150, 30);
        add(tfVehicle);


        jlgender = new JLabel("Gender");
        jlgender.setBounds(60, 170, 120, 30);
        jlgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(jlgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(280, 170, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.white);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(200, 170, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);

        jladhar = new JLabel("AdharCard");
        jladhar.setBounds(60, 370, 120, 30);
        jladhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(jladhar);

        tfadhar = new JTextField();
        tfadhar.setBounds(200, 370, 150, 30);
        add(tfadhar);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(h);
        submit.setBounds(40, 420, 150, 40);
        add(submit);

        Cancel = new JButton("Back");
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.addActionListener(h);
        Cancel.setBounds(200, 420, 150, 40);
        add(Cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/4.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 20, 450, 450);
        add(image);


        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }


    public class handelers implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit) {
                String name = tfname.getText();
                String age = tfage.getText();
                String Vechile = tfVehicle.getText();
                String status = (String) cbbox.getSelectedItem();
                String phone = tfphone.getText();
                String aadhar = tfadhar.getText();
                String gender = null;
                if (rbfemale.isSelected()) {
                    gender = "Female";
                } else if (rbmale.isSelected()) {
                    gender = "Male";
                }
                try {
                    connection con = new connection();
                    String str = "select * from Driver where phone = '"+phone+"'";
                    ResultSet rs = con.s.executeQuery(str);

                    String query = "Insert into Driver values('" + name + "','" + age + "','" + gender + "','" + status + "' , '" + Vechile + "','" + phone  + "','" + aadhar + "')";

                    if (rs.next()){
                        JOptionPane.showMessageDialog(null,"Mobile Number Already Exits !");
                        rs.close();
                        con.s.close();
                    }
                    else {
                        con.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Driver added Successfully");
                        con.s.close();
                    }

                } catch (Exception k) {
                    k.printStackTrace();
                }
            } else if (e.getSource() == Cancel) {

                setVisible(false);

            }

        }

    }

}