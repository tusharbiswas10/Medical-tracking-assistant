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

class MyFrame extends Frame{
TextField tl,t2,t3,t4,t5;DDetails dd;
MyFrame(){
super("Form");setVisible(true);
Label alabel = new Label("Paitent Name");
tl = new TextField();
//t1.setSize(20,20);
Label blabel = new Label("Age");
t2 = new TextField();
Label clabel = new Label("phone no");
t3 = new TextField();
Label dlabel = new Label("Sex");
t4 = new TextField();
Label elabel = new Label("Description");
t5 = new TextField();

setLocation(100,200);
this.setSize(500,500);
this.setVisible(true);
this.addWindowListener(new WindowSensor());
this.addMouseListener(new MouseSensor());
this.addMouseMotionListener(new MouseSensor());

Panel p1 =new Panel();
Panel p2 =new Panel();
Panel p3 =new Panel();
Panel p4 =new Panel();
Panel p5 =new Panel();

Button submitForm = new Button("submit");
Button bH = new Button(" Back to Home "); add(bH);
Button b = new Button(" BACK "); add(b);
p1.add(alabel);
p1.add(tl);
p2.add(blabel);
p2.add(t2);
p3.add(clabel);
p3.add(t3);
p4.add(dlabel);
p4.add(t4);
p5.add(elabel);
p5.add(t5);
add(p1);add(p2);
add(p3);add(p4);
add(p5);
setLayout(new FlowLayout());
//p2.setLayout(new FlowLayout());
//p3.setLayout(new FlowLayout());
//p4.setLayout(new FlowLayout());
//p5.setLayout(new FlowLayout());
this.add(submitForm);

submitForm.addActionListener(new ButtonSensor(this));
bH.addActionListener(new ButtonSensor(this));
b.addActionListener(new ButtonSensor(this));
}
void setP(DDetails dd){
this.dd=dd;
}
DDetails getP(){
return dd;
}

}
