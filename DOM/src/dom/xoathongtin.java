package dom;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xoathongtin {

	static String path="src\\dom\\onenew.xml";
	 public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {
			File file=new File(path);
	        DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = build.newDocumentBuilder();
	        Document document=builder.parse(file);
	         
	       /* NodeList Liststudent = document.getElementsByTagName("student");//xoa 1 node voi studentId=s01
	        for(int i = 0; i<Liststudent.getLength(); i++){
	            Node nodess = Liststudent.item(i);
	            if (nodess.getNodeType() == Node.ELEMENT_NODE){
	                Element el_student= (Element)nodess;
	                if(el_student.getAttribute("studentId").equalsIgnoreCase("s01")){
	                    el_student.getParentNode().removeChild(el_student);
	                }
	            }
	        }*/
	        
	        NodeList Liststudent = document.getElementsByTagName("student");
	        for(int i = 0; i<Liststudent.getLength(); i++){
	            Node node_student = Liststudent.item(i);
	            if (node_student.getNodeType() == Node.ELEMENT_NODE){
	                Element el_student = (Element)node_student;
	                System.out.println(el_student.getAttribute("studentId"));
	                if(el_student.getAttribute("studenId").equalsIgnoreCase("s02")){
	                    Element el_name = (Element) el_student.getElementsByTagName("name");
	                    el_student.removeChild(el_name);
	                }
	            }
	        }
	        ghi(document);
	    }
	
	
	
	
	 public static final void ghi(Document xml) throws Exception {
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource source = new DOMSource(xml);
	        StreamResult result = new StreamResult(new File("src\\dom\\onenew2.xml"));
	        transformer.transform(source, result);
	        // Output to console for testing
	        Writer output = new StringWriter();
	        StreamResult consoleResult = new StreamResult(output);
	        transformer.transform(source, consoleResult);
	        System.out.println(output.toString());

	    }
}
