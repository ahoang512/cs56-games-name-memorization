package edu.ucsb.cs56.projects.games.name_memorization;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.*;
  /**
   * Preliminary engine for running a name memorization game
   *
   *@author Anthony Hoang, Colin Biafore
   *@version  for cs56, Spring 2014
   */
public class NameGame extends JFrame{
    private JButton edit;
    private JButton add;
    private JButton delete;
    private JButton next;
    private JButton previous;
    private DirectoryLister dir;
    private int current;
    private Image pic;
    private JPanel north;


    public void paint(Graphics g){
	/*
        //get the picture to paint
        pic = Toolkit.getDefaultToolkit().getImage(dir.getFullFilenames().get(current));
        //call super's paint method
        super.paint(g);
        //draw designated picture in background
        g.drawImage(pic, 115, 90,300, 300, this);
	*/
    }

    /**
     * No arg constructor for the name game. Initializes everyting in a JFrame
     * (Buttons, pics, etc)
     */
    public NameGame(){
        dir = new DirectoryLister("src/people");
        current = 0;
        this.getContentPane().setLayout(new BorderLayout());
	
	north = new JPanel();

        HandlerClassN handlerN = new HandlerClassN();
        next = new JButton("next");	
        next.addActionListener(handlerN);
       

	HandlerClassP handlerP = new HandlerClassP();
	previous = new JButton("previous");
	previous.addActionListener(handlerP);
	

	edit = new JButton("edit");
	add = new JButton("add");
	delete = new JButton("delete");
	
	north.add(edit);
	north.add(add);
	north.add(delete);
	north.add(previous);
	north.add(next);
	this.add(north, BorderLayout.NORTH);
	
    }

    /**
     * Handler ClassN , used to give next button functionality
     */
    private class HandlerClassN implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // iterate to next pic unless at end of array, then go to first pic
            if (current < dir.getNumFiles()-1){
          current++;
            }else{
          current = 0;
            }
            repaint();

        }
    }
    
    /**
     * Handler ClassP, used to give previous button functionality
     */
    private class HandlerClassP implements ActionListener {
	public void actionPerformed(ActionEvent event){
	    // iterate to previous picture unless at beginning
	    if (current > 0 ){
		current--;
	    }else{
		current = dir.getNumFiles()-1;
	    }
	    repaint();
	    
	}
    }
}
