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

public class Welcome extends JFrame implements ActionListener {
    
    private Container c;
    private JButton button2;
    private JLabel label1,label2;
    private Font f1,f2;
     
    public void initcomponent(){
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Welcome");
        setResizable(false);
                  
    }
        Welcome(){
           initcomponent();
           c=this.getContentPane();
           c.setLayout(null);
           c.setBackground(new Color(19,34,59));
           f1=new Font("Arial",Font.BOLD,40);
           f2=new Font("Cooper Black",Font.BOLD,60);
           
           label1=new JLabel();
           label1.setText("Welcome To");
           label1.setBounds(310,110,380,170);
           label1.setForeground(Color.WHITE);
           label1.setFont(f1);
           
           label2=new JLabel();
           label2.setText("Medical Tracking Assistant");           
           label2.setBounds(200, 200, 600, 200);
           label2.setForeground(Color.white);
           label2.setFont(f1);
		            
           button2= new JButton("Start");
           button2.setBounds(380,470,110,70);
           button2.setBackground(Color.white);   
    
           c.add(label1);
           c.add(label2);
           c.add(button2);
          
           this.addMouseListener(new MouseSensor());
           this.addMouseMotionListener(new MouseSensor());
           button2.addActionListener(this);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==button2){
            LogInForm s = new LogInForm();
            s.setVisible(true);
            dispose();
            s.setM(this);
        }
        
    }
      
}

