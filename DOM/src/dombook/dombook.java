package dombook;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class dombook {
	static String path="C:\\Users\\everything\\Desktop\\lap trinh huong dich vu\\DOM\\src\\dombook\\book.xml";
	 public static void main(String[] args) {
			try {
		File inputFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
		Scanner scan=new Scanner(System.in);
		Element ele=doc.getDocumentElement();//lấy thẻ root		
		//System.out.println(ele.getNodeName());lấy tên thẻ root
		NodeList list=ele.getChildNodes();//lấy ra tat ca the con 	
		for(int i=0;i<list.getLength();i++){//duyệt mảng đọc giá trị của các thẻ con
			Node no=list.item(i);
			
			
		       
		}
		
		
		
		
		/*doc.getDocumentElement().normalize();
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("book");
		System.out.println("-------------");
	/*	for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println(nNode.getNextSibling());
			//System.out.println("\nCurrent Element: " + nNode.getNodeName());
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println(eElement.getChildNodes());
				
				
				
				
				
				
				/*if(Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent())>55000){
					System.out.println("Book Id: " + eElement.getAttribute("id"));
					System.out.println("Author: " + eElement.getElementsByTagName("author").item(0).getTextContent());
					System.out.println("Title: " + eElement.getElementsByTagName("title").item(0).getTextContent());
					System.out.println("Genre: " + eElement.getElementsByTagName("genre").item(0).getTextContent());
					System.out.println("Price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
					System.out.println("Publish Date: " + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
					System.out.println("Description: " + eElement.getElementsByTagName("description").item(0).getTextContent());
				}
				/*System.out.println("Book Id: " + eElement.getAttribute("id"));
				System.out.println("Author: " + eElement.getElementsByTagName("author").item(0).getTextContent());
				System.out.println("Title: " + eElement.getElementsByTagName("title").item(0).getTextContent());
				System.out.println("Genre: " + eElement.getElementsByTagName("genre").item(0).getTextContent());
				System.out.println("Price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
				System.out.println("Publish Date: " + eElement.getElementsByTagName("publish_date").item(0).getTextContent());
			System.out.println("Description: " + eElement.getElementsByTagName("description").item(0).getTextContent());
			}
		}*/
		
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  
	  }
}
