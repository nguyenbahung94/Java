package dombook;

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

public class xoa {
	static String path="C:\\Users\\everything\\Desktop\\lap trinh huong dich vu\\DOM\\src\\dombook\\book.xml";
	 public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {
			File file=new File(path);
	        DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = build.newDocumentBuilder();
	        Document document=builder.parse(file);
	        NodeList Liststudent = document.getElementsByTagName("book");
	        for(int i = 0; i<Liststudent.getLength(); i++){
	            Node nodess = Liststudent.item(i);
	            if (nodess.getNodeType() == Node.ELEMENT_NODE){
	                
	                
	                
	               
	       
	        }
	        ghi(document);
	    }
	
	
	
	  public static final void ghi(Document xml) throws Exception {
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource source = new DOMSource(xml);
	        StreamResult result = new StreamResult(new File("src\\dom\\book1.xml"));
	        transformer.transform(source, result);
	        Writer output = new StringWriter();
	        StreamResult consoleResult = new StreamResult(output);
	        transformer.transform(source, consoleResult);
	        System.out.println(output.toString());

	    }
}
