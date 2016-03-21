package dom;

import java.io.File;
import java.io.FileInputStream;
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
import org.xml.sax.SAXException;

public class suathongtin {
	static String path="src\\dom\\onenew.xml";
	 public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {
			File file=new File(path);
	        DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = build.newDocumentBuilder();
	        Document document=builder.parse(file);
	        // Sửa thông tin vị trí của bộ phận: 
	        Element elstudent = (Element)document.getElementsByTagName("student").item(0);
	        
	       // System.out.println(elstudent.getAttribute("studentId"));
	          elstudent.setAttribute("studentId", "ss01");
	          elstudent.setAttribute("gender", "boy");
	        
	        Element elname = (Element)elstudent.getElementsByTagName("name").item(0);
	        Element elage = (Element) elstudent.getElementsByTagName("age").item(0);
	        elname.setTextContent("nguyen ba hung");
	        elage.setTextContent("44");
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
