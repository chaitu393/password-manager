package com.techmplement.passwordmanager;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PasswordManager implements ActionListener {
	
	JFrame frame;
	JFrame frame2;
	Container con1,con2;
	JLabel labelAccount,labelPass;
	JTextArea encryptPasswdArea, genePassArea, searchPassArea;
	JButton generateButton,encryptButton, storagebutton,addAccbtn;
	JButton searchButton;
	JButton deleteButton;
	JTextField accountField,passwordField;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public static void framGui(JFrame frame)
	{
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
	}
	public static void containerGui(Container conn)
	{
		conn.setVisible(true);
        conn.setBackground(Color.getHSBColor(0, 153, 153));
        conn.setLayout(null);
		
	}
	 public void GUIButtonsSetting(JButton btn){
	        btn.setBackground(Color.LIGHT_GRAY);
	        btn.setForeground(Color.BLACK);
	        Font fn = new Font("Arial", Font.PLAIN, 15);
	        btn.setFont(fn);
	        Cursor crs = new Cursor(Cursor.HAND_CURSOR);
	        btn.setCursor(crs);
	    }
	 //storing passwords
	 public void storingGui()
	 {
		    frame2 = new JFrame("Store your passwords");
	        frame2.setBounds(1400, 700, 600, 500);
	        frame2.setSize(500,400);
	        framGui(frame2);
	        con2=frame2.getContentPane();
	        containerGui(con2);
	        Font fn = new Font("Arial", Font.BOLD, 20);
	        
	        //account field and text field
	        labelAccount=new JLabel("ENTER THE ACCOUNT NAME");
	        labelAccount.setBounds(100, 23, 480, 50);
	        labelAccount.setFont(fn);
	        con2.add(labelAccount);
	        
	        accountField=new JTextField();
	        accountField.setBounds(100,70,300,80);
	        accountField.setFont(fn);
	        accountField.setForeground(Color.DARK_GRAY);
	        con2.add(accountField);
	        
	      //pass field and text field
	        labelPass=new JLabel("ENTER THE PASSWORD");
	        labelPass.setBounds(100, 160, 480, 50);
	        labelPass.setFont(fn);
	        con2.add(labelPass);
	        
	        passwordField=new JTextField();
	        passwordField.setBounds(100,200,300,80);
	        passwordField.setFont(fn);
	        passwordField.setForeground(Color.DARK_GRAY);
	        con2.add(passwordField);
	        
	        addAccbtn=new JButton("STORE");
	        addAccbtn.setBounds(170, 290, 150, 50);
	        con2.add(addAccbtn);
	        GUIButtonsSetting(addAccbtn); 
	      }
	        public void textArea(String Pass,JTextArea TA)
	      {
	        TA.setText(Pass);
	        Font fn = new Font("Arial", Font.BOLD, 20);
	        TA.setWrapStyleWord(true);
	        TA.setLineWrap(true);
	        TA.setCaretPosition(0);
	        TA.setEditable(false);
	        TA.setFont(fn);

	      }
	      public PasswordManager() throws NullPointerException {
	    	  
	    	  frame=new JFrame("Password Manager");
	    	  frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/icon.png"));
	    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	  frame.setSize(580,630);
	    	  framGui(frame);
	    	  
	    	  con1=frame.getContentPane();
	    	  containerGui(con1);
	    	  
	    	  
	    	  //Generating buttons
	    	  
	    	generateButton=new JButton("GENERATE PASSWORD");
	  		generateButton.setForeground(Color.black);
	  		generateButton.setBounds(160, 80, 220, 70);
	  		con1.add(generateButton);
	  		GUIButtonsSetting(generateButton);
	  		generateButton.addActionListener(e->
	  		{
	  			if (generateButton==e.getSource()) {
	  				try {
	  					
	  					int len =Integer.parseInt(JOptionPane.showInputDialog("Enter the password length"));
	  					if (len>8) {
							
	  						PasswordGenerator pass=new PasswordGenerator();
	  						String pwd=pass.generatePassword(len);
	  						genePassArea=new JTextArea(5,4);
	  						textArea(pwd, genePassArea);
	  						JOptionPane.showMessageDialog(con1, new JScrollPane(genePassArea),"Copy your password",JOptionPane.INFORMATION_MESSAGE);
	  						
	  						
						}
	  					else
	  					{
	  						JOptionPane.showMessageDialog (con1,"Password length must be greater than 8!","Invalid Input Error",JOptionPane.WARNING_MESSAGE);

	  					}
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(con1,e2.getMessage(),"EXIT!",JOptionPane.ERROR_MESSAGE);
					}
					
				}
	  			
	  		});
	  		//password Encryption
	  		
	  		encryptButton=new JButton("ENCRYPT PASSWORD");
	  		GUIButtonsSetting(encryptButton);
	  		encryptButton.setBounds(160, 180, 220, 70);
	  		con1.add(encryptButton);
	  		encryptButton.addActionListener(e->{
	  			
	  			
	  			if (encryptButton==e.getSource()) {
	  				
	  				try {
	  					String simplePasswd = JOptionPane.showInputDialog("Enter your Password");
                        if (!simplePasswd.isEmpty()) {
                        	
                        	byte[] salt=PasswordEncryption.getSalt();
                        	String enpass=PasswordEncryption.SHA_1_securepassword(simplePasswd, salt);
                        	encryptPasswdArea=new JTextArea(7,4);
                        	textArea(enpass, encryptPasswdArea);
                        	 JOptionPane.showMessageDialog(con1, new JScrollPane(encryptPasswdArea), "Copy your Encrypted password", JOptionPane.INFORMATION_MESSAGE);
                        	
                        }
                        else
                        {
                        	JOptionPane.showMessageDialog(con1, "Please enter password!");
                        }
					} catch (Exception e2) {
						// TODO: handle exception
						  JOptionPane.showMessageDialog(con1, e2.getMessage(), "EXIT", JOptionPane.ERROR_MESSAGE);
					}
					
				}
	  			
	  		});
	  		
	  		
	  		//storing button
	  		
	  		storagebutton=new JButton("PASSWORD STORAGE");		
			storagebutton.setBounds(160, 280, 220, 70);
			
			con1.add(storagebutton);
			GUIButtonsSetting(storagebutton);
			storagebutton.addActionListener(e->{
				if (storagebutton==e.getSource()) {
					try {
						storingGui();
						addAccbtn.addActionListener(e4->{
							if (addAccbtn==e4.getSource()) {
								String actname=accountField.getText();
								String password=passwordField.getText();
								if (actname.isEmpty()&&password.isEmpty()) {
									JOptionPane.showMessageDialog(con2,"unable to store your password!","ERROR",JOptionPane.ERROR_MESSAGE);
									
								}
								else
								{
									String url = "jdbc:mysql://localhost:3306/swing_pm";
							        String username = "root";
							        String pass= "123456";
							        try(Connection connect=DriverManager.getConnection(url,username,pass)) {
							        	
							        	String query="INSERT INTO passwordstorage(accountName,password) VALUES (?,?)";
							        	PreparedStatement pst=connect.prepareStatement(query);
							        	
							        	
							        	
							        	pst.setString(1, actname);
							        	
							        	pst.setString(2, password);
							        	
							        	int rwIns=pst.executeUpdate();
							        	if (rwIns> 0) {
							        	     JOptionPane.showMessageDialog(con2, "Account added Successfully !");
							        	     accountField.setText(null);
							        	     passwordField.setText(null);
							        		 
											
							        	}
							        	
							        	
							        	
										
									} catch (SQLException e2) {
										// TODO: handle exception
										e2.printStackTrace();
									}
									
							      					
								}
								
								
							}
						});
						
					} catch (Exception e3) {
						JOptionPane.showMessageDialog(con2, e3.getMessage());
					}
					
				}
				
			});
			
			//searching passwords
			
			searchButton.addActionListener(e -> {
			    if (searchButton == e.getSource()) {
			        String url = "jdbc:mysql://localhost:3306/swing_pm";
			        String username = "root";
			        String pass = "123456";
			        String query = "SELECT password FROM passwordstorage WHERE accountName = ?";
			        try (Connection connection = DriverManager.getConnection(url, username, pass);
			             PreparedStatement statement = connection.prepareStatement(query)) {
			            String acc_name = JOptionPane.showInputDialog("Enter your Account Name");
			            if (acc_name != null && !acc_name.isBlank()) { // Check for null before invoking isBlank()
			                statement.setString(1, acc_name);
			                ResultSet resultSet = statement.executeQuery();
			                if (resultSet.next()) {
			                    String password = resultSet.getString("password");
			                    searchPassArea = new JTextArea(4, 5);
			                    textArea(String.valueOf(password), searchPassArea);
			                    JOptionPane.showMessageDialog(con1, new JScrollPane(searchPassArea), "Copy your password", JOptionPane.INFORMATION_MESSAGE);
			                } else {
			                    JOptionPane.showMessageDialog(con1, "Account not Found!");
			                }
			            } else {
			                JOptionPane.showMessageDialog(con1, "Please enter account name");
			            }
			        } catch (NullPointerException | SQLException e2) {
			            JOptionPane.showMessageDialog(con1, e2.getMessage(), "EXIT", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			});
			//Delete password by AccountName
			
			deleteButton=new JButton("DELETE PASSWORD");
			GUIButtonsSetting(deleteButton);
			deleteButton.setBounds(160, 480, 220, 70);
			con1.add(deleteButton);
			deleteButton.addActionListener(e -> {
			    if (deleteButton == e.getSource()) {
			        String url = "jdbc:mysql://localhost:3306/swing_pm";
			        String username = "root";
			        String pass = "123456";
			        String query = "DELETE FROM passwordstorage WHERE accountName = ?";
			        try (Connection connection = DriverManager.getConnection(url, username, pass);
			             PreparedStatement statement = connection.prepareStatement(query)) {
			            String acc_name = JOptionPane.showInputDialog("Enter the Account Name");
			            if (acc_name != null && !acc_name.isBlank()) { // Check for null before using acc_name
			                statement.setString(1, acc_name);
			                int rowsDeleted = statement.executeUpdate();
			                if (rowsDeleted > 0) {
			                    JOptionPane.showMessageDialog(con1, "Delete successfully!");
			                } else {
			                    JOptionPane.showMessageDialog(con1, "Account not Found!");
			                }
			            } else {
			                JOptionPane.showMessageDialog(con1, "Please enter account name");
			            }
			        } catch (NullPointerException | SQLException e3) {
			            JOptionPane.showMessageDialog(con1, e3.getMessage(), "EXIT", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			});

			
	  			
	  		
	  		
	  		
	  		
	    	  
	    	  
		}
	 

}
