package com.techmplement.passwordmanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginForm extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jp;
	JTextField textField;
	JPasswordField passwordField;
	JButton jbut;
	JLabel label;
	JButton registerButton;
	
	
	public void loginForm()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.getHSBColor(0, 153, 153));
		
		setBounds(350, 190, 800, 550);
		setLayout(null);
		setResizable(false);
		
		//creating a content panel
		jp=new JPanel();
		jp.setBorder(new EmptyBorder(5, 5,5,5));
		setContentPane(jp);
		jp.setLayout(null);
		jp.setBackground(Color.getHSBColor(0, 153, 153));
		//Creating Login label
		JLabel jlb=new JLabel("Login");
		jlb.setForeground(Color.black);
		jlb.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		jlb.setBounds(380,80,600,80);
		jp.add(jlb);
		
		//creating UN TextField
		
		textField=new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setBounds(311,165, 292, 50);
        jp.add(textField);
        textField.setColumns(10);
        
        //creating password passwordField
        
        passwordField=new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordField.setBounds(311,240, 292, 50);
        jp.add(passwordField);
        
        // creating UserName label
        
        JLabel jun=new JLabel("User name:");
        jun.setForeground(Color.black);
        jun.setFont(new Font("Arial", Font.PLAIN, 25));
        jun.setBounds(175,165, 281, 50);
        jp.add(jun);
        
        //creating password
        
        JLabel jlp=new JLabel("Password:");
        jlp.setForeground(Color.black);
        jlp.setFont(new Font("Arial", Font.PLAIN, 25));
        jlp.setBounds(185,240, 281, 50);
        jp.add(jlp);
        
        //creating a login button       
        jbut=new JButton("Login");
        jbut.setForeground(Color.black);
        jbut.setFont(new Font("Arial", Font.PLAIN, 20));
        jbut.setBounds(400, 325, 100, 50);
        jbut.addActionListener(new ActionListener() {
			 
        	
			
			public void actionPerformed(ActionEvent e) {
				
				String username=textField.getText();
	        	
				@SuppressWarnings("deprecation")
				String pass=passwordField.getText();
	        	
	        	try {
	        		Connection connect=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_pm",
	        				"root","123456");
	        		
	        		PreparedStatement ps=(PreparedStatement)connect.prepareStatement(
	        				
	        				"Select userName, password from login where userName=? and password=?"
	        				
	        				);
	        		if (!username.isBlank()&&!pass.isBlank()) {
	        			ps.setString(1, username);
		        		ps.setString(2,pass);
		        		
		        		ResultSet rs=ps.executeQuery();
		        		
		        		if (rs.next()) {
		        			
		        			dispose();
		        			PasswordManager pm=new PasswordManager();
//		        			HomePage hm=new HomePage(username);
//		        			hm.setTitle("Welcome to Home Page.....!");
		        			
//		        			hm.setVisible(true);
//		        			
//		        			JOptionPane.showMessageDialog(jbut, "You have successfully logged in..");
		        			
		        			
							
						} else {
							
							JOptionPane.showMessageDialog(jbut, "Invalid credientials...");

						}
						
					}
	        		else
	        		{
	        			JOptionPane.showMessageDialog(jbut, "please fill the details");
	        		}
	        		
	        		
					
				} catch (SQLException e2) {
					
					e2.printStackTrace();
					
				}
				
				
			}
		}
        		
        		
        		
        		);
        
        jp.add(jbut);
        
        
        
        
        		
        
        
        
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	

}
