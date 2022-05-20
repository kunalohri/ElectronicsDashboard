package SayalElectronics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame {

    JTextField username ;
    JPasswordField password;
    JButton login , Exit;


    Login(){
        super("Login To Sayal Electronics");
        getContentPane().setBackground(Color.white);

        setLayout(null);

        handelers h = new handelers();

        // Buttons Textareas and other things

         JLabel user = new JLabel("UserName");
        user.setBounds(40,20,100,30);
        add(user);

        username = new JTextField();
        username.setBounds(150,20,100,30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150,70,100,30);
        add(password);

         login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        add(login);

        Exit = new JButton("Exit");
        Exit.setBounds(180,150,120,30);
        Exit.setBackground(Color.black);
        Exit.setForeground(Color.white);
        add(Exit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(280,30,300,250);
        add(img);

        login.addActionListener(h);
        Exit.addActionListener(h);

        setBounds(500 , 200 ,600 , 300);
        setVisible(true);




    }

    public class handelers implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==login){

               String user =  username.getText();
               String pwd = password.getText();

               try{
                   connection c = new connection();
                   String query = "select * from login where username = '"+user+"' and password = '"+pwd+"'";
                   ResultSet rs = c.s.executeQuery(query);
                   if (rs.next()){
                       setVisible(false);
                       MainPage mp = new MainPage();

                   }else{
                       JOptionPane.showMessageDialog(null, "Invaild username or Password");
                   }

                   rs.close();
                   c.s.close();

               }catch (Exception g){
                   g.printStackTrace();
               }



            }else if(e.getSource() == Exit){
                setVisible(false);
            }






        }
    }
}
