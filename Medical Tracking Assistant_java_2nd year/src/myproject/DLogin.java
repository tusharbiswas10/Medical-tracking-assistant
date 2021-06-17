/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
class DLogin extends JFrame implements ActionListener{
    
    
    private Container c; MainHome m;
    private JButton button1,button2;
    private JLabel label1,label2,label3;
    private Font f1,f2;
    private JTextField t1;
    private JPasswordField t2; 
    String did;
    
         public void actionPerformed(ActionEvent e){
        if(e.getSource()==button1){
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/logininformation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
             String phone = t1.getText();                       
            String query = "SELECT * FROM `Doctorinformation` WHERE phone='"+phone+"'";
            //String query = "SELECT password FROM `logininformation` WHERE phone='dfg'";
            ResultSet rs = stmt.executeQuery(query);
            //rs.next();
            //System.out.println(rs);
            if(rs.next()){
             String s = rs.getString("password");
             String un = rs.getString("userName");
             did = rs.getString("DID");
             String s1 = String.valueOf(t2.getPassword());  
            if(s.equals(s1)){
                Dpage u= new Dpage(un,did); 
               
                u.setVisible(true);
                u.setD(this);
               
                this.dispose();
            }else {
            //JOptionPane.showMessageDialog(this,"Wrong information!");
            JOptionPane.showMessageDialog(this,"wrong password");
            }
            }
            else {
            //JOptionPane.showMessageDialog(this,"Wrong information!");
            JOptionPane.showMessageDialog(this,"Wrong Information");
            }
            /*for(int i=0;rs.next();++i){
                data[i][0] = rs.getInt("id");
                data[i][1] = rs.getString("name");
                data[i][2] = rs.getString("phone");
            }*/
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex);
        }
        }
        else if(e.getSource()==button2){
            getM().setVisible(true);
        }
     }
    
         public void initcomponent(){
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Log In Form");
        setResizable(false);
        
           
    }
        
	DLogin(){
	 initcomponent();
           c=this.getContentPane();
           c.setLayout(null);
           c.setBackground(new Color(19,34,59));
           f1=new Font("Arial",Font.BOLD,30);
           f2=new Font("Arial",Font.BOLD,22);
           
           label1=new JLabel();
           label1.setText("Log In");
           
           label1.setBounds(520, 150, 100, 50);
           label1.setForeground(Color.WHITE);
           label1.setFont(f1);
           
           label2=new JLabel();
           label2.setText("Mobile Number:");
           
           label2.setBounds(520, 190, 300, 70);
           label2.setForeground(Color.white);
           label2.setFont(f2);
           
           label3=new JLabel();
           label3.setText("Password:");
           
           label3.setBounds(520, 320, 300, 70);
           label3.setForeground(Color.white);
           label3.setFont(f2);
           
           t1=new JTextField();
           t1.setBounds(520, 250, 300, 30);
           t2=new JPasswordField();
           t2.setBounds(520, 380, 300, 30);
          // t2.setEchoChar('*');
           
           //img=new ImageIcon(getClass().getResource("medical-app-icon-design-ramotion.png"));
           //label4=new JLabel(img);
           //label4.setBounds(0,0,500,650);
           
           button1= new JButton("Log In");
           button1.setBounds(400,450,80,40);
           button1.setBackground(Color.white);
		   
		   button2= new JButton("Back to Home");
		   button2.setBounds(550,450,130,40);
           button2.setBackground(Color.white);
        
           c.add(label1);
           c.add(label2);
           c.add(label3);
           c.add(button1);
           c.add(button2);
           c.add(t1);
           c.add(t2);
           this.addWindowListener(new WindowSensor());
           this.addMouseListener(new MouseSensor());
           this.addMouseMotionListener(new MouseSensor());
            button1.addActionListener(this);
           button2.addActionListener(this);
     }
void setM(MainHome m){
this.m=m;
}
MainHome getM(){
return m;
}
	
}
