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

public class LubowSafeBox8B
{
    //instance variables 
    private boolean hasNote; 
    private boolean isClosed; 
    private int safeBoxX;
    private int safeBoxY;
    private int safeBoxW;
    private int safeBoxH;
    private Color col;
    private boolean examining;
    private ImageIcon safeBox; 
    private ImageIcon openedSafe; 
    private ImageIcon safe2;
    
    //constructors 
    public LubowSafeBox8B(int xCoor, int yCoor, int width, int height, Color c)
    {
        hasNote = true; 
        isClosed= true; 
        safeBoxX = xCoor; 
        safeBoxY = yCoor; 
        safeBoxW = width; 
        safeBoxH = height; 
        col = c; 
        examining = false;
        safeBox = new ImageIcon(LubowBottle8B.class.getResource("safebox.jpg")); 
        openedSafe = new ImageIcon(LubowBottle8B.class.getResource("openedSafe.jpg")); 
        safe2 = new ImageIcon(LubowBottle8B.class.getResource("safe2.JPG")); 
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
        String output = "You see a safe connected to the elevator wall";  
        return output;        
    }
    
    //accessor methods 
    public boolean gethasNote()
    {
        return hasNote; 
    }
    public boolean getisclosed()
    {
        return isClosed; 
    }
    public int getsafeBoxX() 
    {
        return safeBoxX; 
    }
    public int getsafeBoxY() 
    {
        return safeBoxY; 
    }
    public int getsafeBoxH() 
    {
        return safeBoxH; 
    }
    public int getsafeBoxW() 
    {
        return safeBoxW; 
    }
    //interesting methods 
    private double distance(int x1, int y1, int x2, int y2)
    {
        double distance = Math.sqrt(Math.pow((x2-x1),2)+ Math.pow((y2-y1),2));
        return distance;
    }
    public int getCenterX()
    {
       int output = safeBoxX+ safeBoxW/2; 
       return output;
    }
    public int getCenterY()
    {
        int output = safeBoxY + safeBoxH/2;
        return output;
    }
    
    public void drawSelf(Graphics g)    
    {
        Graphics2D g2d = (Graphics2D)g;
        //look
        if(isClosed && hasNote)
        {
            safeBox.getImage();
            g2d.drawImage(safeBox.getImage(), safeBoxX, safeBoxY, safeBoxW, safeBoxH, null);
            //g.setColor(col); 
            //g.fillRect(safeBoxX,safeBoxY,safeBoxW,safeBoxH);
        }
        else if(isClosed == false && hasNote)
        {
            safe2.getImage();
            g2d.drawImage(safe2.getImage(), safeBoxX, safeBoxY, safeBoxW, safeBoxH, null);
           //g.setColor(Color.pink); 
           //g.fillRect(safeBoxX,safeBoxY,safeBoxW,safeBoxH);
        }
        else 
        {
            openedSafe.getImage();
            g2d.drawImage(openedSafe.getImage(), safeBoxX, safeBoxY, safeBoxW, safeBoxH, null);
            //g.setColor(Color.white); 
            //g.fillRect(safeBoxX,safeBoxY,safeBoxW,safeBoxH);
        } 
        
       
    }
    
    public void drawSelfExamine(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        if(examining == true)
        {
             //examine 
            if(isClosed && hasNote || isClosed && hasNote == false)
            {
                safeBox.getImage();
                g2d.drawImage(safeBox.getImage(), 380, 100, 300, 300, null);
                //g.setColor(col); 
                //g.fillRect(300, 100, 300 ,300);
            }
            else if(isClosed == false && hasNote)
            {
                safe2.getImage();
                g2d.drawImage(safe2.getImage(), 380, 100, 300, 300, null);
                //g.setColor(Color.pink); 
                //g.fillRect(300, 100, 300 ,300);
            }
            else 
            {   
                 openedSafe.getImage();
                 g2d.drawImage(openedSafe.getImage(), 380, 100, 300, 300, null);
                //g.setColor(Color.white); 
                //g.fillRect(300, 100, 300 ,300);
            }
        
        }
    }
    
    public void open(boolean hasKey)
    {
        if(isClosed && hasKey == true)
        {
            //System.out.println("You use the key to open the lock on the safe and open the safe door");
            isClosed = false; 
        }
        else 
        {
            //System.out.println("You didn't use the key to open the safe");
            isClosed = true; 
        }
    }

    
    public boolean takeNote()
    {
        boolean output; 
        
        if(isClosed)
        {
            //System.out.println("What note are you talking about ?? Maybe try opening the safe ");
            output = false; 
        }
        else 
        {
            //System.out.println("You take out the note from the safe  ");
            hasNote = false;
            output = true; 
        }
        
        return output; 
    }
    
    public boolean clickInside(int x, int y)
    {
        if(distance(x,y,getCenterX(), getCenterY()) <= (safeBoxW + safeBoxH)/2)
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
            
            
