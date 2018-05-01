package serverPackage;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class ReadXML {
		
	public String eMail;
	public String pass;
	public String allInfo;
	public static boolean flag; 
	
	
	public String ReadXml(String eMail, String password ){
		
		this.eMail=eMail;
		this.pass=password;
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document du = null;
		try {
			du = db.parse(new File("details.xml"));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		Element element= du.getDocumentElement();
			
		NodeList list=element.getChildNodes();
		checkUserNameandPassword(list);
		return allInfo;//......................................................
		
					
	}

	private void	checkUserNameandPassword(NodeList list){
			
		for(int i=0;i<list.getLength();i++) {
					
			Node node=list.item(i);
			
			if(node.getNodeType()==Node.ELEMENT_NODE) {
						
				Element element1=(Element) node;
				
				String s1=element1.getElementsByTagName("Email").item(0).getTextContent();
				String s2=element1.getElementsByTagName("password").item(0).getTextContent();
				
				if(s1.equals(eMail)&&s2.equals(pass)) {
					System.out.println("matched...");
					flag=true;
					
					
					
					String username = element1.getElementsByTagName("userName").item(0).getTextContent();
					String eMail = element1.getElementsByTagName("Email").item(0).getTextContent();
					String passWord = element1.getElementsByTagName("password").item(0).getTextContent();
					String balance2 = element1.getElementsByTagName("balance").item(0).getTextContent();
					String birth =  element1.getElementsByTagName("dateOfBirth").item(0).getTextContent();
							
					allInfo = username+"#!#"+eMail+"#!#"+birth+"#!#"+balance2;
					
					
					
					
					return;
				}
				
				else 	System.out.println("username or password incorrect...");
				
				
											
			}
		}
		
		flag=false;
	}

}
