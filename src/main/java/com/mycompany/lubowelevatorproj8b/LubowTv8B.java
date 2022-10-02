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

public class LubowTv8B
{
    //instance variables 
    private boolean isOff; 
    private boolean containsBottleOpener; 
    private int tvX;
    private int tvY;
    private int tvW;
    private int tvH;
    private Color col;
    private boolean examining;
    private ImageIcon tv; 
    private ImageIcon tv2; 
    
    //constructors 
    public LubowTv8B(int xCoor, int yCoor, int width, int height, Color c)
    {
        isOff = true; 
        containsBottleOpener = true; 
        tvX = xCoor; 
        tvY = yCoor; 
        tvW = width; 
        tvH = height; 
        col = c; 
        examining = false;
        tv = new ImageIcon(LubowBottle8B.class.getResource("tv.jpg")); 
        tv2 = new ImageIcon(LubowBottle8B.class.getResource("tv2.JPG")); 
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
        String output = "a tv that is off = " + isOff + "there is something hidden behind the tv " + containsBottleOpener; 
        return output; 
    }
    //accesor method
    public boolean getisOff()
    {
        return isOff; 
    }
    public boolean getcontainsBottleOpener()
    {
        return containsBottleOpener; 
    }
    public int gettvX() 
    {
        return tvX; 
    }
    public int gettvY() 
    {
        return tvY; 
    }
    public int gettvH() 
    {
        return tvH; 
    }
    public int gettvW() 
    {
        return tvW; 
    }
    //interesting methods 
    private double distance(int x1, int y1, int x2, int y2)
    {
        double distance = Math.sqrt(Math.pow((x2-x1),2)+ Math.pow((y2-y1),2));
        return distance;
    }
    public int getCenterX()
    {
       int output = tvX + tvW/2;   
       return output;
    }
    public int getCenterY()
    {
        int output = tvY + tvH/2;
        return output;
    }
    public void drawSelf(Graphics g)    
    {
        Graphics2D g2d = (Graphics2D)g;
        //look 
        if(isOff && containsBottleOpener)
        {
            tv.getImage();
            g2d.drawImage(tv.getImage(), tvX, tvY, tvW, tvH, null);
            //g.setColor(col); 
            //g.fillRect(tvX,tvY,tvW,tvH);
        }
        else if(isOff == false && containsBottleOpener)
        {
            tv.getImage();
            g2d.drawImage(tv.getImage(), tvX, tvY, tvW, tvH, null);
             //g.setColor(Color.BLUE); 
             //g.fillRect(tvX,tvY,tvW,tvH); 
             
          
     
        }
        else 
        {
            tv2.getImage();
            g2d.drawImage(tv.getImage(), tvX, tvY, tvW, tvH, null);
            //g.setColor(Color.green); 
            //g.fillRect(tvX,tvY,tvW,tvH);
        }
 
      
    }
   
    public void drawSelfExamine(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        if(examining == true)
        {
            //examine 
            if(isOff && containsBottleOpener || isOff && containsBottleOpener == false)
            {
                tv.getImage();
                g2d.drawImage(tv.getImage(), 300, 100, 400, 200, null);
                //g.setColor(col); 
                //g.fillRect(300,100,400,200);
            }
            else if(isOff == false && containsBottleOpener)
            {
                tv.getImage();
                g2d.drawImage(tv2.getImage(), 300, 100, 400, 200, null);
                //g.setColor(Color.BLUE); 
                //g.fillRect(300, 100 ,400 ,200); //System.out.println("You see a tv to the right of the elevator doors it is on, the screen shows the following message: \nUncramble the following words: ELOTBT NERPOE \n(enter EXIT to stop playing)");
                
            }
            else if(isOff == false && containsBottleOpener == false)
            {
                tv2.getImage();
                g2d.drawImage(tv.getImage(), 300, 100, 400, 200, null);
               // g.setColor(Color.green); 
                //g.fillRect(300, 100 ,400 ,200);
            //System.out.println("You see a tv on the wall to the right of the elevator doors it is on, the screen shows the following message: You Unscrambled the words! behind the tv is empty");
            }
            else 
            {   
                tv.getImage();
                g2d.drawImage(tv.getImage(), 300, 100, 400, 200, null);
                //g.setColor(Color.green); 
                //g.fillRect(300, 100 ,400 ,200);
            //System.out.println("You see a tv on the wall to the right of the elevator doors it is on, the screen shows the following message: You Unscrambled the words! behind the tv is empty");
            }
        }
    }
    
   
    //turn on 
    public void turnOn()
    {
         
        if(isOff) 
        {
            //System.out.println("You press the button to turn on the tv"); 
            isOff = false; 
        }
    }
    
    public boolean takeBottleOpener()
    {
        boolean output; 
        
        if(isOff)
        {
            //System.out.println("What are you talking about?? maybe try turning on the tv "); 
            output = false;
        }
        else 
        {
            //System.out.println("You take the bottle opener out from behind the tv");
            containsBottleOpener = false; 
            output = true; 
        }
        
        return output; 
    }
    
    public boolean clickInside(int x, int y)
    {
        if(distance(x,y,getCenterX(), getCenterY()) <=  (tvW+tvH)/2)
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