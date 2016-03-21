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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class domtest {
	static String path="C:\\Users\\everything\\Desktop\\lap trinh huong dich vu\\DOM\\src\\dombook\\book.xml";
 public static void main(String[] args){
	 DocumentBuilderFactory fap=DocumentBuilderFactory.newInstance();
	 try {
		DocumentBuilder build=fap.newDocumentBuilder();
		File file=new File(path);
		try {
			Document document=build.parse(file);//đối tượng document là thể hiện quả file
			Element ele=document.getDocumentElement();//lấy thẻ root		
			//System.out.println(ele.getNodeName());lấy tên thẻ root
			NodeList list=ele.getChildNodes();//lấy ra tat ca the con 	
			for(int i=0;i<list.getLength();i++){//duyệt mảng đọc giá trị của các thẻ con
				Node no=list.item(i);
				System.out.println(no.getNodeValue());
				if(no instanceof Element){
					Element employ=(Element)no;
					//System.out.println(employ.getAttribute("studentId"));
			       //System.out.println(employ.getTagName());
			        if(employ.getAttribute("id").equals("bk001")){
			        	NodeList newlist= employ.getChildNodes();
			        	for(int j=0;j<newlist.getLength();j++){
			        		Node nodes=newlist.item(j);
			        		//System.out.println(nodes.getTextContent());//lấy ra nội dung của các thẻ con bên trong
			        		if(nodes instanceof Element){
			        		Element employss=(Element)nodes;
			        		
			        			System.out.println(employss.getAttribute("id"));
							
			        		}
			        	}
			        }
					
					if(employ.getAttribute("id").equals("s002")){
						NodeList ss1=employ.getElementsByTagName("name");//lấy tag name bên trong employ
						//String ssnew=ss1.item(0).getTextContent();
						//System.out.println(ssnew);
						ss1=employ.getElementsByTagName("age");//lấy tag age bên trong employ
						String ssage=ss1.item(0).getTextContent();//lấy nội dung bên trong tag age
						//System.out.println(ssage);
					}
				}
					
			}
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
}
