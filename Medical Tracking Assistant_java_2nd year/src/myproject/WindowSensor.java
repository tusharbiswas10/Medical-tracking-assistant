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
class WindowSensor extends WindowAdapter{
public void windowClosing(WindowEvent we){
System.out.println("Window is closing");
System.exit(0);
}
}
