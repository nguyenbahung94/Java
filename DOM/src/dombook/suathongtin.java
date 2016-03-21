package dombook;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Scanner;

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


public class suathongtin {
	
	static String path="C:\\Users\\everything\\Desktop\\lap trinh huong dich vu\\DOM\\src\\dombook\\book.xml";
	 public static void main(String[] args)  {
			File file=new File(path);
			Scanner scan=new Scanner(System.in);
	        DocumentBuilderFactory build = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder;
			try {
				builder = build.newDocumentBuilder();
				 Document document=builder.parse(file);
			        Element ele=document.getDocumentElement();
			        NodeList list=ele.getChildNodes();
			        System.out.println("nhap vao id");
				      String id=scan.nextLine();
			        for(int i=0;i<list.getLength();i++){
			        	Element elstudent = (Element)document.getElementsByTagName("book").item(i);
			      if(elstudent!=null){
			    	 
			      if(elstudent.getAttribute("id").equalsIgnoreCase(id))
			      {
				        
				        Element elauthor = (Element)elstudent.getElementsByTagName("author").item(0);
				        Element eltitle = (Element) elstudent.getElementsByTagName("title").item(0);
				        Element elgenre = (Element) elstudent.getElementsByTagName("genre").item(0);
				        Element elprince = (Element) elstudent.getElementsByTagName("price").item(0);
				        Element elpusbli = (Element)elstudent.getElementsByTagName("publish_date").item(0);
				        Element elxnb = (Element)elstudent.getElementsByTagName("nxb").item(0);
				        Element elxdescrip = (Element)elstudent.getElementsByTagName("description").item(0);
				        System.out.println("nhap vao author");
					      String author=scan.nextLine();
					      System.out.println("nhap vao title");
					      String title=scan.nextLine();
					      System.out.println("nhap vao genre");
					      String genre=scan.nextLine();
					      System.out.println("nhap vao prince");
					      String prince=scan.nextLine();
					      System.out.println("nhap vao publish date");
					      String publish=scan.nextLine();
					      System.out.println("nhap vao nxb");
					      String xnb=scan.nextLine();
					      System.out.println("nhap vao description");
					      String description=scan.nextLine();
					      
				        elauthor.setTextContent(author);
				        eltitle.setTextContent(title);
				        elgenre.setTextContent(genre);
				        elprince.setTextContent(prince);
				        elpusbli.setTextContent(publish); 
				        elxnb.setTextContent(xnb);
				        elxdescrip.setTextContent(description);
			        ghi(document);
			      }
			        }
			        }
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
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
