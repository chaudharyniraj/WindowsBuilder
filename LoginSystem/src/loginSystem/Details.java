package loginSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Details {
	
	private String FILENAME = "information.txt";
	
	public void  writeToFile(String username, String email, String password, String mobile, String gender, String year,String month, String day) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content =username+","+email+","+password+","+mobile+"," +gender+","+year+"/"+month+"/"+day+"\n";

			//open filewriter as write mode
			//fw = new FileWriter(FILENAME);
			
			//open filewriter as append mode
			fw = new FileWriter(FILENAME, true);			
			bw = new BufferedWriter(fw);
			bw.write(content);
			
			//System.out.println("Informations\n" +content);				
			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
	
	
	public void Read() {
		
		Table tb = new Table();
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			sCurrentLine = br.readLine();
				
			while (sCurrentLine!=null) {
				
				String[] inf = sCurrentLine.split(",");
				
				String username = inf[0];
				String email = inf[1];
				String password= inf[2];
				String mobile = inf[3];
				String gender = inf[4];
				String date = inf[5];
				
				System.out.println(username+email+password);
				
				
				
				tb.InformationTable(username,email,password,mobile,gender,date);
				
				sCurrentLine = br.readLine();
			}
						
			if (br != null)
				br.close();
			if (fr != null)
				fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
