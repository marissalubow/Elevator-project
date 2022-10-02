/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lubowelevatorproj8b;

/**
 *
 * @author marissalubow
 */

import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Color;


// required - must use this class at least once
public class CombinationLock
{
    private String combination,hint;
    private boolean openFlag;
    private int buttonsX;
    private int buttonsY;
    private int buttonsW;
    private int buttonsH;
    private Color col;
    private boolean examining;
    private boolean pushed;
    
    
    // Constructor
    // The combination is required when creating this object
    // The hint is also required.  This can be something like the format for what should be entered.
    //    For example:  (format: ##-##-##)
    //    Leave the hint blank if you don't want to use this.
    public CombinationLock(String argCombination, int xCoor, int yCoor, int width, int height, Color c)
    {
        
        // Set the combination.
        combination = argCombination;
        
        // Set the hint
        hint = "";
        
        // This starts out being locked.
        openFlag = false;
        
        buttonsX = xCoor; 
        buttonsY = yCoor; 
        buttonsW = width; 
        buttonsH = height; 
        col = c; 
        examining = false;
        pushed = false; 
       
    } // end constructor
    // The combination is required when creating this object
    // The hint is also required.  This can be something like the format for what should be entered.
    //    For example:  (format: ##-##-##)
    //    Leave the hint blank if you don't want to use this.
            
    public boolean getExamined()
    {
        return examining;
    }
    public void setExamine(boolean e)
    {
        examining = e;
    }
    
    public CombinationLock(String argCombination, String argHint)
    {
        // Set the combination.
        combination = argCombination;
        
        // Set the hint
        hint = argHint;
        
        // This starts out being locked.
        openFlag = false;
    } // end constructor
    
    // This method will prompt the player for the combination and possibly unlock the combination lock.
    // It will return true if successful, false if not.
    public boolean unlock()
    {
        // If the lock is already open, nothing should be done.
        if (openFlag) return openFlag;
        
        // Prompt the player for the combination
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the combination " + hint + ":  ");
        String enteredCombination = in.nextLine();
        
        // Check if the combination is correct
        if (enteredCombination.equals(combination))
        {
            // The combination is correct.
            openFlag = true;
        }
        
        // Return the status of the lock.
        return openFlag;
    } // end unlock
    
    // This method will return the status of the lock.
    // TRUE if unlocked, FALSE if locked.
    public boolean isUnlocked()
    {
        return openFlag;
    } // end isUnlocked
    
    private double distance(int x1, int y1, int x2, int y2)
    {
        double distance = Math.sqrt(Math.pow((x2-x1),2)+ Math.pow((y2-y1),2));
        return distance;
    }
    public int getCenterX()
    {
       int output = buttonsX+ buttonsW/2; 
       return output;
    }
    public int getCenterY()
    {
        int output = buttonsY + buttonsH/2;
        return output;
    }

    //accessor method for the hint
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
    public int getButtonsW() 
    {
        return buttonsW; 
    }
    public boolean getpushed()
    {
        return pushed; 
    }
           
    
   
    
    
    
    public void drawSelf(Graphics g)    
    {
        if(pushed)
        {
            g.setColor(col); 
            g.fillRect(buttonsX,buttonsY,buttonsW,buttonsH);
            
        }
        else if(pushed == true)
        {
            
            g.setColor(Color.yellow); 
            g.fillRect(buttonsX,buttonsY,buttonsW,buttonsH);
            
            
        
        }
        else 
        {      g.setColor(col); 
               g.fillRect(buttonsX,buttonsY,buttonsW,buttonsH);
        }
            
    }
        
    public void drawSelfExamine(Graphics g)
    {
        if(examining == true)
        {
            if(pushed)
            {
                g.setColor(col); 
                g.fillRect(300, 100, 300 ,400);
                
                
            }
            else if(pushed == true)
            {
                g.setColor(Color.yellow); 
                g.fillRect(300, 100, 300 ,400);
                
                
            }
            else 
            {
                g.setColor(col); 
                g.fillRect(300, 100, 300 ,400);
                
            }
        }
    }
    public void push()
    {
        if(pushed)
        {
            pushed = true;
        }
    }
    
    public boolean clickInside(int x, int y)
    {
        if(distance(x,y,getCenterX(), getCenterY()) <= (buttonsW + buttonsH)/2)
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
} // end class CombinationLock
