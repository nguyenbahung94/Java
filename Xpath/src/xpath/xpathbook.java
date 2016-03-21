package xpath;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xpathbook {
	public static void main(String args[]){
		File inputFile = new File("C:\\Users\\everything\\Desktop\\lap trinh huong dich vu\\Xpath\\src\\xpath\\book.xml");
	    DocumentBuilderFactory dbFactory 
	       = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder;

	    try {
			dBuilder = dbFactory.newDocumentBuilder();
			 Document doc = dBuilder.parse(inputFile);
			    doc.getDocumentElement().normalize();
			    XPath xPathss =  XPathFactory.newInstance().newXPath();
			    String expression="/catalog/book";
			    NodeList nodelist=(NodeList)xPathss.compile(expression).evaluate(doc, XPathConstants.NODESET);
			    for(int i=0;i<nodelist.getLength();i++){
			    	Node item=nodelist.item(i);
			    	 System.out.println("id: " + xPathss.compile("./@id").evaluate(item));//danh sách các id
			    	
			    	
			    }
			    System.out.println("-----------------------------------------------------------------");
			    //lấy ra nội dung của author
			    expression="//book/author";
			    XPathExpression xpathnew = xPathss.compile(expression);
			    NodeList result= (NodeList) xpathnew.evaluate(doc, XPathConstants.NODESET);
	            for(int i=0; i< result.getLength(); i++){
	                Node n= result.item(i);
	                System.out.println("author="+n.getTextContent());
	            }
	            System.out.println("-----------------------------------------------------------------");
	            //lấy toàn bộ nội dung
	            String expression1="/catalog";
			    NodeList nodelist1=(NodeList)xPathss.compile(expression).evaluate(doc, XPathConstants.NODESET);
			    for(int j=0;j<nodelist.getLength();j++){
			    	Node item=nodelist.item(j);
			    	if(item instanceof Element){
			    		System.out.println("author= "+((Element) item).getElementsByTagName("author").item(0).getTextContent());
			    		System.out.println("title= "+((Element) item).getElementsByTagName("title").item(0).getTextContent());
			    		System.out.println("genre= "+((Element) item).getElementsByTagName("genre").item(0).getTextContent());
			    		System.out.println("price= "+((Element) item).getElementsByTagName("price").item(0).getTextContent());
			    		System.out.println("publish_date= "+((Element) item).getElementsByTagName("publish_date").item(0).getTextContent());
			    		System.out.println("description= "+((Element) item).getElementsByTagName("description").item(0).getTextContent());

			    		
			    	}
			    	
			    	
			    }
	            
	                
			    
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   
	}
}
