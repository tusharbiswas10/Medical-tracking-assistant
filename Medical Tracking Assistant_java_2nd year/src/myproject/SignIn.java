/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

/**
 *
 * @author pc
 */
import com.sun.awt.AWTUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class SignIn extends JFrame implements ActionListener{
    MainHome m; LogInForm l;
    Container c;
    private JComboBox cb1,dp1,lc1,st1,ft1;
    private String [] type={"User","Doctor","Admin"};
    //private String [] time={"Select start time"};
    //private String [] ft={"Select finish time"};
    Vector ft = new Vector();
    Vector time = new Vector();
    String did;
    private String [] AreaName={"SELECT AREA","Amrambag","Banani","Nikunjo","Malibag","Mirpur"};
    private String [] DeptName={"SELECT DEPARTMENT","General Medicine","Cardiology","Eyes Nose & Throat","Pediatrict","Orthopecdic"};
    JInternalFrame j;
     JButton button1,button2,button3,button5;
     final JButton button4 = new JButton("SUBMIT");
     JLabel label1,label2,label3,label4,label5,label6,label7,label8;
     Font f1,f2,f3;
     JTextField t1,t2,t4,t6,t7,t8;
     JPasswordField t3,t5;
     int id;
	  public void actionPerformed(ActionEvent e){
            if(cb1.getSelectedItem()=="User"&&e.getSource()==button1){
                if(t1.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")){
                    JOptionPane.showMessageDialog(this,"Please give all the information");
                }
                else {
      try {
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql:3306//localhost:3306/persondb", "root", "");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
            String name = t1.getText();
            //String userName = t2.getText();
            
            String password = t3.getText();
            String phone = t4.getText();
            
            String query = "INSERT INTO ulog (name, password, phone) VALUES ('"+name+"','"+password+"', '"+phone+"')";            
            //System.out.println(query);
            if(stmt.executeUpdate(query)==1){
                JOptionPane.showMessageDialog(this, "Record Added"); 
				this.dispose();

            }            
            else{
                JOptionPane.showMessageDialog(this, "Record Could not be Added");
            }
             String que = "SELECT * FROM `ulog` WHERE phone='"+phone+"'";            
            //System.out.println(query);
            if(stmt.executeQuery(que)!=null){
                ResultSet rs = stmt.executeQuery(que);
         if(rs.next()){
                id = rs.getInt("id");
         } rs.close();

            }            
            else{
                JOptionPane.showMessageDialog(this, "Record Could not be Added");
            }
            
            UPage u =new UPage(name,id);
u.setVisible(true);
u.setP(this);
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex);
			System.out.println("Error: "+ ex.getMessage());
        } }
       // else if(e.getSource()==showButton){
          //  new ShowUsingObjectArray();            
       // }
	  }
            else if(cb1.getSelectedItem()=="Doctor"&&e.getSource()==button5){
                j = new JInternalFrame();
                j.setVisible(true);
                j.setTitle("Give Admin Access");
  
                t5 = new JPasswordField();
                t5.setBounds(10,10,320,70);
                t5.setBackground(Color.red);
                j.setLayout(null);
                j.setBounds(55,390,350,270);
                j.add(t5);
                c.add(j);
                 //button4= new JButton("SUBMIT");
                 button4.setBounds(130,100,80,40);
                 button4.setBackground(Color.white);
                 j.add(button4);
                 button4.setEnabled(true);
                 button1.setEnabled(false);
                 button4.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){
         
         try{
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost/data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
            // String phone = t1.getText(); 
             String s1 = String.valueOf(t5.getPassword());
            String query = "SELECT * FROM `admin` WHERE password='"+s1+"'";
            //String query = "SELECT password FROM `logininformation` WHERE phone='dfg'";
            ResultSet rs = stmt.executeQuery(query);
            //rs.next();
            //System.out.println(rs);
            if(rs.next()){
            // String s = rs.getString("password");
             //String un = rs.getString("userName");
             
            //if(s.equals(s1)){
                 button4.setEnabled(false);
                 button1.setEnabled(true);
                 j.dispose();
          
                 dp1=new JComboBox(DeptName);
           dp1.setBounds(20, 510, 180, 30);
           dp1.setFont(f2);
           dp1.setBackground(Color.red);
           dp1.setForeground(Color.WHITE);
           c.add(dp1); 
          
           lc1=new JComboBox(AreaName);
           lc1.setBounds(210, 510, 180, 30);
           lc1.setFont(f2);
           lc1.setBackground(Color.red);
           lc1.setForeground(Color.WHITE);
           c.add(lc1);
           
           time.add("Select start time");
           ft.add("Select finish time");
           for(int i=1;i<=24;i++){
               for(int j=0;j<=30;j+=30){
                
                   time.add(i-1+":"+j);
                   ft.add(i-1+":"+j);
                   
               }
           }
           st1=new JComboBox(time);
           st1.setBounds(100, 50, 170, 30);
           st1.setFont(f2);
           //st1.setBackground(Color.red);
           //st1.setForeground(Color.WHITE);
           c.add(st1);
           label3.setVisible(true);
           t2.setVisible(true);
            ft1=new JComboBox(ft);
           ft1.setBounds(280, 50, 180, 30);
           ft1.setFont(f2);
           //st1.setBackground(Color.red);
           //st1.setForeground(Color.WHITE);
           c.add(ft1);
           
           
                      }
         }
          catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
			System.out.println("Error: "+ ex.getMessage());
     }
                 } 
                 }
                 );
                 
             }
            else if(cb1.getSelectedItem()=="Doctor"&&e.getSource()==button1){
                if(t2.getText().equals("")||t1.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||dp1.getSelectedIndex()<=0||lc1.getSelectedIndex()<=0||st1.getSelectedIndex()<=0||ft1.getSelectedIndex()<=0){
                    JOptionPane.showMessageDialog(null,"Please give all the information");
                }
                else {
                      try {
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql:3306//localhost:3306/persondb", "root", "");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
            String name = t1.getText();
            String fee1 = t2.getText();
            
            String password = t3.getText();
            String phone = t4.getText();
            
            String department = (String) dp1.getSelectedItem();
            String location = (String) lc1.getSelectedItem();
            String time1 =(String) st1.getSelectedItem() + "-"+ (String) ft1.getSelectedItem();
           
            String query = "INSERT INTO dlog (name, password, phone,department,location,time,fee) VALUES ('"+name+"','"+password+"', '"+phone+"','"+department+"','"+location+"','"+time1+"','"+fee1+"')";            
            //System.out.println(query);
            
                          int rs1 = stmt.executeUpdate(query); 
             
            
            if(rs1!=0){
                JOptionPane.showMessageDialog(this, "Record Added"); 
				this.dispose();
                    
                  String query2 = "SELECT * FROM `dlog` WHERE phone='"+phone+"'";
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginInformation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            //Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query2);
            if(rs.next()){
            
                did = rs.getString("id");
                Dpage u =new Dpage(name,did);
                u.setVisible(true);
                 u.setP(this);
            }
            }            
            else{
                JOptionPane.showMessageDialog(this, "Record Could not be Added");
            }
           
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex);
			System.out.println("Error: "+ ex.getMessage());
        }
                
            } }
        
     }
    
    public void initcomponent(){
         
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Sign In Form");
        setResizable(false);
                  
    }
        SignIn(){
           initcomponent();
            c=this.getContentPane();
            c.setLayout(null);
           c.setBackground(new Color(19,34,59));
           f1=new Font("Arial",Font.BOLD,60);
           f2=new Font("Arial",Font.BOLD,18);
           f3=new Font("Arial",Font.BOLD,14);
           
           cb1=new JComboBox(type);
           cb1.setBounds(20, 110, 180, 30);
           cb1.setFont(f2);
           cb1.setBackground(Color.red);
           cb1.setForeground(Color.WHITE);
           c.add(cb1);
           
           label1=new JLabel("Sign Up");           
           label1.setBounds(70,230,250,180);
           label1.setForeground(Color.WHITE);
           label1.setFont(f1);
           
           label2=new JLabel();
           label2.setText("Name:");           
           label2.setBounds(514, 116, 100, 50);
           label2.setForeground(Color.white);
           label2.setFont(f2);
		   t1=new JTextField();
           t1.setBounds(514, 155, 300, 30);
		  
           label3=new JLabel();
           label3.setText("Fee:");
           label3.setBounds(514, 210, 130, 50);
           label3.setForeground(Color.white);
           label3.setFont(f2);
           t2=new JTextField();
           t2.setBounds(514, 250, 300, 30);
           label3.setVisible(false);
           t2.setVisible(false);
		   
		   label4=new JLabel();
           label4.setText("Password:");
           label4.setBounds(514, 304, 100, 50);
           label4.setForeground(Color.white);
           label4.setFont(f2);
           t3=new JPasswordField();
           t3.setBounds(514, 340, 300, 30);
		   t3.setEchoChar('*');
		   
		   label5=new JLabel();
           label5.setText("Contact Number:");
           label5.setBounds(514, 398, 200, 50);
           label5.setForeground(Color.white);
           label5.setFont(f2);
           t4=new JTextField();
           t4.setBounds(514, 438, 300, 30);
          
           button1= new JButton("Sign Up");
           button1.setBounds(550,532,80,40);
           button1.setBackground(Color.white);
            button5= new JButton("Change");
           button5.setBounds(210,110,80,30);
           button5.setBackground(Color.white);
		   
		   button2= new JButton("Already have an account");
           button2.setBounds(650,520,180,60);
           button2.setBackground(Color.white);
           button2.setVisible(false);
           
		   button3= new JButton(" Back ");
           button3.setBounds(650,532,80,40);
          
		   
           c.add(button3);
           c.add(label1);
           c.add(label2);
           c.add(label3);
		   c.add(label4);
		   c.add(label5);
           c.add(button1);
           c.add(button2);
           c.add(button5);
           c.add(t1);
           c.add(t2);
           c.add(t3);
           c.add(t4);
           
           /*if(t1.getText().equals("")) {
    button1.setEnabled(false);
}else {
    button1.setEnabled(true);
}*/
           
		   this.addMouseListener(new MouseSensor());
           this.addMouseMotionListener(new MouseSensor());
           //button1.addActionListener(new ButtonSensor(this));
           button1.addActionListener(this);
            button5.addActionListener(this);
           button3.addActionListener(new ButtonSensor(this));
           button2.addActionListener(new ButtonSensor(this));
        }
		void setM(LogInForm m){
this.l=m;
}
LogInForm getM(){
return l;
}
    
}

