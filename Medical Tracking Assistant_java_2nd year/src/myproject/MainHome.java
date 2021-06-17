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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class MainHome extends JFrame{
	
	private Container c;
    private JButton uSP,uLogin,dLogin;
	
	MainHome(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Home");
        setResizable(false);

           c=this.getContentPane();
           c.setLayout(null);
           c.setBackground(new Color(19,34,59));	

uSP= new JButton("Sign Up");
uSP.setBounds(250,250,150,50);
uLogin = new JButton("Login");
uLogin.setBounds(550,250,150,50);
//dLogin = new JButton("Doctor Login");
//dLogin.setBounds(400,350,150,50);

c.add(uSP);
c.add(uLogin);
//c.add(dLogin);
//this.setLayout(new FlowLayout());
//this.addWindowListener(new WindowSensor());
this.addMouseListener(new MouseSensor());
this.addMouseMotionListener(new MouseSensor());
uLogin.addActionListener(new ButtonSensor(this));
uSP.addActionListener(new ButtonSensor(this));
//dLogin.addActionListener(new ButtonSensor(this));
     }

	
}
