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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class them1element {
	static String path="C:\\Users\\everything\\Desktop\\lap trinh huong dich vu\\DOM\\src\\dombook\\book.xml";
	 public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {
			File file=new File(path);
	        DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = build.newDocumentBuilder();
	        Document document=builder.parse(file);
	        NodeList nodeList = document.getElementsByTagName("book");
	        System.out.println(nodeList.getLength()+"////////////");
	        Element new_element = document.createElement("book");
	        nodeList.item(0).getParentNode().insertBefore(new_element, nodeList.item(0));
	        new_element.setAttribute("id", "new001");
	        Element newauthor=document.createElement("author");
	        newauthor.setTextContent("Pauwalker");
	        Element newtitle=document.createElement("title");
	        newtitle.setTextContent("Nhà Nguyễn");
	        Element newprice=document.createElement("price");
	        newprice.setTextContent("59.000");
	        Element newpublish=document.createElement("publish_date");
	        newpublish.setTextContent("2013-12-1");
	        Element newdescription=document.createElement("description");
	        newdescription.setTextContent("	Ngày xưa xưa xưa xưa xưa xưa xưa xưa xưa xưa");
	       
	        new_element.appendChild(newauthor);
	        new_element.appendChild(newtitle);
	        new_element.appendChild(newprice);
	        new_element.appendChild(newpublish);
	        new_element.appendChild(newdescription);
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
	        // Output to console for testing
	        Writer output = new StringWriter();
	        StreamResult consoleResult = new StreamResult(output);
	        transformer.transform(source, consoleResult);
	        System.out.println(output.toString());

	    }
}
