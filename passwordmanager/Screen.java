package com.techmplement.passwordmanager;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Screen {
	
	JFrame frame;
	JLabel image=new JLabel(new ImageIcon("img/icon.png"));
	JLabel text=new JLabel("Password Manager");
	JLabel text1=new JLabel("TECHPLEMENT:Team (Java-05)");
	JProgressBar progressBar=new JProgressBar();
	JLabel message=new JLabel();
	
	Screen()
	{
		createGUI();
        addImage();
        addText();
        addProgressBar();
        addMessage();
        addTitle();
        runningPBar();
		
	}

	private void runningPBar() {
		// TODO Auto-generated method stub
		 int i=0;//Creating an integer variable and initializing it to 0

	        while( i<=100)
	        {
	            try{
	                Thread.sleep(40);   //Pausing execution for 50 milliseconds
	                progressBar.setValue(i);    //Setting value of Progress Bar
	                message.setText("LOADING....(" + (i) + "%)");   //Setting text of the message JLabel
	                i++;
	                if(i==100)
	                    frame.dispose();
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	        }
		
	}

	private void addTitle() {
		// TODO Auto-generated method stub
		text1.setFont(new Font("Tahoma",Font.BOLD,17));
        text1.setBounds(20,370,400,20);
        text1.setForeground(Color.GREEN);
        frame.add(text1);
		
	}

	private void addMessage() {
		// TODO Auto-generated method stub
		    message.setBounds(230,320,200,40);//Setting the size and location of the label
	        message.setForeground(Color.BLACK);//Setting foreground Color
	        message.setFont(new Font("Tahoma",Font.BOLD,15));//Setting font properties
	        frame.add(message);//adding label to the frame
		
	}

	private void addProgressBar() {
		// TODO Auto-generated method stub
		progressBar.setBounds(100,280,400,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.BLACK);
        progressBar.setForeground(Color.YELLOW);
        progressBar.setValue(0);
        frame.add(progressBar);
	}

	private void addText() {
		// TODO Auto-generated method stub
		 text.setFont(new Font("Tahoma",Font.BOLD,30));
	        text.setBounds(130,200,600,60);
	        text.setForeground(Color.WHITE);
	        frame.add(text);
	    
		
	}

	private void addImage() {
		// TODO Auto-generated method stub
		image.setSize(600,200);
        frame.add(image);
		
	}

	private void createGUI() {
		// TODO Auto-generated method stub
		frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setVisible(true);
		
	}
	

}
