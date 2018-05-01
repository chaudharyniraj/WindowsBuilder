package clientPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Client {
	Socket clientSoc;

	DataInputStream reader;
	DataOutputStream writer;
	Thread receive;
	private JFrame frame;
	private JTextField email;
	private JPasswordField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Client() {
		
		
		
		
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblBankAccount = new JLabel("Bank Account");
		lblBankAccount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblBankAccount.setBounds(152, 30, 161, 19);
		frame.getContentPane().add(lblBankAccount);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpClass signUp = new SignUpClass();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(149, 178, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					clientSoc = new Socket("localhost",9876);
					writer = new DataOutputStream(clientSoc.getOutputStream());
					reader = new DataInputStream(clientSoc.getInputStream());
					
					String eMail = email.getText();
					String pass = password.getText();
					
					writer.writeUTF("login#!#"+eMail+"#!#"+pass);
					//writer.flush();
					

					receive = new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							while(true){
								try {
									String msg = reader.readUTF();
									String msg2[] = msg.split("#!#");
									
									if(msg2[0].equals("ok")){
										//JOptionPane.showMessageDialog(frame, msg);
										frame.setVisible(false);
										
										
										ClientActivity ca = new ClientActivity(clientSoc,reader,writer,msg, eMail, pass);
										
										
									}
									
									//else JOptionPane.showMessageDialog(frame, msg2[1]);
									
								} catch (IOException e){
									// TODO Auto-generated catch block
									//e.printStackTrace();
									System.out.println("Problem in receiving...");
								}
							}
							
						}
					});
					
					receive.start();
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(329, 79, 95, 25);
		frame.getContentPane().add(btnLogin);
		
		email = new JTextField();
		email.setBounds(54, 82, 144, 19);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(212, 82, 95, 19);
		frame.getContentPane().add(password);
		
		JLabel lblEmail = new JLabel("e -mail");
		lblEmail.setBounds(64, 102, 134, 19);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(222, 113, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		
		
		
	}
}
