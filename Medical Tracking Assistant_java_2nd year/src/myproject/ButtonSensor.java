/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

class ButtonSensor implements ActionListener
{
MyFrame m;DLogin d;UPage u;DDetails dd;Welcome w;
Home h;MainHome mh;LogInForm p;SignIn si;
ButtonSensor(Welcome w){ this.w=w;}
ButtonSensor(Home h){ this.h=h;}
ButtonSensor(SignIn si){ this.si=si;}
ButtonSensor(UPage u){ this.u=u;}
ButtonSensor(MainHome mh){ this.mh=mh;}
ButtonSensor(LogInForm p){ this.p=p;}
ButtonSensor(DDetails dd){ this.dd=dd;}
ButtonSensor(DLogin d){ this.d=d;}
ButtonSensor(MyFrame m){ this.m=m; }
public void actionPerformed(ActionEvent ae){
if(ae.getActionCommand().equals("submit"))
{
//System.out.println(m.tp.getText().toString());
Home h= new Home();
h.setVisible(true);
h.setM(m);
m.dispose();
}
/*else if(ae.getActionCommand().equals("Log In"))
{
//System.out.println(m.tp.getText().toString());
//PLogin to UPage
UPage u= new UPage();
u.setVisible(true);
u.setP(p);
p.dispose();
}*/
else if(ae.getActionCommand().equals("Start"))
{
//System.out.println(m.tp.getText().toString());
//Welcome to MainHome
w.dispose();
MainHome mh = new MainHome();
mh.setVisible(true);
}
else if(ae.getActionCommand().equals("Back"))
{
//System.out.println(m.tp.getText().toString());
//
h.dispose();
h.getM().setVisible(true);

}
/*else if(ae.getActionCommand().equals("Sign Up"))
{
//System.out.println(m.tp.getText().toString());
//SignIn to uPage
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql:3306//localhost:3306/persondb", "root", "");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/LoginInformation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
            String name = si.t1.getText();
            String userName = si.t2.getText();
            
            String password = si.t3.getText();
            String phone = si.t4.getText();
            
            String query = "INSERT INTO person (name,userName, password, phone) VALUES ('"+name+"','"+userName+"','"+password+"', '"+phone+"')";            
            //System.out.println(query);
            if(stmt.executeUpdate(query)==1){
                JOptionPane.showMessageDialog(this, "Record Added"); 
				si.dispose();
UPage u =new UPage();
u.setVisible(true);
u.setP(si);
            }            
            else{
                JOptionPane.showMessageDialog(this, "Record Could not be Added");
            }
           
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(this, "Some Error Occured");
			System.out.println("Error: "+ ex.getMessage());
        }
        } */

else if(ae.getActionCommand().equals("User Login"))
{
//System.out.println(m.tp.getText().toString());
//MainHome to LogInForm
mh.dispose();
LogInForm p = new LogInForm();
p.setVisible(true);
p.setM(mh);

}
else if(ae.getActionCommand().equals("User Sign Up"))
{
//System.out.println(m.tp.getText().toString());
//MainHome to SignIn
mh.dispose();
SignIn si = new SignIn();
si.setVisible(true);
si.setM(mh);

}
else if(ae.getActionCommand().equals("Doctor Login"))
{
//System.out.println(m.tp.getText().toString());
//MainHome to DLogin
mh.dispose();
DLogin d = new DLogin();
d.setVisible(true);
d.setM(mh);

}

else if(ae.getActionCommand().equals("Back To Home"))
{
//System.out.println(m.tp.getText().toString());
//DLogin to MainHome
d.dispose();
d.getM().setVisible(true);

}

else if(ae.getActionCommand().equals(" Back to Home"))
{
//System.out.println(m.tp.getText().toString());
//DDetails to MainHome
dd.dispose();
dd.u.p.getM().setVisible(true);

}
else if(ae.getActionCommand().equals("Back to Home"))
{
//System.out.println(m.tp.getText().toString());
//LogInForm to MainHome
p.dispose();
p.getM().setVisible(true);

}
else if(ae.getActionCommand().equals(" Back to Home "))
{
//System.out.println(m.tp.getText().toString());
//MyFrame to MainHome
m.dispose();
m.dd.u.p.getM().setVisible(true);

}

else if(ae.getActionCommand().equals(" BACK"))
{
//System.out.println(m.tp.getText().toString());
//DDetails to UPage
dd.dispose();
dd.getP().setVisible(true);
}
else if(ae.getActionCommand().equals(" BACK "))
{
//System.out.println(m.tp.getText().toString());
//MyFrame to DDetails
m.dispose();
m.getP().setVisible(true);
}
else if(ae.getActionCommand().equals(" Back "))
{
//System.out.println(m.tp.getText().toString());
//SignIn to MainHome
si.dispose();
si.getM().setVisible(true);
}

else if(ae.getActionCommand().equals("Aply"))
{
//System.out.println(m.tp.getText().toString());
//DDetails to MyFrame
dd.dispose();
MyFrame m= new MyFrame();
m.setVisible(true);
m.setP(dd);

}

   /*else if(ae.getActionCommand().equals("CANCEL"))
System.out.println("Cancel clicked");*/
}
}
