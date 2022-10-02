

package com.mycompany.lubowelevatorproj8b;

/**
 *
 * @author marissalubow
 */
import java.util.Scanner; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Font;
import java.util.Set;
import javax.swing.JOptionPane; 
import java.applet.*;
//imports for drawing Images
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;


public class LubowElevatorProj8B extends JComponent implements KeyListener, MouseListener, MouseMotionListener
{
    //instance variables
    private int WIDTH;
    private int HEIGHT;
    private LubowBottle8B bottle; 
    private LubowTv8B tv;
    private LubowSafeBox8B safeBox; 
    private LubowDoors8B doors; 
    private LubowButtons8B buttons; 
    private int keyX; 
    private int keyY;
    private int keydiam; 
    private int bottleOpenerX;
    private int bottleOpenerY;
    private int bottleOpenerDiam;
    private int noteX;
    private int noteY; 
    private int noteH;
    private int noteW;
    private ImageIcon noteImage; 
    private ImageIcon bottleOpenerImage; 
    private ImageIcon keyImage; 
    private ImageIcon elevatorBackground; 
    private ImageIcon gameOverScreen; 
    private ImageIcon gameOver2Screen;
    private ImageIcon gameOver3Screen;
    private ImageIcon outsideHotel; 
   
    
    private String input = "";
    private String input2 = ""; 
    private String input3 = ""; 
    
    
    private boolean gameOver; 
    private boolean gameOver2; 
    private boolean gameOver3;
    private boolean backStoryScreen; 
   
    
   
    
     private int wrongPass;
     private int correctPass;
   
     private AudioClip introSong;
     
     private AudioClip fire;
     
     
     private AudioClip electric;
     private AudioClip win;
     private AudioClip backStory;
     private AudioClip lose;
     
     
     
    //objects in game 
    private boolean key; 
    private boolean note; 
    private boolean bottleOpener; 
    
