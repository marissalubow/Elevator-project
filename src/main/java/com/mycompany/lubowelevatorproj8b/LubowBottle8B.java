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
//imports for drawing Images
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;


public class LubowBottle8B
{
    //instance variables 
    private boolean closed; 
    private boolean containsKey; 
    private int x;
    private int y;
    private int vx;
    private int vy;
    private int diam;
    private Color col;
    private boolean examining;
    private ImageIcon bottle; 
    private ImageIcon openedBottle; 
    private ImageIcon emptyBottle; 

    //constructors 
    public LubowBottle8B(int xCoor, int yCoor, int d, Color c)
    {
        closed = true; 
        containsKey = true; 
        x = xCoor;
        y = yCoor;
        diam = d;
        col = c;     
        vx = 1; 
        vy = 1; 
        examining = false;
        bottle = new ImageIcon(LubowBottle8B.class.getResource("bottleCopy.jpg")); 
        openedBottle = new ImageIcon(LubowBottle8B.class.getResource("openedBottle.JPG"));  
        emptyBottle = new ImageIcon(LubowBottle8B.class.getResource("emptyBottle.jpg")); 
    }
   
    
    public boolean getExamined()
    {
        return examining;
    }
    public void setExamine(boolean e)
    {
        examining = e;
    }
    //toString 
    public String toString()
    {
        String output = "a discarded water bottle that is closed = " + closed + "there is something inside the bottle =  " + containsKey; 
        return output; 
    }
    //accessor method 
    public boolean getclosed()
    {
        return closed; 
    }
    public boolean getcontainsKey()
    {
        return containsKey; 
    }
    public int getX()
    {
        return x; 
    }
    public int getY()
    {
        return y; 
    }
    public int getDiam()
    {
        return diam; 
    }

    //interesting methods 
    private double distance(int x1, int y1, int x2, int y2)
    {
        double distance = Math.sqrt(Math.pow((x2-x1),2)+ Math.pow((y2-y1),2));
        return distance;
    }
    public int getCenterX()
    {
       int output = x+diam/2; //return x + diam/2;
       return output;
    }
    public int getCenterY()
    {
        int output = y+diam/2;
        return output;
    }
    
    public void drawSelf(Graphics g)    
    {
        Graphics2D g2d = (Graphics2D)g;
        //look
        if(closed && containsKey)
        {
            bottle.getImage();
            g2d.drawImage(bottle.getImage(), x, y, diam, diam, null);
             //g.setColor(col); 
            //g.fillOval(x, y, diam, diam); 
            
        }
        else if(closed == false && containsKey)
        {
            openedBottle.getImage();
            g2d.drawImage(openedBottle.getImage(), x, y, diam, diam, null);
            //g.setColor(Color.BLACK); 
            //g.fillOval(x, y, diam, diam); 
        }
        else 
        {
            emptyBottle.getImage();
            g2d.drawImage(emptyBottle.getImage(), x, y, diam, diam, null);
           // g.setColor(Color.red); 
            //g.fillOval(x, y, diam, diam); 
        }
       
        
        
        
       
           
       
    }
    
    public void drawSelfExamine(Graphics g)
    {
       Graphics2D g2d = (Graphics2D)g;

        if(examining == true)
        {
                //examine 
            if(closed && containsKey || closed && containsKey == false)
            {
                bottle.getImage();
                g2d.drawImage(bottle.getImage(), 300, 100, 400, 400, null);
                //g.setColor(col); 
                //g.fillOval(300, 100, 400, 400); 
                
            }
            else if(closed == false && containsKey)
            {
                openedBottle.getImage();
                g2d.drawImage(openedBottle.getImage(), 300, 100, 400, 400, null);
               // g.setColor(Color.BLACK); 
                //g.fillOval(300, 100, 400, 400); 
            }
            else 
            {
                emptyBottle.getImage();
                g2d.drawImage(emptyBottle.getImage(), 300, 100, 400, 400, null);
               // g.setColor(Color.red); 
                //g.fillOval(300, 100, 400, 400); 
            }
        }
    }
   
    public void open(boolean hasBottleOpener)
    {
        if(closed && hasBottleOpener == true)
        {
            //System.out.println("You use the bottle opener to screw off the cap of the bottle to open it");
            closed = false; 
        }
        else 
        {
            //System.out.println("You didn't use the bottle opener to open the cap off the bottle");
            closed = true; 
        }
    }
    
    public boolean takeKey()
    {
        boolean output; 
        
        if(closed)
        {
            //System.out.println("what key are you talking about ?? maybe try opening the bottle ");
            output = false; 
        }
        else 
        {
            //System.out.println("You take out the key from the bottle");
            output = true; 
            containsKey = false; 
        }
           
        return output;
    } 
    
    public boolean clickInside(int x, int y)
    {
        if(distance(x,y,getCenterX(), getCenterY()) <= diam/2)
        {
            return true;
        }
        else
            return false;
    }
    public boolean clickInsideExamine(int x, int y)
    {
        if(x >= 300 && x<= 700 && y >= 100 && y <= 500)
        {
            return true;
        }
        else 
            return false;
    }
    
            
}
