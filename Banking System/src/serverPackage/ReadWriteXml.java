package serverPackage;



import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class ReadWriteXml{
	static boolean flag =false;
	
	public ReadWriteXml(String email,String UpdateBalance) {
		
		String filePath = "details.xml";
	    File xmlFile = new File(filePath);
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder;
	    
	    try {
	        dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(xmlFile);
	        doc.getDocumentElement().normalize();
	        
	        //update attribute value
	        //updateAttributeValue(doc);
	        
	        //update Element value
	        updateElementValue(doc,email,UpdateBalance);
	        
	        //delete element
	        //deleteElement(doc);
	        
	        //add new element
	        //addElement(doc);
	        
	        //write the updated document to file or console
	        doc.getDocumentElement().normalize();
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        
	        StreamResult result = new StreamResult(new File("details.xml"));
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.transform(source, result);
	        System.out.println("XML file updated successfully");
	        
	        
	    } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
	        e1.printStackTrace();
	    }
	}
	

	private static void addElement(Document doc) {
	    NodeList employees = doc.getElementsByTagName("Account");
	    Element emp = null;
	    
	    //loop for each employee
	    for(int i=0; i<employees.getLength();i++){
	        emp = (Element) employees.item(i);
	        Element salaryElement = doc.createElement("salary");
	        salaryElement.appendChild(doc.createTextNode("10000"));
	        emp.appendChild(salaryElement);
	    }
	}

	private static void deleteElement(Document doc) {
	    NodeList employees = doc.getElementsByTagName("Account");
	    Element emp = null;
	    //loop for each employee
	    for(int i=0; i<employees.getLength();i++){
	        emp = (Element) employees.item(i);
	        Node genderNode = emp.getElementsByTagName("gender").item(0);
	        emp.removeChild(genderNode);
	    }
	    
	}

	private static void updateElementValue(Document doc,String email,String UpdateBalance) {
	    NodeList employees = doc.getElementsByTagName("Account");
	    Element emp = null;
	    //loop for each employee
	    for(int i=0; i<employees.getLength();i++){
	        emp = (Element) employees.item(i);
	        
	        Node balance = emp.getElementsByTagName("balance").item(0).getFirstChild();
	        
	        String s1=emp.getElementsByTagName("Email").item(0).getTextContent();
	        
			if(s1.equals(email)) 
			{
	            balance.setNodeValue(UpdateBalance);
	            System.out.println("Balance Updated");
	            flag=true;
	            break;
			}     
	        
	    }
	}

	private static void updateAttributeValue(Document doc) {
	    NodeList employees = doc.getElementsByTagName("Account");
	    Element emp = null;
	    //loop for each employee
	    for(int i=0; i<employees.getLength();i++){
	        emp = (Element) employees.item(i);
	        String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
	        if(gender.equalsIgnoreCase("male")){
	            //prefix id attribute with M
	            emp.setAttribute("id", "M"+emp.getAttribute("id"));
	        }else{
	            //prefix id attribute with F
	            emp.setAttribute("id", "F"+emp.getAttribute("id"));
	        }
	    }
	}

}
