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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class themthongtin {

	static String path="src\\dom\\onenew.xml";
	 public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {
			File file=new File(path);
	        DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = build.newDocumentBuilder();
	        Document document=builder.parse(file);
	        NodeList nodeList = document.getElementsByTagName("student");
	        System.out.println(nodeList.getLength()+"////////////");
	        Element new_element = document.createElement("studentkind");
	        nodeList.item(0).getParentNode().insertBefore(new_element, nodeList.item(0));
	        System.out.println(nodeList.getLength());
	        new_element.setAttribute("id", "sssss");
	        Element newname=document.createElement("name");
	        newname.setTextContent("nguyen van sssss");
	        Element newage=document.createElement("age");
	        newage.setTextContent("ss40");
	        new_element.appendChild(newname);
	        new_element.appendChild(newage);
	        ghi(document);
	    }
	
	
	
	  public static final void ghi(Document xml) throws Exception {
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource source = new DOMSource(xml);
	        StreamResult result = new StreamResult(new File("src\\dom\\onenew1.xml"));
	        transformer.transform(source, result);
	        // Output to console for testing
	        Writer output = new StringWriter();
	        StreamResult consoleResult = new StreamResult(output);
	        transformer.transform(source, consoleResult);
	        System.out.println(output.toString());

	    }
}
