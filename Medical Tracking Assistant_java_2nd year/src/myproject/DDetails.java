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
class DDetails extends Frame{
	TextField t1,t2,t3;UPage u;
	DDetails(){
		
		super("DDetails");
		setLocation(100,200);
this.setSize(500,500);
Label Elabel = new Label("Select");
this.add(Elabel);

Button Aply = new Button("Aply");
Button bH = new Button(" Back to Home");
Button b = new Button(" BACK");

this.add(Aply);
this.add(bH);
add(b);

this.setLayout(new FlowLayout());
this.addWindowListener(new WindowSensor());
this.addMouseListener(new MouseSensor());
this.addMouseMotionListener(new MouseSensor());
Aply.addActionListener(new ButtonSensor(this));
b.addActionListener(new ButtonSensor(this));
bH.addActionListener(new ButtonSensor(this));
     }
void setP(UPage u){
this.u=u;
}
UPage getP(){
return u;
}
	
}
