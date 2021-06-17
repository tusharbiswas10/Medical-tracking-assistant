package myproject;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import javax.swing.DefaultListModel;
import javax.swing.JTable;

import java.sql.*;

public class DashBoard extends JFrame implements ActionListener{
    
    private Container c;UPage p;
    int ud;
    private JLabel label1,label2,label3,label4;
    private JButton button1,button2;
    private JPanel panel1,panel2;
     private Font f1,f2;
     
    private JScrollPane scrollableList;
    private JList list;
        DefaultListModel<String> dl = new DefaultListModel<>();
     String[] pd= new String[100];
      String[] did= new String[100];
     String[] na= new String[100];
    String[] dbm=new String[100];
    String[] fee=new String[100];
    String[] phn=new String[100];
    String[] ti=new String[100];
    String[] lc=new String[100];
    String[] pn=new String[100];
   
    
    
     public void initcomponent(){
         
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Dashborad");
        setResizable(false);
        
           
    }
     
     
     DashBoard(int ui){
         ud=ui;
           initcomponent();
            System.out.println(ud);
         
           
             c=this.getContentPane();
         
         
             list = new JList(dl);
                    scrollableList = new JScrollPane(list,
         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
           JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
        scrollableList.setBounds(0, 240, 893, 430);
        scrollableList.setBackground(new Color(255,255,255));
        c.add(scrollableList);
        
        
         try {
             
         int count=0,ct=0,cd=0;
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
         
            Statement stmt = con.createStatement();
                             
            String query = "SELECT * FROM plog WHERE u_id= '"+ud+"'";
            System.out.println(query);
            
            if(stmt.executeQuery(query)!=null){
                ResultSet rs = stmt.executeQuery(query);
                for(int i=0;rs.next();++i){
                pd[i]=rs.getString("id");
                pn[i]=rs.getString("name");
                ct++;
               
            }}
            String qu = "SELECT * FROM alog WHERE p_id= '"+pd[0]+"'";
             
             if(stmt.executeQuery(qu)!=null){
                //ResultSet rs1 = stmt.executeQuery(qu);
                for(int j=0;j<ct;++j){
                    qu = "SELECT * FROM alog WHERE p_id= '"+pd[j]+"'";
                    System.out.println(qu);
                   ResultSet rs1 = stmt.executeQuery(qu);
                 for(int i=cd;rs1.next();++i){
                     
                did[i]=rs1.getString("d_id");
                System.out.println(did[i]);
                cd++;
                 }rs1.close();
                
                }
            }
             String que = "SELECT * FROM dlog WHERE id= '"+did[0]+"'";
              
             if(stmt.executeQuery(que)!=null){
                 for(int j=0;j<cd;++j){
                    que = "SELECT * FROM dlog WHERE id= '"+did[j]+"'";
                    System.out.println(que);
                    System.out.println(did[j]);
                   ResultSet rs2 = stmt.executeQuery(que);
                //ResultSet rs2 = stmt.executeQuery(que);
                for(int i=count;rs2.next();++i){
                na[i]=rs2.getString("name"); 
                dbm[i]=rs2.getString("department"); 
                lc[i]=rs2.getString("location"); 
                ti[i]=rs2.getString("time"); 
                phn[i]=rs2.getString("phone");
                fee[i]= rs2.getString("fee"); 
                count++;
                } rs2.close();
                 }
            }
             
            
            
           for(int i=0;i<count;++i){
             
             dl.addElement("Doctor: "+ na[i] + ".   Department: "+dbm[i]+".   Location: "+lc[i]+".   Time: "+ti[i]+".   Contact: "+phn[i]+".   Fee: "+fee[i]+".   Paitent Name: "+pn[i]);}
         }
           catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
            c.setLayout(null);
           c.setBackground(new Color(105,150,179));
            f1=new Font("Arial",Font.BOLD,30);
            f2=new Font("Arial",Font.BOLD,22);
            
           panel1= new JPanel();
           panel1.setBounds(0,0,900,200);
           panel1.setBackground(new Color(19,34,59));
           panel1.setLayout(null);
           c.add(panel1);
           
            label1=new JLabel();
           label1.setText("Dashboard");
           
           label1.setBounds(50, 50, 200, 50);
           label1.setForeground(Color.WHITE);
           label1.setFont(f1);
           panel1.add(label1);
           
            button1= new JButton("Profile");
           button1.setBounds(700,150,80,40);
           button1.setBackground(Color.white);
           panel1.add(button1);
           
            button2= new JButton("Search");
           button2.setBounds(600,150,80,40);
           button2.setBackground(Color.white);
          panel1.add(button2);
           button2.addActionListener((ActionListener) this);
           
            label2=new JLabel();
           label2.setText("Your Appointments:");
           
           label2.setBounds(20, 200, 400, 50);
           label2.setForeground(Color.WHITE);
           label2.setFont(f2);
           c.add(label2);
   
          
     }

      public void actionPerformed(ActionEvent e) {
          if(e.getSource()==button2){
              this.dispose();
              
                this.dispose();
                p.setVisible(true);
          }
      }
      
         void setP(UPage p){
this.p=p;
}
UPage getP(){
return p;
}
/*void setP(SignIn si){
this.si=si;
}
SignIn getS(){
return si;
}*/
          
        public static void main(String[]tus){
          DashBoard frame= new DashBoard(1);
           frame.setVisible(true);
        
       
        
    }
        
    }

           

   