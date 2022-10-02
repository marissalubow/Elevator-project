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

public class LubowButtons8B
{
    //instance variables 
    private boolean isNotPushed; 
    private int buttonsX;
    private int buttonsY;
    private int buttonsW;
    private int buttonsH;
    private Color col;
    private boolean examining;
    private ImageIcon buttons; 
    
    //constructors 
    public LubowButtons8B(int xCoor, int yCoor, int width, int height, Color c)
    {
        isNotPushed = true; 
        buttonsX = xCoor; 
        buttonsY = yCoor; 
        buttonsW = width; 
        buttonsH = height; 
        col = c; 
        examining = false;
        buttons = new ImageIcon(LubowBottle8B.class.getResource("buttons2.jpg")); 
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
        String output = "Elevator buttons that are not pushed = " + isNotPushed;
        return output; 
    }
    //accesor method
    public boolean getisnotpushed()
    {
        return isNotPushed; 
    }
    public int getbuttonsX() 
    {
        return buttonsX; 
    }
    public int getbuttonsY() 
    {
        return buttonsY; 
    }
    public int getbuttonsH() 
    {
        return buttonsH; 
    }
    public int getbuttonsW() 
    {
        return buttonsW; 
    }
    //interesting methods 
    private double distance(int x1, int y1, int x2, int y2)
    {
        double distance = Math.sqrt(Math.pow((x2-x1),2)+ Math.pow((y2-y1),2));
        return distance;
    }
    public int getCenterX()
    {
       int output = buttonsX + buttonsW/2;   
       return output;
    }
    public int getCenterY()
    {
        int output = buttonsY + buttonsH/2;
        return output;
    }
    public void drawSelf(Graphics g)    
    {
        Graphics2D g2d = (Graphics2D)g;
        //look 
        if(isNotPushed)
        {
            buttons.getImage();
            g2d.drawImage(buttons.getImage(), buttonsX, buttonsY, buttonsW, buttonsH, null);
          
           
            //g.setColor(col); 
            //g.fillRect(buttonsX,buttonsY,buttonsW,buttonsH);
        }
        else if(isNotPushed == false)
        {
             buttons.getImage();
             g2d.drawImage(buttons.getImage(), buttonsX, buttonsY, buttonsW, buttonsH, null);
             Font f = new Font("Arial", Font.BOLD, 15);
            
            //g.setColor(col); 
             //g.setColor(Color.yellow); 
             //g.fillRect(buttonsX,buttonsY,buttonsW,buttonsH); 
             
          
     
        }
        /*
        else 
        {
            g.setColor(Color.pink); 
            g.fillRect(buttonsX,buttonsY,buttonsW,buttonsH);
        }
 */
      
    }
   
    public void drawSelfExamine(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        if(examining == true)
        {
            //examine 
            if(isNotPushed)
            {
                buttons.getImage();
                g2d.drawImage(buttons.getImage(), 380, 100, 300, 400, null);
                 Font f = new Font("Arial", Font.BOLD, 10);
                 g.setFont(f); 
                 g.setColor(Color.red); 
                 g.drawString("OPEN DOOR            EMERGENCY            CLOSE DOOR", 400, 495);
                //g.setColor(col); 
                //g.fillRect(300,100,300,400);
            }
            else if(isNotPushed == false)
            {
                buttons.getImage();
                g2d.drawImage(buttons.getImage(), 380, 100, 300, 400, null);
                Font f = new Font("Arial", Font.BOLD, 10);
                g.setFont(f); 
                g.setColor(Color.red); 
                g.drawString("OPEN DOOR             EMERGENCY            CLOSE DOOR", 400, 495);
                //g.setColor(Color.yellow); 
                //g.fillRect(300, 100 ,300 ,400); //System.out.println("You see a tv to the right of the elevator doors it is on, the screen shows the following message: \nUncramble the following words: ELOTBT NERPOE \n(enter EXIT to stop playing)");
                
            }
           /*
            else 
                g.setColor(Color.pink); 
                g.fillRect(300, 100 ,300 ,400);
            //System.out.println("You see a tv on the wall to the right of the elevator doors it is on, the screen shows the following message: You Unscrambled the words! behind the tv is empty");
    */
        }

    }
    
   
    //turn on 
    public void push()
    {
         
        if(isNotPushed) 
        {
            //System.out.println("You press the button to turn on the tv"); 
            isNotPushed = false; 
        }
    }
    
    
    
    public boolean clickInside(int x, int y)
    {
        if(distance(x,y,getCenterX(), getCenterY()) <=  (buttonsW+buttonsH)/2)
        {
            return true;
        }
        else
            return false;
    }
    public boolean clickInsideExamine(int x, int y)
    {
        if(x >= 400 && x<= 700 && y >= 100 && y <= 500)
        {
            return true;
        }
        else 
            return false;
    }
    
    
}
