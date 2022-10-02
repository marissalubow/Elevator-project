/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lubowelevatorproj8b;

/**
 *
 * @author marissalubow
 */
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

public class ElevatorProj extends JComponent implements KeyListener, MouseListener, MouseMotionListener
{
    //instance variables
    private int WIDTH;
    private int HEIGHT;
    private int bottleX; 
    private int bottleY; 
    private int bottleW; 
    private int bottleH; 
    private int tvX;
    private int tvY;
    private int tvW;
    private int tvH;
    private int keyX;
    private int keyY;
    private int keyW;
    private int keyH;
    private int bottleOpenerX;
    private int bottleOpenerY;
    private int bottleOpenerH;
    private int bottleOpenerW;
    private int safeX;
    private int safeY;
    private int safeW;
    private int safeH;
    private int noteX;
    private int noteY; 
    private int noteH;
    private int noteW;
    private int buttonsX;
    private int buttonsY;
    private int buttonsH;
    private int buttonsW;
    private int doorsX;
    private int doorsY;
    private int doorsH;
    private int doorsW;
            
            
    
    
    //Default Constructor
    public ElevatorProj()
    {
        //initializing instance variables
        WIDTH = 1000;
        HEIGHT = 500;
        bottleX = 100; 
        bottleY = 400; 
        bottleW = 20;
        bottleH = 40; 
        tvX = 700;
        tvY = 50;
        tvW = 200;
        tvH = 100;
        keyX = 100;
        keyY = 400;
        keyW = 10;
        keyH = 10;
        bottleOpenerX = 700;
        bottleOpenerY = 50;
        bottleOpenerH = 30;
        bottleOpenerW = 20;
        safeX = 850;
        safeY = 250;
        safeW = 100;
        safeH  = 100;
        noteX = 850;
        noteY = 250; 
        noteH = 20;
        noteW = 20;
        buttonsX = 50;
        buttonsY = 50;
        buttonsH = 200;
        buttonsW = 100;
        doorsX = 300;
        doorsY = 0;
        doorsH = 400;
        doorsW = 250;
        
        //Setting up the GUI 
        JFrame gui = new JFrame(); //makes the gui box 
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes usre porgram can close 
        gui.setTitle("Elevator escape room"); //sets title of game 
        gui.setPreferredSize(new Dimension(WIDTH +5, HEIGHT +30)); //setting the size for gui
        gui.setResizable(false); //makes it so the gui cannot be resized 
        gui.getContentPane().add(this); //adding this class to the gui
        
        
        gui.pack(); //packs everything togther 
        gui.setLocationRelativeTo(null); //makes so the gui opens in the center of the screen 
        gui.setVisible(true); //makes gui visible 
        gui.addKeyListener(this); //stating that this object will listen to the keyboard 
        gui.addMouseListener(this); //stating that this object wull listen to the mouse 
        gui.addMouseMotionListener(this); //stating that this object will acknowledge when the mouse moves 

    }
    //This method will acknowledge user input
    public void keyPressed(KeyEvent e) 
    {
        //getting the key pressed
        int key = e.getKeyCode();
        System.out.println(key);

        //moving the rectangle
        

    }   
    //All your UI drawing goes in here
    public void paintComponent(Graphics g)
    {
        //Drawing a Blue Rectangle to be the background
        g.setColor(Color.white);
        g.fillRect(0,0, WIDTH, HEIGHT);
        
    
        
        //Drawing the user-controlled rectangle
        g.setColor(Color.blue);
        g.fillRect(bottleX,bottleY,bottleW,bottleH);
        
        g.setColor(Color.BLACK);
        g.fillRect(tvX,tvY,tvW,tvH);
        
        g.setColor(Color.green);
        g.fillRect(safeX,safeY,safeW,safeH);
        
        
        g.setColor(Color.CYAN);
        g.fillRect(noteX,noteY,noteW,noteH);
        
        
        g.setColor(Color.pink);
        g.fillRect(bottleOpenerX,bottleOpenerY,bottleOpenerW,bottleOpenerH);
        
        
        g.setColor(Color.yellow);
        g.fillRect(keyX,keyY,keyW,keyH);
        
        
        g.setColor(Color.gray); 
        g.fillRect(buttonsX, buttonsY, buttonsW, buttonsH);
        
        
        g.setColor(Color.orange); 
        g.fillRect(doorsX, doorsY, doorsW, doorsH);
        
        
        
    }
    public void loop()
    {
        
        //handling the collision of the circle with the rectangle
        

        
        //Do not write below this
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
        
        bottleX = xClick; 
        bottleY = yClick;
        noteX = xClick; 
        noteY = yClick;
        keyX= xClick; 
        keyY = yClick;
        bottleOpenerX = xClick; 
        bottleOpenerY = yClick;
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
        ElevatorProj g = new ElevatorProj();
        g.start(60);
    }
}
