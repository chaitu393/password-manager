package com.techmplement.passwordmanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	
	JButton generateButton,encryptButton, button;
	JButton button1;
	JButton button2;
	JTextArea generateArea;
	
	 public void textArea(String Pass,JTextArea TA){
	        TA.setText(Pass);
	        Font fn = new Font("Tahoma", Font.BOLD, 20);
	        TA.setWrapStyleWord(true);
	        TA.setLineWrap(true);
	        TA.setCaretPosition(0);
	        TA.setEditable(false);
	        TA.setFont(fn);
	 }

	public HomePage(String username) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		
		//Again creating a content panel
		
		panel=new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);
		
		//creating Text
		
		
//		creating buttons for the requirement
		
		
		//password Storage button
		generateButton=new JButton("Generate Password");
		generateButton.setForeground(Color.black);
		generateButton.setFont(new Font("Tahoma", Font.PLAIN,20));
		generateButton.setBounds(320, 10, 350, 60);
		generateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (generateButton==e.getSource()) {
					try {
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
				
			}
		});
		panel.add(generateButton);
		
		
		encryptButton=new JButton("Encrypt password");
		encryptButton.setForeground(Color.black);
		encryptButton.setFont(new Font("Tahoma", Font.PLAIN,20));
		encryptButton.setBounds(320, 110, 350, 60);
		encryptButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(encryptButton);
		
		
		
		button=new JButton("Password Stroage");
		button.setForeground(Color.black);
		button.setFont(new Font("Tahoma", Font.PLAIN,20));
		button.setBounds(320, 210, 350, 60);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				
			}
		});
		
		panel.add(button);
		
		//password retrieval button
		
		button2=new JButton("Search Password");
		button2.setForeground(Color.black);
		button2.setFont(new Font("Tahoma", Font.PLAIN,20));
		button2.setBounds(320, 310, 350, 60);
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		panel.add(button2);
		
		
		//password Generator
		
				button1=new JButton("Delete password");
				button1.setForeground(Color.black);
				button1.setFont(new Font("Tahoma", Font.PLAIN,20));
				button1.setBounds(320, 410, 350, 60);
				button1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					
						
					}
				});
				
				panel.add(button1);
		
		
		
		
		
	}

}

