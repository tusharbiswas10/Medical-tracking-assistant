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
class PLogin extends Frame{
	TextField t1,t2;MainHome m;
	PLogin(){
		
		super("PLogin");
		setLocation(100,200);
this.setSize(500,500);
Label Elabel = new Label("Email");
this.add(Elabel);
t1 = new TextField();
add(t1);
Label pLabel = new Label("Password");
add(pLabel);
t2=new TextField(); add(t2);
setVisible(true);
Button submit = new Button("SUBMIT");
Button bh = new Button("Back to Home");

this.add(submit);
add(bh);
this.setLayout(new FlowLayout());
this.addWindowListener(new WindowSensor());
this.addMouseListener(new MouseSensor());
this.addMouseMotionListener(new MouseSensor());
submit.addActionListener(new ButtonSensor(this));
bh.addActionListener(new ButtonSensor(this));
     }
void setM(MainHome m){
this.m=m;
}
MainHome getM(){
return m;
}
	
}
