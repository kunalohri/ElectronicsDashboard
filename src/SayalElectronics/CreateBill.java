package SayalElectronics;


import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CreateBill extends JFrame {

    public int FinalTotal =0;
    JLabel Name , Contact , Email , Address , RDate , RTime;
    JTextField tfname,tfContact,tfEmail,tfAddress , tfProductName , tfPrice , tfQuantity ,tfDescription , tfProductId , tfTotal , tfpaidamount , tfreturnamount;
    JTable jt;


    CreateBill(){
        super("Sayal Electronics : Generate Bill");
        setLayout(null);


        JLabel heading = new JLabel("Generate Bill");
        heading.setBounds(60,5,300,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,42));
        add(heading);

        // Current Date
        JLabel Date = new JLabel("Date");
        Date.setBounds(600,15,50,30);
        Date.setFont(new Font("Tahoma",Font.BOLD,12));
        add(Date);

        RDate = new JLabel("Date");
        RDate.setBounds(650,15,100,30);
        RDate.setFont(new Font("Tahoma",Font.BOLD,12));
        RDate.setForeground(Color.red);
        add(RDate);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now = LocalDate.now();
        RDate.setText(dtf.format(now));

        // Current Time

        JLabel Time = new JLabel("Time");
        Time.setBounds(600,55,50,30);
        Time.setFont(new Font("Tahoma",Font.BOLD,12));
        add(Time);

        RTime = new JLabel("Time");
        RTime.setBounds(650,55,100,30);
        RTime.setFont(new Font("Tahoma",Font.BOLD,12));
        RTime.setForeground(Color.blue);
        add(RTime);

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime noww = LocalTime.now();
        RTime.setText(dtf2.format(noww));

        // Buyer Details

        JLabel BuyerDetails = new JLabel("Buyer Details :");
        BuyerDetails.setBounds(25,75,300,30);
        BuyerDetails.setFont(new Font("Tahoma",Font.BOLD,18));
        add(BuyerDetails);

        Name = new JLabel("Name");
        Name.setBounds(30,115,50,30);
        Name.setFont(new Font("Tahoma",Font.BOLD,12));

        add(Name);

        tfname = new JTextField();
        tfname.setBounds(90,122,100, 20);
        tfname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = tfname.getText();
                try{
                    connection c = new connection();
                    ResultSet rs = c.s.executeQuery("select * from Customers where name like '"+name+"%'");
                    if (rs.next()){
                        tfname.setText(rs.getString(3));
                        tfContact.setText(rs.getString(2));
                        tfEmail.setText(rs.getString(4));
                        tfAddress.setText(rs.getString(5));
                    }
                    else{

                        tfContact.setText("");
                        tfEmail.setText("");
                        tfAddress.setText("");

                    }


                }catch(Exception io){
                    io.printStackTrace();
                }

            }
        });
        add(tfname);

        Contact = new JLabel("Contact");
        Contact.setBounds(210,115,50,30);
        Contact.setFont(new Font("Tahoma",Font.BOLD,12));
        add(Contact);

        tfContact = new JTextField();
        tfContact.setBounds(270,122,100, 20);
        tfContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Contact = tfContact.getText();
                try{
                    connection c = new connection();
                    ResultSet rs = c.s.executeQuery("select * from Customers where number like '"+Contact+"%'");
                    if (rs.next()){
                        tfname.setText(rs.getString(3));
                        tfContact.setText(rs.getString(2));
                        tfEmail.setText(rs.getString(4));
                        tfAddress.setText(rs.getString(5));
                    }
                    else{

                        tfname.setText("");
                        tfEmail.setText("");
                        tfAddress.setText("");

                    }


                    c.s.close();
                }catch(Exception io){
                    io.printStackTrace();
                }

            }
        });
        add(tfContact);

        Email = new JLabel("Email");
        Email.setBounds(380,115,50,30);
        Email.setFont(new Font("Tahoma",Font.BOLD,12));
        add(Email);

         tfEmail = new JTextField();
        tfEmail.setBounds(440,122,100, 20);
        add(tfEmail);

        Address = new JLabel("Address");
        Address.setBounds(550,115,50,30);
        Address.setFont(new Font("Tahoma",Font.BOLD,12));
        add(Address);

         tfAddress = new JTextField();
        tfAddress.setBounds(610,122,100, 20);
        add(tfAddress);

        // Product Details

        JLabel ProductDetails = new JLabel("Product Details :");
        ProductDetails.setBounds(25,145,300,30);
        ProductDetails.setFont(new Font("Tahoma",Font.BOLD,18));
        add(ProductDetails);

        JLabel ProductId = new JLabel("Id");
        ProductId.setBounds(30,180,50,30);
        ProductId.setFont(new Font("Tahoma",Font.BOLD,12));
        add(ProductId);

        tfProductId = new JTextField();
        tfProductId.setBounds(50,185,50, 20);
        tfProductId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pid = tfProductId.getText();
                try{
                    connection c = new connection();
                    ResultSet rs = c.s.executeQuery("select * from products where productId like '"+pid+"%'");
                    if (rs.next()){
                        tfProductId.setText(rs.getString(1));
                        tfProductName.setText(rs.getString(2));
                        tfQuantity.setText("1");
                        tfPrice.setText(rs.getString(3));
                        tfDescription.setText(rs.getString(6));
                    }
                    else{

                        tfProductName.setText("");
                        tfPrice.setText("");
                        tfQuantity.setText("");
                        tfDescription.setText("");

                    }
                    c.s.close();


                }catch(Exception io){
                    io.printStackTrace();
                }
            }
        });
        add(tfProductId);

        JLabel ProductName = new JLabel("Product Name");
        ProductName.setBounds(110,180,100,30);
        ProductName.setFont(new Font("Tahoma",Font.BOLD,12));
        add(ProductName);

        tfProductName = new JTextField();
        tfProductName.setBounds(210,185,100, 20);
        add(tfProductName);

        JLabel Price = new JLabel("Price");
        Price.setBounds(320,180,50,30);
        Price.setFont(new Font("Tahoma",Font.BOLD,12));
        add(Price);

        tfPrice = new JTextField();
        tfPrice.setBounds(360,185,50, 20);
        add(tfPrice);

        JLabel Quantity = new JLabel("Quantity");
        Quantity.setBounds(420,180,70,30);
        Quantity.setFont(new Font("Tahoma",Font.BOLD,12));
        add(Quantity);

        tfQuantity = new JTextField();
        tfQuantity.setBounds(480,185,50, 20);
        add(tfQuantity);

        JLabel Description = new JLabel("Description");
        Description.setBounds(540,180,70,30);
        Description.setFont(new Font("Tahoma",Font.BOLD,12));
        add(Description);

        tfDescription = new JTextField();
        tfDescription.setBounds(620,185,100, 20);
        add(tfDescription);




        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,250,50,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,8));
        add(l1);

        JLabel l2 = new JLabel("Description");
        l2.setBounds(90,250,50,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,8));
        add(l2);

        JLabel l3 = new JLabel("Rate");
        l3.setBounds(170,250,50,20);
        l3.setFont(new Font("Tahoma",Font.BOLD,8));
        add(l3);

        JLabel l4 = new JLabel("Quantity");
        l4.setBounds(230,250,50,20);
        l4.setFont(new Font("Tahoma",Font.BOLD,8));
        add(l4);

        JLabel l5 = new JLabel("Total");
        l5.setBounds(290,250,50,20);
        l5.setFont(new Font("Tahoma",Font.BOLD,8));
        add(l5);

        DefaultTableModel model = new DefaultTableModel();

        jt = new JTable(model);
        jt.setBounds(25,270,300,250);
        add(jt);
        model.addColumn("Col1");
        model.addColumn("Col2");
        model.addColumn("Col3");
        model.addColumn("Col4");
        model.addColumn("Col5");



        JButton Add = new JButton("Add");
        Add.setBackground(Color.black);
        Add.setForeground(Color.white);
        Add.setBounds(650,210,70,20);
        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int price = Integer.parseInt(tfPrice.getText());
                int quantity = Integer.parseInt(tfQuantity.getText());
                int total = price * quantity;
                DefaultTableModel model = (DefaultTableModel) jt.getModel();
                model.addRow(new Object[]{tfProductName.getText() , tfDescription.getText(),price ,quantity , total});
                FinalTotal = total+FinalTotal;
                String FinalTotal1 = String.valueOf(FinalTotal);
                tfTotal.setText(FinalTotal1);

            }
        });
        add(Add);

        // table


        // calculation details

        JLabel CalculationDetails = new JLabel("Calculation Details :");
        CalculationDetails.setBounds(340,255,300,30);
        CalculationDetails.setFont(new Font("Tahoma",Font.BOLD,18));
        add(CalculationDetails);

        JLabel Total = new JLabel("Total");
        Total.setBounds(340,295,80,30);
        Total.setFont(new Font("Tahoma",Font.BOLD,12));
        add(Total);

        tfTotal = new JTextField();
        tfTotal.setBounds(450,300,150, 20);
        add(tfTotal);


        JButton Save = new JButton("Save");
        Save.setBackground(Color.black);
        Save.setForeground(Color.white);

        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfname.getText();
                String Contact = tfContact.getText();
                String email = tfEmail.getText();
                String address = tfAddress.getText();
                String path = "E:\\";
                com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
                try {

                    PdfWriter.getInstance(doc , new FileOutputStream(path + "" + name+""+tfTotal.getText()+".pdf"));
                    doc.open();
                    Paragraph paragraph1 = new Paragraph("Sayal Electroincs                                                                          Contact Number : 7896541230\n ");
                    doc.add(paragraph1);
                    Paragraph paragraph2 = new Paragraph("Date and Time :"+RDate.getText()+" "+ RTime.getText()+"\n\n\nBuyer Details:..............................................................................................................................\n\n");
//                    Paragraph paragraph2 = new Paragraph("Date and Time :\n"+RDate.getText()+" "+ RTime.getText()+"\nBuyer Details:\nName:"+name+"\nContact No"+ Contact+"\nEmail"+email+"\nAddress"+address+"\n\n");
                    doc.add(paragraph2);
                    Paragraph paragarph99 = new Paragraph("Name : "+name+"\nContact No : "+ Contact+"\nEmail : "+email+"\nAddress : "+address+"\n\n");
                    doc.add(paragarph99);

                    Paragraph paragraph2777 = new Paragraph("Product Details:..............................................................................................................................\n\n\n");

                    doc.add(paragraph2777);

                    PdfPTable tbl = new PdfPTable(5);
                    tbl.addCell("Name");;
                    tbl.addCell("Description");
                    tbl.addCell("Rate");
                    tbl.addCell("Quantity");
                    tbl.addCell("Sub Total");

                    for (int i=0;i<jt.getRowCount();i++){

                        String n = jt.getValueAt(i, 0).toString();
                        String d = jt.getValueAt(i, 1).toString();
                        String r = jt.getValueAt(i, 2).toString();
                        String q = jt.getValueAt(i, 3).toString();
                        String s = jt.getValueAt(i, 4).toString();
                        tbl.addCell(n);
                        tbl.addCell(d);
                        tbl.addCell(r);
                        tbl.addCell(q);
                        tbl.addCell(s);

                    }
                    doc.add(tbl);
                    Paragraph paragar788 = new Paragraph("\n\nAmount Details:..............................................................................................................................\n\n");
                    doc.add(paragar788);
                    Paragraph paragraph3 = new Paragraph("\nTotal : "+tfTotal.getText()+" Rs\nPaid Amount : "+tfpaidamount.getText()+" Rs\nReturn Amount : "+tfreturnamount.getText()+" Rs\n\n\n\n\n\n\n\n\n");

                    doc.add(paragraph3);

                    Paragraph paragjg7883 = new Paragraph(" ................................................................Thanks you for visiting!....................................................");
                    doc.add(paragjg7883);

                    JOptionPane.showMessageDialog(null,"Bill generated !");
                    setVisible(false);
                    new  CreateBill().setVisible(true);







                }
                catch (Exception eh){
                    eh.printStackTrace();
                }
                doc.close();
            }
        });
        Save.setBounds(620,300,70,20);
        add(Save);


        JLabel paidamount = new JLabel("Paid Amount");
        paidamount.setBounds(340,330,80,30);
        paidamount.setFont(new Font("Tahoma",Font.BOLD,12));
        add(paidamount);

        tfpaidamount = new JTextField();
        tfpaidamount.setBounds(450,335,150, 20);
        tfpaidamount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paidAmount = tfpaidamount.getText();
                int z = Integer.parseInt(paidAmount);
                FinalTotal = z-FinalTotal;
                String FinalTotal1 = String.valueOf(FinalTotal);
                tfreturnamount.setText(FinalTotal1);
                tfreturnamount.setEditable(false);
            }
        });
        add(tfpaidamount);

        JButton Reset = new JButton("Reset");
        Reset.setBackground(Color.black);
        Reset.setForeground(Color.white);
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                CreateBill cb = new CreateBill();
            }
        });
        Reset.setBounds(620,335,70,20);
        add(Reset);

        JLabel returnamount = new JLabel("Return Amount");
        returnamount.setBounds(340,360,100,30);
        returnamount.setFont(new Font("Tahoma",Font.BOLD,12));
        add(returnamount);

        tfreturnamount = new JTextField();
        tfreturnamount.setBounds(450,365,150, 20);
        add(tfreturnamount);

        JButton Close = new JButton("Close");
        Close.setBackground(Color.black);
        Close.setForeground(Color.white);
        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AllFun af = new AllFun();
            }
        });
        Close.setBounds(620,365,70,20);
        add(Close);

















        getContentPane().setBackground(Color.white);
        setBounds(350,200,750,470);
        setVisible(true);
    }
    public static void main(String args[]){
        CreateBill cb = new CreateBill();
    }

}
