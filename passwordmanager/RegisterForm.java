package com.techmplement.passwordmanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegisterForm extends JFrame {
    private static final long serialVersionUID = 1L;
	
	private static JPanel registerpanel;
	private  static JTextField emailField;

	private static JTextField userNameField;

	private static JTextField passwordField;
	JLabel emaiLabel,usernameLabel,passwordLabel;
	 private static JButton registerButton,jbut;
	
	public RegisterForm()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(350, 190, 800, 550);
		
		setResizable(false);
		
		// creating a content panel
		
		registerpanel=new JPanel();
		registerpanel.setBorder(new EmptyBorder(5,5,5,5));
		registerpanel.setBackground(Color.getHSBColor(0, 153, 153));
		setContentPane(registerpanel);
		registerpanel.setLayout(null);
		
		
		//Creating Text for register form
		
		JLabel label=new JLabel("Registration Form");
		label.setForeground(Color.black);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		label.setBounds(311,80,600,80);
		registerpanel.add(label);
		
		emailField =new JTextField();
		emailField.setFont(new Font("Arial", Font.PLAIN, 20));
		emailField.setBounds(311,165, 292, 50);
//		emailField.setColumns(10);
		registerpanel.add(emailField);
		
		JLabel emailLabel=new JLabel("Email:");
		emailLabel.setForeground(Color.black);
		emailLabel.setFont(new Font("Arial",Font.PLAIN,25));
		emailLabel.setBounds(230,165, 281, 50);
		registerpanel.add(emailLabel);
		
		JLabel uNLabel=new JLabel("UserName:");
		uNLabel.setForeground(Color.black);
		uNLabel.setFont(new Font("Arial",Font.PLAIN,25));
		uNLabel.setBounds(175,240, 281, 50);
		registerpanel.add(uNLabel);
		
		
		userNameField =new JTextField();
		userNameField.setFont(new Font("Arial", Font.PLAIN, 25));
		userNameField.setBounds(311,240, 292, 50);
		userNameField.setColumns(10);
		registerpanel.add(userNameField);
		
		JLabel passLabel=new JLabel("Password:");
		passLabel.setForeground(Color.black);
		passLabel.setFont(new Font("Arial",Font.PLAIN,25));
		passLabel.setBounds(185,315, 281, 50);
		registerpanel.add(passLabel);
		
		passwordField =new JTextField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 25));
		passwordField.setBounds(311,315, 292, 50);
//		passwordField.setColumns(10);
		registerpanel.add(passwordField);
		
		
		
		registerButton=new JButton("register");
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				register();
			}
				
		});
		registerButton.setForeground(Color.black);
		registerButton.setFont(new Font("Arial",Font.PLAIN,25));
		registerButton.setBounds(311, 400, 140, 50);
		registerpanel.add(registerButton);
		
		
		jbut=new JButton("Login");
		jbut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginForm lg=new LoginForm();
			    lg.loginForm();
			    lg.show();
			   dispose();
				
			}
		});
        jbut.setForeground(Color.black);
        jbut.setFont(new Font("Arial", Font.PLAIN, 20));
        jbut.setBounds(460, 400, 140, 50);
        registerpanel.add(jbut);
        setVisible(true);
        
		
	}
	private void register()
	{
		
		String email=emailField.getText();
		String userName=userNameField.getText();
		String password=passwordField.getText();
		String enc=encryptpassword(password);
		if (!email.isBlank()&&!userName.isBlank()&&!password.isBlank()) {
			String url = "jdbc:mysql://localhost:3306/swing_pm";
	        String username = "root";
	        String pass = "123456";
			try{
				Connection connect=DriverManager.getConnection(url,username,pass);
				Statement st=connect.createStatement();
				String query="INSERT INTO `login`(`email`,`userName`,`password`) Values("
						+ "'"+email+"','"+userName+"','"+enc+"')";
				PreparedStatement ps=connect.prepareStatement(query);
				ps.executeUpdate(query);
				JOptionPane.showMessageDialog(this, "Success inserted");
				connect.close();
				
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
				JOptionPane.showMessageDialog(this,"Registration failed:"+e2.getMessage());
			}
			
		}
		else
		{
			JOptionPane.showMessageDialog(registerButton, "please fill the details");
		}
		
	
						
	}
	private String encryptpassword(String password)
	{
		try {
			MessageDigest msd=MessageDigest.getInstance("SHA-1");
			byte[] hash=msd.digest(password.getBytes());
			return Base64.getEncoder().encodeToString(hash);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	
	

}
