package loginSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 204));
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGoogle = new JLabel("Google");
		lblGoogle.setForeground(Color.BLUE);
		lblGoogle.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 30));
		lblGoogle.setBounds(165, 11, 128, 68);
		frame.getContentPane().add(lblGoogle);
		
		JLabel lblNewLabel = new JLabel("One account. All of Google");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblNewLabel.setBounds(101, 71, 283, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEmail.setBounds(58, 147, 49, 14);
		frame.getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(58, 165, 270, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewLabel_1.setBounds(58, 201, 79, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("");
		pwdPassword.setBounds(58, 226, 270, 25);
		frame.getContentPane().add(pwdPassword);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email = textField.getText();
				String password = pwdPassword.getText();
				
				ReadXML read = new ReadXML();
				read.ReadXml(email,password);
				
				if( read.flag==true) {
					JOptionPane.showMessageDialog(null, "Login Sucessful !!");
				}
				else {
					JOptionPane.showMessageDialog(null, "email or password is incorrect !!");
				}
//				BufferedReader br = null;
//				FileReader fr = null;
//				
//				try {
//					String FILENAME = "information.txt";
//					fr = new FileReader(FILENAME);
//					br = new BufferedReader(fr);
//
//					String sCurrentLine;
//
//					br = new BufferedReader(fr);
//
//					while ((sCurrentLine = br.readLine()) != null) {
//						
//						String[] inf = sCurrentLine.split(",");
//						
//						if(inf[1].equals(email) && inf[2].equals(password)){
//							JOptionPane.showMessageDialog(null, "Sucessful !!");
//						}
//						else
//							JOptionPane.showMessageDialog(null, "Password or Email not matched");
//						
//						//System.out.println(sCurrentLine);
//					}
//					
//					if (br != null)
//						br.close();
//
//					if (fr != null)
//						fr.close();
//					
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}
		});
		btnSignIn.setBackground(new Color(51, 102, 255));
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		btnSignIn.setBounds(58, 263, 107, 23);
		frame.getContentPane().add(btnSignIn);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signUp sup = new signUp();
				sup.NewWindow();
				frame.setVisible(false);
			}
		});
		
		btnNewButton.setBackground(new Color(153, 0, 102));
		btnNewButton.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(230, 262, 98, 23);
		frame.getContentPane().add(btnNewButton);
		
		frame.setVisible(true);
	}
}
