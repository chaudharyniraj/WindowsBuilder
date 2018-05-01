package clientPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;

public class SignUpClass {
	
	public static int counter=0;
	private JFrame frame;
	private JTextField usernameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	File file = new File("information.txt");
	private JPasswordField passwordField2;
	
	boolean isGenderSelect = false;
	
	static DataInputStream reader ;
	static DataOutputStream writer;
	private JTextField balanceF2;
	
   
	
	
	
	public SignUpClass(){

	
	
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(72, 209, 204));
		frame.setBounds(100, 100, 567, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSignIn = new JLabel("Create a new account");
		lblSignIn.setBounds(129, 47, 260, 26);
		lblSignIn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		frame.getContentPane().add(lblSignIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(66, 109, 88, 20);
		frame.getContentPane().add(lblUsername);
		
		usernameField = new JTextField();
		usernameField.setBounds(209, 106, 166, 26);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(88, 155, 66, 20);
		frame.getContentPane().add(lblEmail);
		
		emailField = new JTextField();
		emailField.setBounds(209, 143, 166, 26);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(66, 186, 86, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(209, 180, 166, 26);
		frame.getContentPane().add(passwordField);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(88, 293, 86, 26);
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblBirthday);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(209, 299, 54, 19);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14,","15","16","17","18","19","20"}));
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(273, 299, 66, 19);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Month","1","2","3","4","5","6","7","8","9","10","11","12"}));
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(350, 298, 55, 20);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Year","1996","1996","1997","1998","1999","2000"}));
		frame.getContentPane().add(comboBox_2);
		
		JRadioButton rdbtnMale = new JRadioButton("male");
		rdbtnMale.setBounds(209, 334, 55, 20);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("female");
		rdbtnFemale.setBounds(309, 334, 66, 21);
		frame.getContentPane().add(rdbtnFemale);
		
		JButton signIn2 = new JButton("Sign in");
		signIn2.setBounds(430, 50, 89, 23);
		signIn2.setBackground(new Color(0, 139, 139));
		frame.getContentPane().add(signIn2);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(90, 334, 68, 17);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblGender);
		
		JLabel lblRetypePassword = new JLabel("Re-Type password");
		lblRetypePassword.setBounds(60, 226, 136, 20);
		frame.getContentPane().add(lblRetypePassword);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(209, 218, 166, 28);
		frame.getContentPane().add(passwordField2);
		
		balanceF2 = new JTextField();
		balanceF2.setBounds(209, 258, 166, 29);
		frame.getContentPane().add(balanceF2);
		balanceF2.setColumns(10);
		
		ButtonGroup myButtonGroup = new ButtonGroup();
        myButtonGroup.add(rdbtnMale);
        myButtonGroup.add(rdbtnFemale);
        
       // if(myButtonGroup.equals(rdbtnMale))
		
		JButton signUp2 = new JButton("Sign Up");
		signUp2.setBounds(198, 373, 118, 35);
		signUp2.setBackground(new Color(0, 191, 255));
		signUp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter++;
				
				
				String blnce = balanceF2.getText();
				
				
				String username=usernameField.getText();
				String email=emailField.getText();
				String password=passwordField.getText();
				String password2=passwordField2.getText();
				
				String day = (String) comboBox.getSelectedItem();
				String month = (String) comboBox_1.getSelectedItem();
				String year = (String) comboBox_2.getSelectedItem();
				//String gendar = myButtonGroup.
				
				
				int user_len= username.length();
				int email_len = email.length();
				int pass_len = password.length();
				
				
				
				

			
				
				//String user = "^[a-zA-Z0-9_]{5,14}$";
				//String mail = "^[a-z0-9._]+@[a-z.]+\\.[a-z]{2,}$";
				//String pass = "^[a-zA-Z0-9_]{8,14}$";
				
				if(user_len>0 && email_len>0 && pass_len>0 && day!="Day" && month!="Month" && year!="Year") {
				
					//Pattern p = Pattern.compile(user);
					//Pattern p2 = Pattern.compile(mail);
					//Pattern p3 = Pattern.compile(pass);
					
					//Matcher m1 = p.matcher(username);
					//Matcher m2 = p.matcher(email);
					//Matcher m3 = p.matcher(password);
					
					
					//System.out.println("username check "+m1.find());
					//System.out.println("mail check "+m2.find());
					//System.out.println("pass check "+m3.find());
					
					//int []arr = new int[3];
					
					//if(m1.find() && m2.find() && m3.find()) {
				
					
								//2222222222222222222222222222222222222222222222222
								if(password.equals(password2)) {
									
									
									try {
										//xmlFile.writeXML(username,email,password,gendar, day+"/"+month+"/"+year);
										Socket socket = new Socket("localhost", 9876);
										writer = new DataOutputStream(socket.getOutputStream());
										
										writer.writeUTF("signUp"+"#!#"+username+"#!#"+email+"#!#"+password+"#!#"+blnce+"#!#"+day+"/"+month+"/"+year);
										
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
									
								}
				
								else JOptionPane.showMessageDialog(frame,"Password missmatched...");
								//222222222222222222222222222222222222222222222222222
								
					//}
					
					//else JOptionPane.showMessageDialog(frame, "username or email or password is't fill up in a proper way..");
			
				}
				
				else JOptionPane.showMessageDialog(frame, "Please fill up all the field.");
			}
		});
		signUp2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(signUp2);
		
		
		
		JLabel lblNewLabel = new JLabel("initial balance");
		lblNewLabel.setBounds(60, 258, 136, 23);
		frame.getContentPane().add(lblNewLabel);
		
		
		signIn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Client signUp = new Client();
				//signUp.createAccount();
				
			}
		});
		
	}
}
