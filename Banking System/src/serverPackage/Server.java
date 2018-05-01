package serverPackage;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;



public class Server extends Thread{
static Vector<ClientHandler> ar = new Vector<>();
static int i=0;

public static void main(String args[]) {
	  		
	  ReadXML authentic = new ReadXML();
	  		System.out.println("server started.");
	  		
	  		try {
	  			ServerSocket severLogin = new ServerSocket(9876);
	  			
	  			
	  			
	  			while(true) {
	  				    	  				
	  					
	  					Socket socketForClient = severLogin.accept();
	  					
	  					
	  					DataInputStream is = new DataInputStream(socketForClient.getInputStream());
	  					DataOutputStream os = new DataOutputStream(socketForClient.getOutputStream());
	  					//input,output
	  					
	  					
	  					String username = is.readUTF();
	  					
	  					String [] info = username.split("#!#");
	  					
	  					
	  					
			  			if(info[0].equals("signUp"))
			  			{
			  				
			  				System.out.println("Sign up Sccessful.!!");
			  				
			  				writeXMLfile writeInfo = new writeXMLfile();
			  				
			  				try {
								writeInfo.writeXML(info[1], info[2], info[3], info[4],info[5]);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			  				
			  				
			  			}		
	  					
	  					
		  			
			  			else if(info[0].equals("login"))
			  			{
			  					ClientHandler client = new ClientHandler(socketForClient,is,os,i);
			  					Thread newClient = new Thread(client); 
			  					ar.add(client);
			  					
			  					newClient.start();
			  					i++;
			  					
			  					System.out.println("check1 ");
			  					
			  					String eMail = info[1];
			  					String pass = info[2];
			  					
			  					String allInfo2 = authentic.ReadXml(eMail, pass);
			  					
			  				
			  					
			  				if(authentic.flag==true)
			  				{	
			  					
			  						System.out.println("allInfo::"+allInfo2);
			  						System.out.println("check2 ");
			  						
				  					os.writeUTF("ok#!#"+allInfo2);
				  					
		  					  					
			  					
			  			    }
			  				
				  			else
				  			{
				  					os.writeUTF("loginFailed#!#username or password is incorrect");
				  					
				  			}
			  				
			  				
			  			   }
			  			
				  	
				  		else System.out.println("mra khaise!!!!!");
			  			
	  					
	  		}
	  			
	  			
	  		}catch(IOException e1) {
	  			System.out.println("connection problem occured...");
	  		}
	  }
}