    //Default Constructor
    public LubowElevatorProj8B()
    {
        //initializing instance variables
        WIDTH = 1000;
        HEIGHT = 500;
        bottle = new LubowBottle8B(200, 400, 100, Color.BLUE); 
        tv = new LubowTv8B(750, 85, 200, 100, Color.black);
        safeBox = new LubowSafeBox8B(850, 350, 100, 100, Color.green);
        buttons = new LubowButtons8B(275, 100, 90, 150, Color.gray); 
        doors = new LubowDoors8B(370, 62, 270, 350, Color.gray); 
        keyX = 80;
        keyY = 90; 
        keydiam = 50; 
        bottleOpenerX = 80;
        bottleOpenerY = 150;
        bottleOpenerDiam= 50;
        noteX = 80;
        noteY = 210; 
        noteH = 50;
        noteW = 50;
        wrongPass = (int)(Math.random()*12 + 1); 
        correctPass = (int)(Math.random()*12 + 1);
        bottleOpener = false;  
        noteImage = new ImageIcon(LubowBottle8B.class.getResource("note.jpg")); 
        bottleOpenerImage = new ImageIcon(LubowBottle8B.class.getResource("bottleOpener.jpg")); 
        keyImage = new ImageIcon(LubowBottle8B.class.getResource("key.jpg")); 
        elevatorBackground = new ImageIcon(LubowElevatorProj8B.class.getResource("elevatorBackground.jpg"));
        gameOverScreen = new ImageIcon(LubowElevatorProj8B.class.getResource("gameOver.JPG"));
        gameOver2Screen = new ImageIcon(LubowElevatorProj8B.class.getResource("gameOver2.JPG"));
        gameOver3Screen = new ImageIcon(LubowElevatorProj8B.class.getResource("gameOver3.JPG"));
        outsideHotel = new ImageIcon(LubowElevatorProj8B.class.getResource("outsideHotel.jpg"));
        gameOver = false; 
        gameOver2 = false;
        gameOver3 = false;
        backStoryScreen = true;
        key = false; 
        note = false; 
       
        
        introSong = Applet.newAudioClip(this.getClass().getResource("ElevatorMusic.wav"));
        
        
         
        fire = Applet.newAudioClip(this.getClass().getResource("fire.wav"));
        
        lose = Applet.newAudioClip(this.getClass().getResource("lose.wav"));
        win = Applet.newAudioClip(this.getClass().getResource("win.wav"));
        backStory = Applet.newAudioClip(this.getClass().getResource("backStory.wav"));
        electric = Applet.newAudioClip(this.getClass().getResource("electric.wav"));
        
        
        
        //introSong.loop();
        
        while(wrongPass == correctPass)
        {
            correctPass = (int)(Math.random()*12+1); 
        }
        
        //Setting up the GUI
        JFrame gui = new JFrame(); //This makes the gui box
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes sure program can close
        gui.setTitle("Elevator Escape room"); //This is the title of the game, you can change it
        gui.setPreferredSize(new Dimension(WIDTH + 5, HEIGHT + 30)); //Setting the size for gui
        gui.setResizable(false); //Makes it so the gui cant be resized
        gui.getContentPane().add(this); //Adding this class to the gui

         /*If after you finish everything, you can declare your buttons or other things
          *at this spot. AFTER gui.getContentPane().add(this) and BEFORE gui.pack();
          */

        gui.pack(); //Packs everything together
        gui.setLocationRelativeTo(null); //Makes so the gui opens in the center of screen
        gui.setVisible(true); //Makes the gui visible
        gui.addKeyListener(this);//stating that this object will listen to the keyboard
        gui.addMouseListener(this); //stating that this object will listen to the Mouse
        gui.addMouseMotionListener(this); //stating that this object will acknowledge when the Mouse moves




    }
    //This method will acknowledge user input
    public void keyPressed(KeyEvent e) 
    {
       

    }   
    //All your UI drawing goes in here
    public void paintComponent(Graphics g)
    {
      Graphics2D g2d = (Graphics2D)g;
      
      
     
      if(backStoryScreen)
      {
         
         
          outsideHotel.getImage(); 
          g2d.drawImage(outsideHotel.getImage(), 0, 0, WIDTH, HEIGHT, null); 
          
          Font f4 = new Font("Arial", Font.BOLD, 80);
          g.setFont(f4); 
          g.setColor(Color.red); 
          g.drawString("Elevator Escape Room", 60, 80); 
         
           if(input.equals(""))
           {
               
               input="temp";
               JOptionPane.showMessageDialog(null,"You are very excited to start your vacation"); 
               JOptionPane.showMessageDialog(null, "you booked this hotel, it only had 2 stars but it was cheap for such a nice looking hotel, and you wanted to save money");
               JOptionPane.showMessageDialog(null,"You saw a lot of reviews saying some strange things that have happened espeically with the elevators..."); 
               JOptionPane.showMessageDialog(null,"You think nothing of it and book the hotel anyways");  
               JOptionPane.showMessageDialog(null,"You enter the hotel elevator and it starts going up like normal until... "); 
               JOptionPane.showMessageDialog(null,"You hear a loud noise and the elevator stops moving!!!");
               JOptionPane.showMessageDialog(null,"You now have to figure out how to escape the elevator!"); 
               JOptionPane.showMessageDialog(null,"Interact with the objects in the elevator by left and right clicking with your mouse"); 
               
               input = JOptionPane.showInputDialog("Enter: START to start the game"); 
               while(!input.equals("START") && !input.equals("temp"))
               {
                  input = JOptionPane.showInputDialog("INVALID, Enter START to start the game"); 
               }
               if(input.equals("START"))
               {
                   JOptionPane.showMessageDialog(null,"Goodluck escaping ;)");
                   backStoryScreen = false; 
                  // backStory.stop();
                   introSong.loop();
                  // fire.stop();
               }
              
                
               
               
              
           }
         
      }
     
      if(gameOver == false && backStoryScreen == false && gameOver2 == false && gameOver3 == false)
      {
       
        elevatorBackground.getImage();
        g2d.drawImage(elevatorBackground.getImage(),0,0, WIDTH, HEIGHT, null);
        
        bottle.drawSelf(g);
        tv.drawSelf(g);
        safeBox.drawSelf(g);
        buttons.drawSelf(g);
        doors.drawSelf(g);
     
    //invetntory
    if(doors.getclosed() == true && doors.getopened() == false)
    {
        g.setColor(Color.WHITE);
        g.fillRect(50, 70, 100, 200);
        Font f4 = new Font("Arial", Font.BOLD, 10);
        g.setFont(f4); 
        g.setColor(Color.BLACK); 
        g.drawString("YOUR INVENTORY", 55, 80); 
   
     if(key == true)
     {
        keyImage.getImage();
        g2d.drawImage(keyImage.getImage(), keyX, keyY, keydiam, keydiam, null);
        //g.setColor(Color.yellow);
        //g.fillOval(keyX,keyY, keydiam, keydiam);
       
     }
     if(bottleOpener == true) 
     {
        bottleOpenerImage.getImage();
        g2d.drawImage(bottleOpenerImage.getImage(), bottleOpenerX, bottleOpenerY, bottleOpenerDiam, bottleOpenerDiam, null);
        //g.setColor(Color.pink);
        //g.fillOval(bottleOpenerX,bottleOpenerY,bottleOpenerDiam,bottleOpenerDiam); 
        
        
     }
     if(note == true )
     {
        noteImage.getImage();
        g2d.drawImage(noteImage.getImage(), noteX, noteY, noteW, noteH, null);
        //g.setColor(Color.CYAN);
        //g.fillRect(noteX,noteY,noteW,noteH);
        
        Font f2 = new Font("Arial", Font.BOLD, 15);
        g.setFont(f2); 
        g.setColor(Color.red); 
        g.drawString(correctPass + "", 95, 230); 
        
        Font f3 = new Font("Arial", Font.BOLD, 15);
        g.setFont(f3); 
        g.setColor(Color.red); 
        g.drawString(wrongPass + "", 95, 250); 
        
     }
   }
      
     
     //examine methods must be below
     bottle.drawSelfExamine(g);
     tv.drawSelfExamine(g);
     safeBox.drawSelfExamine(g);
     buttons.drawSelfExamine(g); 
     
     if(tv.getExamined() == true && tv.getisOff() == false && bottleOpener == false) 
     {
           if(input2.equals(""))
           {
               bottleOpener = false; 
               input2="temp";
               input2 = JOptionPane.showInputDialog("Uncramble the following words: ELOTBT NERPOE" + "\n" + "(enter EXIT to stop playing)"); 
               while(!input2.equals("temp") && !input2.equals("BOTTLE OPENER") && !input2.equals("EXIT"))
               {
                   
                   input2 = JOptionPane.showInputDialog("Wrong try again! Uncramble the following words: ELOTBT NERPOE"); 
               }
               if(input2.equals("EXIT")) 
               {
                bottleOpener = false; 
                JOptionPane.showMessageDialog(null,"thanks for playing!");
               }
               else if(input.equals("BOTTLE OPENER"))
               {
                    JOptionPane.showMessageDialog(null,"You Unscrambled the message!");
                
               }
              
           }
          
     }
           
    if(buttons.getExamined() == true && buttons.getisnotpushed() == false) 
     {
         /*
           Font helloWorld = new Font("Arial", Font.BOLD, 15);
           g.setFont(helloWorld); 
           g.setColor(Color.red); 
           g.drawString("which button(s) do you want to press", 310, 200);
           */
         
          //JOptionPane.showInputDialog("Uncramble the following words: ELOTBT NERPOE");
           if(input3.equals(""))
           {
               
               input3="temp";
               input3 = JOptionPane.showInputDialog("which button do you wanna press"); 
               while(!input3.equals("temp") && !input3.equals(correctPass + "") && !input3.equals("EXIT") && !input3.equals(wrongPass  + "") && !input3.equals("EMERGENCY") && !input3.equals("OPEN DOOR") && !input3.equals("CLOSE DOOR") && !input3.equals("emergency") &&!input3.equals("open door") &&!input3.equals("close door") )
               {
                   
                    input3 = JOptionPane.showInputDialog("you cannot press that button"); 
                   
                   
               }
               
               if(input3.equals("EXIT")) 
               {
                   
                    JOptionPane.showMessageDialog(null,"thanks");
                    
               }
               else if(input3.equals(correctPass + ""))
               {
                    JOptionPane.showMessageDialog(null,"YOU PRESSED THE RIGHT BUTTON! Click on the elevator doors to exit");
                   // win.loop();
               }
               else if(input3.equals(wrongPass + ""))
               {
                    //JOptionPane.showMessageDialog(null,"YOU LOST!");
                  
                    gameOver = true; 
                    introSong.stop(); 
                   // lose.loop();
               }
               else if(input3.equals("OPEN DOOR") || input3.equals("open door")) 
               {
                   JOptionPane.showMessageDialog(null,"YOU PRESSED THE RIGHT BUTTON! Click on the elevator doors to exit... JK!"); 
                  
                   gameOver3 = true; 
                   introSong.stop(); 
                  // electric.loop();
                  // g.setColor(Color.magenta);
                   //g.fillRect(doorsX, doorsY, doorsW, doorsH);
               }
               else if(input3.equals("CLOSE DOOR") || input3.equals("close door")) 
               {
                    JOptionPane.showMessageDialog(null,"Error this button is broken");
               }
               else if(input3.equals("EMERGENCY") || input3.equals("emergency")) 
               {
                   JOptionPane.showMessageDialog(null,"Help is on the way!... JK");
                   introSong.stop();
                   //fire.loop();
                   
                   gameOver2 = true; 
                   
                   
               }
              
            
              
           }
          
           
     
     }
           
           
      }
      else 
      {
          if(gameOver == true) 
          {
               
               gameOverScreen.getImage();
               g2d.drawImage(gameOverScreen.getImage(), 0, 0, WIDTH, HEIGHT, null);
               
               Font f3 = new Font("Arial", Font.BOLD, 50);
               g.setFont(f3); 
               g.setColor(Color.red); 
               g.drawString("GAME OVER",370, 250);
               Font f4 = new Font("Arial", Font.BOLD, 15);
               g.setFont(f4); 
               g.setColor(Color.red); 
               g.drawString("You failed to escape and were stuck until you starved to death!!!!", 300, 290);
               
               
              
              
          }
          
         if(gameOver2 == true) 
          {
               
               gameOver2Screen.getImage();
               g2d.drawImage(gameOver2Screen.getImage(), 0, 0, WIDTH, HEIGHT, null);
               
               Font f3 = new Font("Arial", Font.BOLD, 50);
               g.setFont(f3); 
               g.setColor(Color.red); 
               g.drawString("GAME OVER",370, 250);
               Font f4 = new Font("Arial", Font.BOLD, 15);
               g.setFont(f4); 
               g.setColor(Color.red); 
               g.drawString("You failed to escape and were burned alive!!!!", 350, 290);
               
               
              
              
          }
         
         if(gameOver3 == true) 
          {
               
               gameOver3Screen.getImage();
               g2d.drawImage(gameOver3Screen.getImage(), 0, 0, WIDTH, HEIGHT, null);
               
               Font f3 = new Font("Arial", Font.BOLD, 50);
               g.setFont(f3); 
               g.setColor(Color.red); 
               g.drawString("GAME OVER",370, 50);
               Font f4 = new Font("Arial", Font.BOLD, 15);
               g.setFont(f4); 
               g.setColor(Color.red); 
               g.drawString("You failed to escape and were electocuted!!!!", 350, 80);
               
               
              
              
          }
      }
     
           
     
    }
    
   
    public void loop()
    {
        
        repaint();
    }
    //These methods are required by the compiler.  
    //You might write code in these methods depending on your goal.
    public void keyTyped(KeyEvent e) 
    {
    }
    public void keyReleased(KeyEvent e) 
    {
    }
    public void mousePressed(MouseEvent e)
    {
    }
    public void mouseReleased(MouseEvent e)
    {
    }
    public void mouseClicked(MouseEvent e)
    {
        int xClick = e.getX();
        int yClick = e.getY();
        int keyCODE = e.getButton();
        //System.out.println("key = " + key);
        
        if(bottle.clickInside(xClick,yClick) && keyCODE == 1)
        {
            bottle.setExamine(true);
        }
        else if(bottle.getclosed() && bottle.clickInsideExamine(xClick, yClick) && bottle.getExamined())
        {
            //the bottle is closed and i am clikcing on the examined big bottle
            //bottle.open();//giving ture for now, but you needed to code for hte bottle opener first
             if(bottleOpener == true )
                bottle.open(true);
             else 
                bottle.open(false);
        }
        else if(bottle.getclosed()==false && bottle.clickInsideExamine(xClick, yClick) && bottle.getExamined())
        {
            //the bottle is closed and i am clikcing on the examined big bottle
            key = bottle.takeKey();//giving ture for now, but you needed to code for hte bottle opener first
        }
        
        
        else if(tv.clickInside(xClick, yClick) && keyCODE == 1)
        {
            tv.setExamine(true);    
        }
        else if(tv.getisOff() && tv.clickInsideExamine(xClick, yClick) && tv.getExamined())
        {
            tv.turnOn(); 
        }
        else if(tv.getisOff() == false && tv.clickInsideExamine(xClick, yClick) && tv.getExamined()) 
        {    
            bottleOpener = tv.takeBottleOpener(); 
        }
        
        else if(buttons.clickInside(xClick, yClick) && keyCODE == 1)
        {
            buttons.setExamine(true);    
        }
        else if(buttons.getisnotpushed() && buttons.clickInsideExamine(xClick, yClick) && buttons.getExamined())
        {
            buttons.push(); 
        }
        else if(buttons.getisnotpushed() == false && buttons.clickInsideExamine(xClick, yClick) && buttons.getExamined()) 
        {    
            
        }
        
        
        else if(safeBox.clickInside(xClick, yClick) && keyCODE == 1)
        {
            safeBox.setExamine(true);    
        }
        else if(safeBox.getisclosed() && safeBox.clickInsideExamine(xClick, yClick) && safeBox.getExamined())
        {
            if(key == true)
                safeBox.open(true);
            else 
                safeBox.open(false);   //safeBox.open(true); //giving ture for now, but you needed to code for hte bottle opener first
        }
        else if(safeBox.getisclosed() == false && safeBox.clickInsideExamine(xClick, yClick) && safeBox.getExamined()) 
        {    
            note = safeBox.takeNote(); 
        }  
        
        else if(doors.getclosed() && doors.clickInside(xClick, yClick) && keyCODE == 1 && input3.equals(correctPass + "")) 
            doors.open();
        else if(doors.getclosed() == false && doors.clickInside(xClick, yClick) && keyCODE == 1 && input3.equals(correctPass + ""))
        {    
            doors.exit(true);
            introSong.stop();
        }
      
        
        else if(keyCODE == 3)
        {
            bottle.setExamine(false);
            //SET ALL EXAMINES TO FALSE
            tv.setExamine(false);
            safeBox.setExamine(false);
            buttons.setExamine(false);
        }
        
        
        
        
      
    }
    

    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public void mouseMoved(MouseEvent e)
    {
    }
    public void mouseDragged(MouseEvent e)
    {
    }
    public void start(final int ticks){
        Thread gameThread = new Thread(){
            public void run(){
                while(true){
                    loop();
                    try{
                        Thread.sleep(1000 / ticks);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };	
        gameThread.start();
    }

    public static void main(String[] args)
    {
        LubowElevatorProj8B g = new LubowElevatorProj8B();
        g.start(60);
    }
}