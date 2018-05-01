package clientPackage;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientActivity {

	private JFrame frame;

	Socket socketClient;
	
	final DataInputStream is;
	final DataOutputStream os;
	
	private String msg;
	private JTextField usernameField;
	private JTextField emailFeild;
	private JLabel lblEmail;
	private JTextField birthDayField;
	private JLabel lblBalance;
	private JTextField balanceField;
	private String eMail,passWord;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientActivity window = new ClientActivity(null, null, null,null,null,null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public ClientActivity(Socket socketClient, DataInputStream is,DataOutputStream os,String msg, String eMail, String passWord) {
		
		this.socketClient = socketClient;
		this.is = is;
		this.os = os;
		this.msg = msg;
		this.eMail=eMail;
		this.passWord = passWord;
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(58, 73, 125, 19);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblMyAccount = new JLabel("My Account ");
		lblMyAccount.setBounds(160, 27, 114, 19);
		lblMyAccount.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		frame.getContentPane().add(lblMyAccount);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(217, 74, 70, 17);
		frame.getContentPane().add(lblName);
		
		emailFeild = new JTextField();
		emailFeild.setBounds(58, 104, 125, 19);
		frame.getContentPane().add(emailFeild);
		emailFeild.setColumns(10);
		
		lblEmail = new JLabel("email");
		lblEmail.setBounds(217, 103, 70, 15);
		frame.getContentPane().add(lblEmail);
		
		birthDayField = new JTextField();
		birthDayField.setBounds(58, 135, 125, 19);
		frame.getContentPane().add(birthDayField);
		birthDayField.setColumns(10);
		
		lblBalance = new JLabel("birthday");
		lblBalance.setBounds(217, 137, 70, 15);
		frame.getContentPane().add(lblBalance);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(58, 245, 117, 25);
		
		
		
		
		//Deposit.........................................................
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String depositMoney = JOptionPane.showInputDialog("Deposit Amount");
				 
				
				 String moneyF = balanceField.getText();
				 
				 int fMoney = Integer.parseInt(moneyF);
				 int wMoney = Integer.parseInt(depositMoney);
				 int newMoney = fMoney+wMoney;
				 
				 String blnce = ""+newMoney;
				 
				try {
					os.writeUTF("deposit#!#"+blnce+"#!#"+eMail);
					balanceField.setText(blnce);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(btnDeposit);
		
		
		//withdraw................................................................
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				 String WithdrawMoney = JOptionPane.showInputDialog("Withdraw Amount");
				 String moneyF = balanceField.getText();
				 
				 int fMoney = Integer.parseInt(moneyF);
				 int wMoney = Integer.parseInt(WithdrawMoney);
				 int newMoney = fMoney-wMoney;
				 String blnce = ""+newMoney;
				 
				 try {
					if(newMoney>=0) { 
					   os.writeUTF("withdraw#!#"+blnce+"#!#"+eMail);
					   
					 
					  
						   balanceField.setText(blnce);
					  
					}
					else JOptionPane.showMessageDialog(frame, "You havem't enough balance..");
					
				 } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//..........................................................................
		
		
		
		btnWithdraw.setBounds(238, 245, 117, 25);
		frame.getContentPane().add(btnWithdraw);
		frame.setVisible(true);
		
		balanceField = new JTextField();
		balanceField.setBounds(58, 183, 125, 19);
		frame.getContentPane().add(balanceField);
		balanceField.setColumns(10);
		
		JLabel lblGendar = new JLabel("Balance");
		lblGendar.setBounds(217, 185, 70, 15);
		frame.getContentPane().add(lblGendar);
	
		
        String initialMsg[] = msg.split("#!#");
		
		usernameField.setText(initialMsg[1]);
		emailFeild.setText(initialMsg[2]);
		birthDayField.setText(initialMsg[3]);
		balanceField.setText(initialMsg[4]);
		
		
		
		
	}
}
