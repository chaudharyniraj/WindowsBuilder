package loginSystem;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Table {

	private JFrame frame;
	
	JTable jt;
	private JButton btnBackToSign;
	public static int count =0;
	
	public void InformationTable(String username, String email, String password, String mobile, String gender, String birth) {
		frame = new JFrame();
		String column[] = {"Username","Email","Password","Mobie","Gender", "Date of Birth"};
		String [][] row= new String[10][10];

		row [count][0]=username;
		row [count][1]=email;
		row [count][2]=password;
		row [count][3]=mobile;
		row [count][4]=gender;
		row [count][5]=birth;
		count++;
			
		jt=new JTable(row,column); 
		JScrollPane sp=new JScrollPane(jt);    
	    frame.getContentPane().add(sp);
	    
	    btnBackToSign = new JButton("Back To Sign up");
	    btnBackToSign.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		signUp su = new signUp();
	    		frame.setVisible(false);
	    		su.NewWindow();
	    	}
	    });
	    btnBackToSign.setBackground(new Color(95, 158, 160));
	    sp.setRowHeaderView(btnBackToSign);
	    
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
