package myproject;

import java.awt.Container;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class UPage extends JFrame implements ActionListener{
    private Container c;
    int cc;LogInForm p=null;SignIn si=null;
    private JPanel panel1;int uid;Popup po; JPanel pa;
    private JComboBox cb1,cb2,cb3;
     JRadioButton jrb1,jrb2,jrb3;
    private JButton button1,button2,button3,button4,button5;
    //private String [] AreaName={"SELECT AREA","Amrambag","Banani","Nikunjo","Malibag","Mirpur"};
    //private String [] DocName={"SELECT DOCTOR","Hasan","Kamal","Jamal","Tanim","Zarif"};
    //private String [] DeptName={"SELECT DEPARTMENT","General Medicine","Cardiology","Eyes Nose & Throat","Pediatrict","Orthopecdic"};
    private JScrollPane scrollableList;
	private JList list;
        DefaultListModel<String> Rl = new DefaultListModel<>();
       
    private String pid;
    private String sp;
    private String fee;
    private String did;
      String[] dn = new String[100];
       String[] ln = new String[100];
        String[] dpn = new String[100];
    private final String na;
    private final JButton button6;
        
     public void initcomponent(String name){
         
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle(name);
        setResizable(false);
        
           
    }
     
     UPage(String name,int udp){
         uid=udp;
         // System.out.println(uid);
         na=name;
        initcomponent(name);
        addj();
            c=this.getContentPane();
            c.setLayout(null);
           c.setBackground(new Color(19,34,59));
           
           cb1=new JComboBox(ln);
           cb1.setBounds(20, 110, 180, 30);
           c.add(cb1);
           jrb1=new JRadioButton();
           jrb1.setBounds(210, 110, 20, 30);
           c.add(jrb1);
           
            //cb2=new JComboBox(DocName);
            cb2=new JComboBox(dn);
           cb2.setBounds(20, 180, 180, 30);
           c.add(cb2);
           jrb2=new JRadioButton();
           jrb2.setBounds(210, 180, 20, 30);
           c.add(jrb2);
           
            //cb3=new JComboBox(DeptName);
            cb3=new JComboBox(dpn);
           cb3.setBounds(20, 250, 180, 30);
           c.add(cb3);
           jrb3=new JRadioButton();
           jrb3.setBounds(210, 250, 20, 30);
           c.add(jrb3);
           
             button1= new JButton("Search");
           button1.setBounds(50,320,80,40);
           button1.setBackground(Color.white);
           c.add(button1);
            button1.addActionListener((ActionListener) this);
            
                    list = new JList(Rl);
                    scrollableList = new JScrollPane(list,
      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
      JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
        scrollableList.setBounds(250,50,600,500);
        scrollableList.setBackground(new Color(255,255,255));
        c.add(scrollableList);
          button3 = new JButton("Accept");
        button3.setBounds(670,580,120,40);
        button3.setBackground(Color.white);
       // button3.setFont(f1);
        c.add(button3);  
        button3.addActionListener((ActionListener) this);
        
        button4 = new JButton("Dashboard");
        button4.setBounds(530,580,120,40);
        button4.setBackground(Color.white);
        c.add(button4);
        
        button4.addActionListener((ActionListener) this);
        
        button5 = new JButton("Profile");
        button5.setBounds(390,580,120,40);
        button5.setBackground(Color.white);
        c.add(button5);
        
        button6 = new JButton("Log Out");
        button6.setBounds(50,380,80,40);
        button6.setBackground(Color.white);
        c.add(button6);
        button6.addActionListener(this);
        
     }
     
     void addj(){
         try{
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
             String que = "SELECT * FROM `dlog`";
             dn[0]="get selected name";
             ln[0]="get selected location";
             dpn[0]="get selected department";
             ResultSet rs = stmt.executeQuery(que);
             for(int i=0;rs.next();++i){
              dn[i+1]=rs.getString("name");
               ln[i+1]=rs.getString("location");
                dpn[i+1]=rs.getString("department");
             }
             
         }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
			System.out.println("Error: "+ ex.getMessage());
        }
     }
     
       public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            try{
               Rl.removeAllElements();
            String s1,s2,s3;
            cc=0;
            s1=String.valueOf(cb1.getSelectedItem());
            s2=String.valueOf(cb2.getSelectedItem());
            s3=String.valueOf(cb3.getSelectedItem());
            //System.out.println(s1);
            //System.out.println(s2);
            //System.out.println(s3);
            String qu="SELECT * FROM `dlog` where";
     
            if(jrb1.isSelected()&&cb1.getSelectedIndex()>0){
                //if(c>0){ qu+=" and"; }
            qu+=" location='"+s1+"'";
                System.out.println(qu);
                cc++;
            }
            if(jrb2.isSelected()&&cb2.getSelectedIndex()>0){
                if(cc>0){ qu+=" and"; }
                     qu+=" name='"+s2+"'";
                System.out.println(qu);
                cc++;
                }
            if(jrb3.isSelected()&&cb3.getSelectedIndex()>0){
                    if(cc>0){ qu+=" and"; }
                     qu+=" department='"+s3+"'";
                System.out.println(qu);
                cc++;
                }
            if(cc==0){
                JOptionPane.showMessageDialog(null,"Select anything!");
            }
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(qu);
             for(int i=0;rs.next();++i){
             
              String un = rs.getString("name");
              sp = rs.getString("time");
              fee = rs.getString("fee");
              did = rs.getString("id");
             String sl = rs.getString("location");
             String sd = rs.getString("department");
             Rl.addElement("Name: "+un+".   Department : "+sd+".   Location : "+sl+".   Time : "+sp);
             }
            
            
        }
            catch (Exception ex) {
                if(cc!=0){
            JOptionPane.showMessageDialog(this, ex);
			System.out.println("Error: "+ ex.getMessage());
                }}       
        }
        if(e.getSource()==button3){
            try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
            
            int index = list.getSelectedIndex();
            String name=null;
            while(name==null||name.isEmpty()){
          name = JOptionPane.showInputDialog(
                        "What is your name?");
            } String phone=null;
             while(phone==null||phone.isEmpty()){
          phone = JOptionPane.showInputDialog(
                        "What is your phone no?");
          System.out.println(phone);
             }
             String query = "INSERT INTO plog (u_id,phone,name) VALUES ('"+uid+"','"+phone+"','"+name+"')"; 
         if(stmt.executeUpdate(query)==1){
                JOptionPane.showMessageDialog(this, "Record Added"); 
            }
            else{
               JOptionPane.showMessageDialog(this, "Record Could not be Added");
            } 
         String que = "SELECT * FROM `plog` WHERE phone='"+phone+"'";
         ResultSet rs = stmt.executeQuery(que);
         if(rs.next()){
                pid = rs.getString("id");
         } rs.close();
         String qal = "INSERT INTO alog (ap_time,total_fee,d_id,p_id) VALUES ('"+sp+"','"+fee+"','"+did+"','"+pid+"')"; 
         if(stmt.executeUpdate(qal)==1){
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
        if(e.getSource()==button4){
            this.dispose();
            DashBoard db = new DashBoard(uid);
            db.setVisible(true); 
            db.setP(this);
            //db.ud=uid;
        }
         if(e.getSource()==button6){
            this.dispose();
            LogInForm r = new LogInForm();
            r.setVisible(true);
           
        }
        
        
        }
     
       void setu(int up){
           uid=up;
       }
       
   void setP(LogInForm p){
this.p=p;
}
LogInForm getP(){
return p;
}
void setP(SignIn si){
this.si=si;
}
SignIn getS(){
return si;
}
      public static void main(String[]tus){
          UPage frame= new UPage("hello",1);
           frame.setVisible(true);     
        
    }
}

