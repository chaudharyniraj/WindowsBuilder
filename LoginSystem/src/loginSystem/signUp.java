package loginSystem;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class signUp {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField pwdPassword;
	private JPasswordField pwdPassword_1;


	public void NewWindow() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(0, 204, 102));
		frame.setBounds(100, 100, 452, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGoogle = new JLabel("Google");
		lblGoogle.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 30));
		lblGoogle.setForeground(Color.BLUE);
		lblGoogle.setBounds(154, 11, 132, 49);
		frame.getContentPane().add(lblGoogle);
		
		JLabel lblFirstName = new JLabel("Username");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(49, 85, 100, 14);
		frame.getContentPane().add(lblFirstName);
		
		textField = new JTextField();
		textField.setBounds(49, 106, 353, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(49, 141, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(49, 157, 353, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(49, 188, 100, 14);
		frame.getContentPane().add(lblPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("");
		pwdPassword.setBounds(49, 210, 353, 20);
		frame.getContentPane().add(pwdPassword);
		
		pwdPassword_1 = new JPasswordField();
		pwdPassword_1.setText("");
		pwdPassword_1.setBounds(49, 241, 353, 23);
		frame.getContentPane().add(pwdPassword_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(0, 0, 0));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(49, 338, 68, 20);
		frame.getContentPane().add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(new Color(0, 0, 0));
		rdbtnMale.setFont(new Font("Segoe Print", Font.BOLD, 14));
		rdbtnMale.setBounds(154, 335, 109, 23);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Segoe Print", Font.BOLD, 14));
		rdbtnFemale.setBounds(293, 335, 109, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		ButtonGroup  radioGroup=new ButtonGroup();
		radioGroup.add(rdbtnMale);
		radioGroup.add(rdbtnFemale);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateOfBirth.setBounds(49, 369, 145, 23);
		frame.getContentPane().add(lblDateOfBirth);
		
		String year[]=new String[120];
		year[0]="Year";
		for(int i=118,j=1;i>=0;i--,j++){
			year[j]=String.valueOf(i+1900);
		}
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe Print", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(year));
		comboBox.setBounds(49, 394, 78, 20);
		frame.getContentPane().add(comboBox);
		
		String month[]={"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Segoe Print", Font.BOLD, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(month));
		comboBox_1.setBounds(196, 394, 85, 20);
		frame.getContentPane().add(comboBox_1);
		
		String day[]=new String[32];
		day[0]="Day";
		for(int i=1;i<32;i++){
			day[i]=String.valueOf(i);
		}
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Segoe Print", Font.BOLD, 14));
		comboBox_2.setModel(new DefaultComboBoxModel(day));
		comboBox_2.setBounds(313, 394, 89, 20);
		frame.getContentPane().add(comboBox_2);
		
//		JLabel lblMobileNo = new JLabel("Mobile no.");
//		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblMobileNo.setBounds(49, 275, 85, 20);
//		frame.getContentPane().add(lblMobileNo);
//		
//		textField_3 = new JTextField();
//		textField_3.setBounds(49, 304, 353, 23);
//		frame.getContentPane().add(textField_3);
//		textField_3.setColumns(10);
//		
		JButton btnSignIn = new JButton("Confirm");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showInputDialog("successful");
				String username = textField.getText();
				//String last_name = textField_1.getText();
				String email = textField_2.getText();
				String password = pwdPassword.getText();			    
				String con_password = pwdPassword_1.getText();
				
				String gender = null;
				//String mobile = textField_3.getText();
				String year = (String) comboBox.getSelectedItem();
				String month = (String) comboBox_1.getSelectedItem();
				String day = (String) comboBox_2.getSelectedItem();
				if(rdbtnMale.isSelected())
					gender = "Male";
				if(rdbtnFemale.isSelected())
					gender = "Female";
				
				//String male = rdbtnMale.getText();
				//System.out.println(male);
				//String female = rdbtnFemale.getText();
				
				int uname_len = username.length();
				int email_len = email.length();
				int password_len = password.length();
				int conPass_len = con_password.length();
//				int year_len = year.length();
//				int month_len = month.length();
//				int day_len = day.length();
				//int male_len = male.length();
				//int female_len = female.length();
				
				String user = "^[a-zA-Z0-9_]{5,14}$";
				String mail = "^[a-z0-9._]+@[a-z.]+\\.[a-z]{2,}$";
				String pass = "^[a-zA-Z0-9_]{8,14}$";
			    //if (m.find())
				
				if(uname_len>0 && email_len>0 && password_len>0 && conPass_len>0 && year!="Year" && month!="Month" && day!="Day") {
					if(rdbtnMale.isSelected() || rdbtnFemale.isSelected()) {
						JFrame f = new JFrame();
						Pattern p1 = Pattern.compile(user);
					    Matcher m1 = p1.matcher(username);
					    Pattern p2 = Pattern.compile(mail);
					    Matcher m2 = p2.matcher(email);
					    Pattern p3 = Pattern.compile(pass);
					    Matcher m3 = p3.matcher(password);
					    //Pattern p = Pattern.compile(pass);
					    Matcher m4 = p3.matcher(con_password);
					    
					    if(m1.matches() && m2.matches() && m3.matches() && m4.matches()) {
					    	
					    	if(password.equals(con_password)){
								//Details dt = new Details();
								//dt.writeToFile(username,email,password,mobile,gender,year,month,day);
								String dob = day+"/"+month+"/"+year;
								WriteXml wx = new WriteXml();
								try {
									wx.writeXML(username,email,password,gender,dob);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								JOptionPane.showMessageDialog(f, "Sucessful !!");
							}
							else
								JOptionPane.showMessageDialog(f, "Password doesnt matched");
					    }
					    else
					    	JOptionPane.showMessageDialog(null, "Your username or email or password pattern didn'd matched. "
					    			+ "Follow the pattern !!");
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Fill all the boxes !!");
				
			}
		});
		btnSignIn.setBackground(new Color(0, 102, 0));
		btnSignIn.setForeground(Color.ORANGE);
		btnSignIn.setFont(new Font("Segoe Print", Font.BOLD, 15));
		btnSignIn.setBounds(50, 443, 100, 23);
		frame.getContentPane().add(btnSignIn);
		
		JButton btnSignIn_1 = new JButton("Sign In");
		btnSignIn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login lg = new login();
				lg.initialize();
				frame.setVisible(false);
			}
		});
		btnSignIn_1.setForeground(new Color(204, 0, 255));
		btnSignIn_1.setBackground(new Color(0, 0, 153));
		btnSignIn_1.setFont(new Font("Segoe Script", Font.BOLD, 16));
		btnSignIn_1.setBounds(150, 443, 100, 23);
		frame.getContentPane().add(btnSignIn_1);
		
		JButton bInf = new JButton("ShowInf");
		bInf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Details dt = new Details();
				//dt.Read();
				//ReadXML read = new ReadXML();
				//read.ReadXml();
			}
		});
		bInf.setBounds(255, 443, 100, 23);
		frame.getContentPane().add(bInf);
		
		frame.setVisible(true);
	}
}
