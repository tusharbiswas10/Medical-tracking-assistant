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
/**
 *implements ActionListener
 * @author pc
 */
public class Dpage extends JFrame implements ActionListener{
    
    private Container c; SignIn m;LogInForm dl;
    private JPanel panel1;
    private JButton button1,button2,button3;
    private JLabel label1,label2,label3;
    private Font f1,f2;
    private JTextField t1;
    
    private JScrollPane scrollableList;
	private JList list;
        DefaultListModel<String> Rl = new DefaultListModel<>();
        String d,un1;
        String[] s = new String[100];
        String[] un = new String[100];
    
    public void initcomponent(String un){
         un1=un;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Welcome "+un);
        setResizable(false);         
    }
    
    Dpage(String un,String did){
        initcomponent(un);
        d=did;
         addR(did);
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(19,34,59));
        f1=new Font("Arial",Font.BOLD,15);
        f2=new Font("Arial",Font.BOLD,25);
        button1 = new JButton("Requests");
        button1.setBounds(70,550,120,40);
        button1.setBackground(Color.white);
        button1.setFont(f1);
        c.add(button1);
        
        button3 = new JButton("Log Out");
        button3.setBounds(70,600,120,40);
        button3.setBackground(Color.white);
        button3.setFont(f1);
        c.add(button3);
        button3.addActionListener(this);
        
        list = new JList(Rl);
        scrollableList = new JScrollPane(list,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
        scrollableList.setBounds(250,50,600,500);
        scrollableList.setBackground(new Color(255,255,255));
        c.add(scrollableList);
        //panel1= new JPanel();
        //panel1.setLayout(null);
        //panel1.setBounds(250,50,900,600);
        //panel1.setBackground(new Color(255,255,255));
        //c.add(panel1);
        
        label1=new JLabel("Appointments:");
      
        label1.setForeground(Color.RED);
        label1.setFont(f2);
        //panel1.add(label1);
        Dimension size = label1.getPreferredSize();
        label1.setBounds(5,20,size.width,size.height);
        
          button1.addActionListener(this);
    }
    Dpage(String un){
        initcomponent(un);
         //addR(did);
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(19,34,59));
        f1=new Font("Arial",Font.BOLD,15);
        f2=new Font("Arial",Font.BOLD,25);
        button1 = new JButton("Requests");
        button1.setBounds(70,550,120,40);
        button1.setBackground(Color.white);
        button1.setFont(f1);
        c.add(button1);
        list = new JList(Rl);
        scrollableList = new JScrollPane(list,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
        scrollableList.setBounds(250,50,600,500);
        scrollableList.setBackground(new Color(255,255,255));
        c.add(scrollableList);
        //panel1= new JPanel();
        //panel1.setLayout(null);
        //panel1.setBounds(250,50,900,600);
        //panel1.setBackground(new Color(255,255,255));
        //c.add(panel1);
        
        label1=new JLabel("Appointments:");
      
        label1.setForeground(Color.RED);
        label1.setFont(f2);
        //panel1.add(label1);
        Dimension size = label1.getPreferredSize();
        label1.setBounds(5,20,size.width,size.height);
        
          button1.addActionListener(this);
    }
    
    
    /*public static void main(String [] a){
        Dpage d=new Dpage("Hi");
        d.setVisible(true);
    }*/
    
    	void setP(SignIn m){
this.m=m;
}
        void setD(LogInForm d){
this.dl=d;
}
SignIn getP(){
return m;
}
LogInForm getD(){
return dl;
}

void addR(String DID){
    try {
            d=DID;
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
             //String phone = t1.getText();                       
            String query = "SELECT * FROM `slog` WHERE d_id='"+DID+"'";
            //String query = "SELECT password FROM `logininformation` WHERE phone='dfg'";
            ResultSet rs = stmt.executeQuery(query);
            //rs.next();
            //System.out.println(rs);
           for(int i=0;rs.next();++i){
             s[i] = rs.getString("sl_no");
             un[i] = rs.getString("ap_no");
             Rl.addElement("SL: "+ s[i] + ".   Ap_NO: "+un[i]+".");
            
        
           }            /*for(int i=0;rs.next();++i){
                data[i][0] = rs.getInt("id");
                data[i][1] = rs.getString("name");
                data[i][2] = rs.getString("phone");
            }*/
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            this.dispose();
            Requests r = new Requests(un1);
            r.setVisible(true);
            r.setP(this);
            r.addR(d);
        }
        if(e.getSource()==button3){
            this.dispose();
            LogInForm r = new LogInForm();
            r.setVisible(true);
           
        }
    }
    
}
