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
import java.sql.PreparedStatement;
/**
 *
 * @author pc
 */
class Requests extends JFrame implements ActionListener{
    
    private Container c; Dpage m;
    private JPanel panel1;
    private JButton button1,button2;
    private JLabel label1,label2,label3;
    private Font f1,f2;
    private JTextArea t1;
	private JScrollPane scrollableList;
	private JList list;
        DefaultListModel<String> Rl = new DefaultListModel<>();
        String d,un1;int[] vl=new int[100];
        String[] s = new String[100];
        String[] un = new String[100];
       
    
        public void initcomponent(){
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Welcome ");
        setResizable(false);         
    }
    
    Requests(String u){
        un1=u;
        initcomponent();
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(19,34,59));
        f1=new Font("Arial",Font.BOLD,15);
        f2=new Font("Arial",Font.BOLD,25);
        button1 = new JButton("Back");
        button1.setBounds(70,580,120,40);
        button1.setBackground(Color.white);
        button1.setFont(f1);
        c.add(button1);
        t1 = new JTextArea("t1", 1, 20);
        
        list = new JList(Rl);
        scrollableList = new JScrollPane(list,
      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
        scrollableList.setBounds(250,50,600,500);
        scrollableList.setBackground(new Color(255,255,255));
        c.add(scrollableList);
        button2 = new JButton("Accept");
        button2.setBounds(670,580,120,40);
        button2.setBackground(Color.white);
        button2.setFont(f1);
        c.add(button2);
        
  
        
        label1=new JLabel("Appointments:");
      
        label1.setForeground(Color.RED);
        label1.setFont(f2);
        Dimension size = label1.getPreferredSize();
        label1.setBounds(5,20,size.width,size.height);
        
        button1.addActionListener(this);
        button2.addActionListener(this);
    }
	
	void setP(Dpage m){
this.m=m;
}
Dpage getP(){
return m;
}

void addR(String DID){
    try {
            d=DID;
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
             String phone = t1.getText();                       
            String query = "SELECT * FROM `alog` WHERE d_id='"+DID+"' and validity=0" ;
            
            //String query = "SELECT password FROM `logininformation` WHERE phone='dfg'";
            ResultSet rs = stmt.executeQuery(query);
            //stmt.executeQuery(query1);
            //String query1= "DELETE FROM `appoinments` WHERE DID='"+DID+"'";
            //rs.next();
            //System.out.println(rs);
            int count =0;
           for(int i=0;rs.next();++i){
               
             s[i] = rs.getString("ap_no");
             un[i] = rs.getString("p_id");
             vl[i]=rs.getInt("validity");
             count++;
           }
           for(int i=0;i<count;++i){
           String q = "SELECT name FROM `alog`,plog WHERE alog.p_id=plog.id and plog.id='"+un[i]+"'";
           System.out.println(q);
           ResultSet rs2 = stmt.executeQuery(q);
           rs2.next();
           String n=rs2.getString("name");
           
              
             Rl.addElement("Ap_NO: "+ s[i] + ".   p_id: "+un[i]+".   Name : "+n);
              
        
           }            /*for(int i=0;rs.next();++i){
                data[i][0] = rs.getInt("id");
                data[i][1] = rs.getString("name");
                data[i][2] = rs.getString("phone");
            }*/
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
			this.dispose();
			//getP().setVisible(true);
                        Dpage u= new Dpage(un1,d); 
               
                u.setVisible(true);
                u.setP(m.getP());
                u.setD(m.getD());
                        //getP().addR(d);
            
        }
        if(e.getSource()==button2){
		 try {
                     int sl=1;
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql:3306//localhost:3306/persondb", "root", "");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
            int i=list.getSelectedIndex();
            int ii=1;
            String srq= "SELECT MAX(sl_no) FROM `slog` WHERE d_id='"+d+"'";
            String stv= "UPDATE alog SET validity = '"+1+"' WHERE ap_no='"+s[i]+"'";
            if(stmt.executeQuery(srq)!=null){
             ResultSet rs = stmt.executeQuery(srq);
            
             if(rs.next()){
                 
                 sl = rs.getInt("MAX(sl_no)");
                 sl++;
             } rs.close();}
             stmt.executeUpdate(stv);
            String query = "INSERT INTO slog (sl_no,ap_no,d_id) VALUES ('"+sl+"','"+s[i]+"','"+d+"')"; 
            
          // String query1 = "delete from requests  where SL = ?";
           Rl.removeElementAt(i);
          
        //PreparedStatement preparedStmt = con.prepareStatement(query1);
        //int j = Integer.parseInt(s[i]);
        //preparedStmt.setInt(1, j);

      // execute the preparedstatement
      //preparedStmt.execute();
            System.out.println(query);
            if(stmt.executeUpdate(query)==1){
                JOptionPane.showMessageDialog(this, "Record Added"); 
            }
            else{
               JOptionPane.showMessageDialog(this, "Record Could not be Added");
            }
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
			System.out.println("Error: "+ ex.getMessage());
        }
            
        }
    }
    }


    

