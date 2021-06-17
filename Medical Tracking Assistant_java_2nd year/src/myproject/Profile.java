/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

/**
 *
 * @author Tushar
 */
import java.awt.*;
import java.sql.*;
import javax.swing.*;


public class Profile extends JFrame {
    private Container c;
    private JLabel label1, label2, label3, label4, label5,s1, s2, s3, s4, s5;
    private JButton button1, button2;
    private JTextField text1, text2, text3, text4;
    private JPanel panel1;
    private Font font1,font2,font3;
	
    
    
    public void initcomponent(){
         
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Profile");
        setResizable(false);
        
           
    }
    
    Profile(){
    
        initcomponent();
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        
	font1 = new Font ("Arial",Font.BOLD,25);
	font2 = new Font ("Arial",Font.BOLD,25);
		
		
		
	panel1= new JPanel();
        panel1.setBounds(0,0,900,250);
        panel1.setBackground(new Color(19,34,59));
        c.add(panel1);
		
        button1= new JButton("Dashboard");
	button1.setBounds(600,600,100,40);
	c.add(button1);
        
	button2 = new JButton("Search");
	button2.setBounds(750,600,100,40);
	c.add(button2);
		
		
		
	label2 = new JLabel();
	label2.setText("Hello,");
	label2.setBounds(10,10,20,200);
	label2.setForeground(new Color(255,255,255));
	label2.setFont(font1);
	panel1.add(label2);
		
	label3 = new JLabel();
	label3.setText("Username         : ");
	label3.setBounds(20,300,200,50);
	label3.setForeground(new Color(0,0,0));
	label3.setFont(font2);
	c.add(label3);
        
        
        s1 = new JLabel();
	s1.setBounds(220,300,600,50);
	s1.setForeground(new Color(0,0,0));
        s1.setFont(font1);
	c.add(s1);
        
        s2 = new JLabel();
	s2.setBounds(220,350,600,50);
	s2.setForeground(new Color(0,0,0));
        s2.setFont(font1);
	c.add(s2);
        
        s3 = new JLabel();
	s3.setBounds(220,400,600,50);
	s3.setForeground(new Color(0,0,0));
        s3.setFont(font1);
	c.add(s3);
        
        s4 = new JLabel();
	s4.setBounds(220,450,600,50);
	s4.setForeground(new Color(0,0,0));
        s4.setFont(font1);
	c.add(s4);
        
         s5 = new JLabel();
	s5.setBounds(220,400,600,50);
	s5.setForeground(new Color(255,255,255));
        s5.setFont(font1);
	panel1.add(s5);
	
        
        
        try {
             
         
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
         
            Statement stmt = con.createStatement();
                             
            String query = "SELECT * FROM user";
            
            
            ResultSet rs = stmt.executeQuery(query);
           
             while(rs.next())
        {
            s1.setText(rs.getString("username"));
            s2.setText(rs.getString("age"));
            s3.setText(rs.getString("email"));
            s4.setText(rs.getString("contact"));
            s5.setText(rs.getString("username"));
        }
          
         }
           catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        
        
	label4 = new JLabel();
	label4.setText("Age                   : ");
	label4.setBounds(20,350,200,50);
	label4.setForeground(new Color(0,0,0));
	label4.setFont(font2);;
	c.add(label4);
		
	label4 = new JLabel();
	label4.setText("Email                 : ");
	label4.setBounds(20,400,200,50);
	label4.setForeground(new Color(0,0,0));
	label4.setFont(font2);;
	c.add(label4);
		
	label5 = new JLabel();
	label5.setText("Contact Number: ");
	label5.setBounds(20,450,250,50);
	label5.setForeground(new Color(0,0,0));
	label5.setFont(font2);;
	c.add(label5);
		
		
        
    }
    
    public static void main(String[]tus){
        Profile frame= new Profile();
        frame.setVisible(true);
        
       
        
    }

}