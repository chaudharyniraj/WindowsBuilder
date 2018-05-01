package serverPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
	Socket socketForClient;
	final DataInputStream is;
	final DataOutputStream os;
	int i;
	
	ReadWriteXml xml;
	
	public ClientHandler(Socket socketForClient, DataInputStream is,DataOutputStream os,int i)
	{
		this.socketForClient = socketForClient;
		this.is=is;
		this.os=os;
		this.i=i;
	}
	
	public void run() {
		String msgDW;
		
			while(true)
		    {
				try {
					msgDW = is.readUTF();
					
					String checkDW[] = msgDW.split("#!#");
					
					
					
					if(checkDW[0].equals("deposit"))
					{
						xml = new ReadWriteXml(checkDW[2], checkDW[1]);
						if(xml.flag==true) {
							os.writeUTF("updated");
							
							System.out.println("deposit from clientH");
						}
						
						
					}
					
					
					if(checkDW[0].equals("withdraw"))
					{
						xml = new ReadWriteXml(checkDW[2], checkDW[1]);
						//if(xml.flag==true)os.writeUTF("updated");
						System.out.println("withdraw from clientH");
					}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
	}
}
