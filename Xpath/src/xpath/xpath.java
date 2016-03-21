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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xpath {
public static void main(String args[]){
	File inputFile = new File("src\\xpath\\onenew.xml");
    DocumentBuilderFactory dbFactory 
       = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;

    try {
		dBuilder = dbFactory.newDocumentBuilder();
		 Document doc = dBuilder.parse(inputFile);
		    doc.getDocumentElement().normalize();
		    XPath xPath =  XPathFactory.newInstance().newXPath();
		    String expression="//studentkind/@id";
		    NodeList nodelist=(NodeList)xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
		    System.out.println(nodelist.getLength());//lấy value của 1 nót VD:giá trị của id student  /String expression="//student/@studentId";
		    //for(int i=0;i<nodelist.getLength();i++){
		    //	Node nNode=nodelist.item(i);
		  //  	System.out.println(nNode.getNodeName()+nNode.getTextContent()+nNode.getAttributes().item(0)+nNode.getAttributes().item(1));
		    	/*if(nNode.getNodeType()==Node.ELEMENT_NODE){
		    		Element eElement=(Element)nNode;
		    		System.out.println(eElement.getAttribute("studentId"));
		    		System.out.println(eElement.getElementsByTagName("name").item(0).getTextContent());
		    		System.out.println(eElement.getElementsByTagName("age").item(0).getTextContent());
		    	}*/
		 //  }
		    
		    
		    
		    
		    
		    
		    expression= "//student/age='30'";
            XPathExpression expr = xPath.compile(expression);
            
            NodeList result= (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for(int i=0; i< result.getLength(); i++){
                Node n= result.item(i);
              
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
