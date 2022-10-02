/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lubowelevatorproj8b;

/**
 *
 * @author marissalubow
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
//imports for drawing Images
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class LubowDoors8B
{
    //instance variables 
    private boolean closed; 
    private boolean opened;
    private int doorsX;
    private int doorsY;
    private int doorsW;
    private int doorsH;
    private Color col;
    private ImageIcon doors; 
    private ImageIcon openedDoors; 
    private ImageIcon exit; 
    
    public LubowDoors8B(int xCoor, int yCoor, int width, int height, Color c)
    {
        closed = true;
        opened = false;
        doorsX = xCoor; 
        doorsY = yCoor; 
        doorsW = width; 
        doorsH = height; 
        col = c; 
        doors = new ImageIcon(LubowDoors8B.class.getResource("doors.jpg")); 
        openedDoors = new ImageIcon(LubowDoors8B.class.getResource("openedDoors.JPG"));
        exit = new ImageIcon(LubowDoors8B.class.getResource("hotel2.jpg"));
    }
    public String toString()
    {
        String output = "Elevator doors that are closed = " + closed;
        return output; 
    }
    //accesor method
    public boolean getclosed()
    {
        return closed; 
    }
    public boolean getopened()
    {
        return opened; 
    }
    public int getdoorsX() 
    {
        return doorsX; 
    }
    public int getdoorsY() 
    {
        return doorsY; 
    }
    public int getdoorsH() 
    {
        return doorsH; 
    }
    public int getdoorsW() 
    {
        return doorsW; 
    }
    //interesting methods 
    private double distance(int x1, int y1, int x2, int y2)
    {
        double distance = Math.sqrt(Math.pow((x2-x1),2)+ Math.pow((y2-y1),2));
        return distance;
    }
    public int getCenterX()
    {
       int output = doorsX + doorsW/2;   
       return output;
    }
    public int getCenterY()
    {
        int output = doorsY + doorsH/2;
        return output;
    }
    public void drawSelf(Graphics g)    
    {
        Graphics2D g2d = (Graphics2D)g;
        //look 
        if(closed)
        {
            doors.getImage();
            g2d.drawImage(doors.getImage(), doorsX, doorsY, doorsW, doorsH, null);
            
        }
        else if(closed == false && opened == false)
        {
             openedDoors.getImage();
             g2d.drawImage(openedDoors.getImage(), doorsX, doorsY, doorsW, doorsH, null);
        }
        else if(closed == false && opened == true)
        {
            exit.getImage();
            g2d.drawImage(exit.getImage(), 0, 0, 1000, 500, null );
            
            Font f = new Font("Arial", Font.BOLD, 50);
            g.setFont(f); 
            g.setColor(Color.red); 
            g.drawString("YOU WON!", 370, 250); 
            
             Font f1 = new Font("Arial", Font.BOLD, 15);
             g.setFont(f1); 
             g.setColor(Color.red); 
             g.drawString("You sucessfully escaped the elevator!!!!", 350, 290);
               
            
        }
       
    }
    public void open()
    {
         
        if(closed) //&& //win == true) 
        {
            
            closed = false; 
        }
        else 
        {
            closed = true; 
        }
    }
    public void exit(boolean open) 
    {
        if(opened == false && open == true)
        {
            //System.out.println("You use the bottle opener to screw off the cap of the bottle to open it");
            opened = true; 
        }
        else 
        {
            //System.out.println("You didn't use the bottle opener to open the cap off the bottle");
            opened = false;
        }
    }
    
    
 
    public boolean clickInside(int x, int y)
    {
        if(distance(x,y,getCenterX(), getCenterY()) <=  (doorsW+doorsH)/2)
        {
            return true;
        }
        else
            return false;
    }
    
    
    
    

}
