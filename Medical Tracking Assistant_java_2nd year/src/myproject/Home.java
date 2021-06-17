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


class Home extends Frame{
TextField th;
MyFrame m;
Home(){super("Home");
	setVisible(true);

Label hlabel = new Label("Welcome to Home!!");
setLocation(100,200);
this.setSize(500,500);
Button backButton = new Button("Back");
this.add(hlabel);
this.add(backButton);
this.setLayout(new FlowLayout());
this.addWindowListener(new WindowSensor());
this.addMouseListener(new MouseSensor());
this.addMouseMotionListener(new MouseSensor());
backButton.addActionListener(new ButtonSensor(this));
}
void setM(MyFrame m){
this.m=m;
}
MyFrame getM(){
return m;
}
}
